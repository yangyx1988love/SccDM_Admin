package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.Status;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.service.FactoryService;
import nankai.xl.business.service.FileService;
import nankai.xl.business.service.SelectCommonService;
import nankai.xl.business.service.SourceService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.*;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Menu;
import nankai.xl.system.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FilesController {
    @Resource
    private MenuService menuService;
    @Resource
    private SourceService sourceService;
    @Resource
    private FileService fileService;
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private FactoryService factoryService;

    @OperationLog("源文件管理-文件下载")
    @GetMapping("/down/index")
    public String temple() {
        return "files/temple-list";
    }
    @OperationLog("源文件管理-文件模板列表")
    @GetMapping("/temple/list")
    @ResponseBody
    public PageResultBean<Menu> getList() {

        List<Menu> menus= menuService.selectSourceMeus(100000);
        List<Menu> results=new ArrayList<>();
        for (Menu menu:menus) {
            results.addAll(menuService.selectSourceMeus(menu.getMenuId()));
        }
        PageInfo<Menu> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @RequestMapping(value = "/temple/down", method = RequestMethod.GET, produces ="application/json;charset=UTF-8")
    public ResponseEntity<byte[]> downloadExcel(String name) throws IOException {
        File file=null;
        try {
            file = ResourceUtils.getFile("classpath:examples/"+name+".xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseUtils.buildResponseEntity(file);
    }
    @OperationLog("源文件管理-文件上传")
    @GetMapping("/up/index")
    public String fileUp(Model model) {
        List<Menu> sourceMeus=menuService.selectSourceMeus(100000);
        model.addAttribute("sourceMeus", sourceMeus);
        model.addAttribute("childMeus",menuService.selectByParentId(sourceMeus.get(0).getMenuId()));
        return "files/file-up";
    }
    @OperationLog("源文件上传")
    @PostMapping("/upload")
    @ResponseBody
    public ResultBean upload(@RequestParam("file") MultipartFile[] files, String childMenuId,boolean isCul){
        if (files.length==0||childMenuId.length()==0){
            return ResultBean.error("文件不存在或者未选择源类型！请重新上传！");
        }else{
            List<String[]> lists=new ArrayList<>();
            int num=0;
            try {
                for (MultipartFile file:files) {
                    List<String[]> list=ReadExcel.readExcel(file,0);
                    if (list!=null){
                        lists.addAll(list);
                    }
                }
                if (lists.size()>0){
                    num=fileService.importTempleFileToSource(childMenuId,lists,isCul);
                }else {
                    return ResultBean.error("无数据，请查看文件！！");
                }
            } catch (Exception e) {
                if (e.getMessage().contains("Mysql")||e.getMessage().contains("jdbc")){
                    if (e.getMessage().contains("Duplicate")){
                        return ResultBean.error("数据重复！！违反唯一性条件");
                    }else {
                        return ResultBean.error("数据更新错误！！");
                    }
                }else{
                    return ResultBean.error(e.getMessage());
                }
            }
            return ResultBean.success("共导入:"+num+"数据，导入失败："+(lists.size()-num)+"条数据");
        }
    }
    @OperationLog("企业管理-上传-文件分类联级选择")
    @PostMapping("/up/soure/{menuId}")
    @ResponseBody
    public List<Menu> seleCountry(@PathVariable("menuId") Integer menuId) {
        List<Menu> childMeus=menuService.selectByParentId(menuId);
        return childMeus;
    }
    @OperationLog("企业管理-上传")
    @GetMapping("/up/factory")
    public String factoryUp(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "files/factory-up";
    }
    @OperationLog("企业上传")
    @PostMapping("/upload/factory")
    @ResponseBody
    public ResultBean factoryUpload(@RequestParam("file") MultipartFile[] files, FactoryQuery factoryQuery){
        if (files.length==0){
            return ResultBean.error("文件不存在或者未选择源类型！请重新上传！");
        }else{
            int num=0;
            List<String[]> lists=new ArrayList<>();
            try {
                for (MultipartFile file:files) {
                    List<String[]> list=ReadExcel.readExcel(file,0);
                    if (list!=null){
                        lists.addAll(list);
                    }
                }
                if (lists.size()>0){
                    num=fileService.importTempleFileToFactory(factoryQuery,lists);
                }else {
                    return ResultBean.error("无数据，请查看文件！！");
                }
            } catch (Exception e) {
                return ResultBean.error(e.getMessage());
            }
            return ResultBean.success("共导入:"+num+"数据，导入失败："+(lists.size()-num)+"条数据");
        }
    }

}
