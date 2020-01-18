package nankai.xl.business.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;
import nankai.xl.business.service.*;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.ArrayRepaetCheck;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ResultBean;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.common.validate.groups.Create;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.service.DeptService;
import nankai.xl.system.service.MailService;
import org.apache.shiro.SecurityUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/factoryAuth/sum")
public class FactorySumController {

    @Resource
    private FactoryService factoryService;
    @Resource
    private ExhaustService exhaustService;
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private FurnaceCommonService furnaceCommonService;
    @GetMapping("/factory")
    public String factorySum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/factory-list";
    }
    @OperationLog("查看工厂列表")
    @GetMapping("/factory/list")
    @ResponseBody
    public PageResultBean<FactoryVo> factoryList(@RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<FactoryVo> factoryPageInfo = new PageInfo<>(factoryService.getFactorysByuser(user,page,limit));
            return new PageResultBean<>(factoryPageInfo.getTotal(), factoryPageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("工厂列表-重载")
    @GetMapping("/factory/reload")
    @ResponseBody
    public PageResultBean<FactoryVo> factoryListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                    @Validated(Create.class) FactoryQuery factoryQuery) {

        List<FactoryVo> results=factoryService.getFactoryListByQuery(factoryQuery,page, limit);
        PageInfo<FactoryVo> rolePageInfo = new PageInfo<>(results);
        return new PageResultBean<>(rolePageInfo.getTotal(), rolePageInfo.getList());
    }
    @GetMapping("/exhaust")
    public String exhaustSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/exhaust-list";
    }
    @OperationLog("查看排气筒列表")
    @GetMapping("/exhaust/list")
    @ResponseBody
    public PageResultBean<ExhaustSumVo> exhaustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<ExhaustSumVo> pageInfo = new PageInfo<>(exhaustService.getSumExhausts(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("排气筒列表-重载")
    @GetMapping("/exhaust/reload")
    @ResponseBody
    public PageResultBean<ExhaustSumVo> exhaustListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                        @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<ExhaustSumVo> results=exhaustService.getSumExhausts(factorySumCommonQuery,page, limit);
        PageInfo<ExhaustSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/boiler")
    public String boilerSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/boiler-list";
    }
    @OperationLog("查看锅炉列表")
    @GetMapping("/boiler/list")
    @ResponseBody
    public PageResultBean<BoilerSumVo> boilerList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<BoilerSumVo> pageInfo = new PageInfo<>(furnaceCommonService.getSumBoilers(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("锅炉列表-重载")
    @GetMapping("/boiler/reload")
    @ResponseBody
    public PageResultBean<BoilerSumVo> boilerListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                           @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                           @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<BoilerSumVo> results=furnaceCommonService.getSumBoilers(factorySumCommonQuery,page, limit);
        PageInfo<BoilerSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/kiln")
    public String kilnSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/kiln-list";
    }
    @OperationLog("查看锅炉列表")
    @GetMapping("/kiln/list")
    @ResponseBody
    public PageResultBean<KilnSumVo> kilnList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                  @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<KilnSumVo> pageInfo = new PageInfo<>(furnaceCommonService.getSumKilns(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("锅炉列表-重载")
    @GetMapping("/kiln/reload")
    @ResponseBody
    public PageResultBean<KilnSumVo> kilnListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<KilnSumVo> results=furnaceCommonService.getSumKilns(factorySumCommonQuery,page, limit);
        PageInfo<KilnSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
