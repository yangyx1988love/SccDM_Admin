package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.service.FileService;
import nankai.xl.business.service.SourceService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ReadExcel;
import nankai.xl.common.util.ResponseUtils;
import nankai.xl.common.util.ResultBean;
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

@Controller
@RequestMapping("/file")
public class FilesController {
    @Resource
    private MenuService menuService;
    @Resource
    private SourceService sourceService;
    @Resource
    private FileService fileService;

    @OperationLog("文件管理-文件下载")
    @GetMapping("/down/index")
    public String temple(Model model) {
        return "files/temple-list";
    }
    @OperationLog("文件管理-文件模板列表")
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
    public ResponseEntity<byte[]> downloadExcel(String name, HttpServletResponse response, HttpServletRequest request) throws IOException {
        File file=null;
        try {
            file = ResourceUtils.getFile("classpath:examples/"+name+".xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseUtils.buildResponseEntity(file);
    }
    @OperationLog("文件管理-文件上传")
    @GetMapping("/up/index")
    public String fileUp(Model model) {
        List<Menu> sourceMeus=menuService.selectSourceMeus(100000);
        model.addAttribute("sourceMeus", sourceMeus);
        model.addAttribute("childMeus",menuService.selectByParentId(sourceMeus.get(0).getMenuId()));
        return "files/file-up";
    }
    @OperationLog("新增企业用户")
    @PostMapping("/upload")
    @ResponseBody
    public ResultBean upload(@RequestParam("file") MultipartFile[] files, String childMenuId,boolean isCul) throws Exception{
        if (files.length==0||childMenuId.length()==0){
            throw new Exception("文件不存在或者未选择源类型！请重新上传！");
        }else{
            List<String[]> lists=new ArrayList<>();
            for (MultipartFile file:files) {
                lists.addAll(ReadExcel.readExcel(file));
            }
            int num=fileService.importTempleFileToSource(childMenuId,lists,isCul);

            if(lists.size()-num>0){
                return ResultBean.error("共导入:"+num+"数据，导入失败："+(lists.size()-num)+"条数据");
            }
            return ResultBean.success("共导入:"+num+"数据，导入失败："+(lists.size()-num)+"条数据");
        }
    }
    @OperationLog("文件管理-上传-文件分类联级选择")
    @PostMapping("/up/soure/{menuId}")
    @ResponseBody
    public List<Menu> seleCountry(@PathVariable("menuId") Integer menuId) {
        List<Menu> childMeus=menuService.selectByParentId(menuId);
        return childMeus;
    }
}
