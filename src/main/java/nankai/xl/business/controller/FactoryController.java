package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.model.vo.FactoryVo;
import nankai.xl.business.service.SelectCommonService;
import nankai.xl.business.service.FactoryService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ResultBean;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.common.validate.groups.Create;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Dept;
import nankai.xl.system.service.DeptService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/factory")
public class
FactoryController {

    @Resource
    private FactoryService factoryService;
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private DeptService deptService;

    @GetMapping("/index")
    public String index(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            Dept dept=deptService.selectByPrimaryKey(user.getDeptId());
            List<City> citys=new ArrayList<>();
            List<County> countys=new ArrayList<>();
            if (dept.getDeptLevel()==1){
                citys=selectCommonService.getAllCitys();
                countys=selectCommonService.getAllCountys();
            }
            if (dept.getDeptLevel()==2){
                City city=selectCommonService.getCityByCode(dept.getDeptId());
                citys.add(city);
                countys=selectCommonService.getCountysByCityCode(city.getCityCode());
            }
            if (dept.getDeptLevel()==3){
                County county=selectCommonService.getCountyById(dept.getDeptId());
                countys.add(county);
            }
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", countys);
            model.addAttribute("citys", citys);
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factory/factory-list";
    }

    @OperationLog("查看工厂列表")
    @GetMapping("/list")
    @ResponseBody
    public PageResultBean<Factory> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")String limit) {
        if (limit.equals("_")){
            System.out.println("");
        }
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<Factory> pageInfo = new PageInfo<>(factoryService.getFactorysByuser(user,page,Integer.parseInt(limit)));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("查看工厂列表")
    @GetMapping("/reload")
    @ResponseBody
    public PageResultBean<Factory> getListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                  @Validated(Create.class) FactoryQuery factoryQuery) {

        List<Factory> factoryResults=factoryService.getFactoryListByQuery(factoryQuery,page, limit);
        PageInfo<Factory> rolePageInfo = new PageInfo<>(factoryResults);
        return new PageResultBean<>(rolePageInfo.getTotal(), rolePageInfo.getList());
    }
    @GetMapping
    public String add(Model model) {
        List<String> countyNames=new ArrayList<>();
        List<County> countys=selectCommonService.getAllCountys();
        for (County county:countys) {
            countyNames.add(county.getCountyName());
        }
        List<String> cityNames=new ArrayList<>();
        List<City> citys=selectCommonService.getAllCitys();
        for (City city:citys) {
            cityNames.add(city.getCityName());
        }
        model.addAttribute("countyNames", countyNames);
        model.addAttribute("cityNames", cityNames);
        return "factory/user-add";
    }
    @OperationLog("新增企业用户")
    @PostMapping
    @ResponseBody
    public ResultBean add(@Validated(Create.class) Factory factory) {
        User user=new User();
        user.setFacNo(factory.getFactoryNo1());
        user.setPassword("123456");
        factory.setStatus(7);
        return ResultBean.success(factoryService.addFactoryUser(factory,user));
    }
    @GetMapping("/{factoryNo1}/reset")
    public String resetPassword(@PathVariable("factoryNo1") String factoryNo1, Model model) {
        model.addAttribute("factoryNo1", factoryNo1);
        return "factory/user-reset-pwd";
    }

    @OperationLog("重置密码")
    @PostMapping("/{factoryNo1}/reset")
    @ResponseBody
    public ResultBean resetPassword(@PathVariable("factoryNo1") String factoryNo1, String password) {
        factoryService.updateUserPassword(factoryNo1, password);
        return ResultBean.success();
    }


}
