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
    @Resource
    private DeviceCommonService deviceCommonService;
    @Resource
    private SolventService solventService;
    @Resource
    private DisuseService disuseService;
    @Resource
    private DustService dustService;
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
    @GetMapping("/device")
    public String deviceSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/device-list";
    }
    @OperationLog("查看设备列表")
    @GetMapping("/device/list")
    @ResponseBody
    public PageResultBean<DeviceSumVo> deviceList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                  @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<DeviceSumVo> pageInfo = new PageInfo<>(deviceCommonService.getSumDevices(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("设备列表-重载")
    @GetMapping("/device/reload")
    @ResponseBody
    public PageResultBean<DeviceSumVo> deviceListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<DeviceSumVo> results=deviceCommonService.getSumDevices(factorySumCommonQuery,page, limit);
        PageInfo<DeviceSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/deviceRaw")
    public String deviceRawSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/deviceRaw-list";
    }
    @OperationLog("查看设备原料列表")
    @GetMapping("/deviceRaw/list")
    @ResponseBody
    public PageResultBean<DeviceRawSumVo> deviceRawList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<DeviceRawSumVo> pageInfo = new PageInfo<>(deviceCommonService.getSumDeviceRaws(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("设备原料列表-重载")
    @GetMapping("/deviceRaw/reload")
    @ResponseBody
    public PageResultBean<DeviceRawSumVo> deviceRawListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                               @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                               @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<DeviceRawSumVo> results=deviceCommonService.getSumDeviceRaws(factorySumCommonQuery,page, limit);
        PageInfo<DeviceRawSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/deviceProduct")
    public String deviceProductSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/deviceProduct-list";
    }
    @OperationLog("查看设备产品列表")
    @GetMapping("/deviceProduct/list")
    @ResponseBody
    public PageResultBean<DeviceProductSumVo> deviceProductList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<DeviceProductSumVo> pageInfo = new PageInfo<>(deviceCommonService.getSumDeviceProducts(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("设备产品列表-重载")
    @GetMapping("/deviceProduct/reload")
    @ResponseBody
    public PageResultBean<DeviceProductSumVo> deviceProductListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                       @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<DeviceProductSumVo> results=deviceCommonService.getSumDeviceProducts(factorySumCommonQuery,page, limit);
        PageInfo<DeviceProductSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/rongjiProduct")
    public String rongjiProductSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/rongjiProduct-list";
    }
    @OperationLog("查看溶剂产品列表")
    @GetMapping("/rongjiProduct/list")
    @ResponseBody
    public PageResultBean<RongjiProductSumVo> rongjiProductList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<RongjiProductSumVo> pageInfo = new PageInfo<>(solventService.getSumRongjiProducts(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("溶剂产品列表-重载")
    @GetMapping("/rongjiProduct/reload")
    @ResponseBody
    public PageResultBean<RongjiProductSumVo> rongjiProductListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                       @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<RongjiProductSumVo> results=solventService.getSumRongjiProducts(factorySumCommonQuery,page, limit);
        PageInfo<RongjiProductSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/rongjiRaw")
    public String rongjiRawSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/rongjiRaw-list";
    }
    @OperationLog("查看溶剂原料列表")
    @GetMapping("/rongjiRaw/list")
    @ResponseBody
    public PageResultBean<RongjiRawSumVo> rongjiRawList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<RongjiRawSumVo> pageInfo = new PageInfo<>(solventService.getSumRongjiRaws(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("溶剂原料列表-重载")
    @GetMapping("/rongjiRaw/reload")
    @ResponseBody
    public PageResultBean<RongjiRawSumVo> rongjiRawListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                               @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                               @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<RongjiRawSumVo> results=solventService.getSumRongjiRaws(factorySumCommonQuery,page, limit);
        PageInfo<RongjiRawSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/feiqi")
    public String feiqiSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/feiqi-list";
    }
    @OperationLog("查看废弃列表")
    @GetMapping("/feiqi/list")
    @ResponseBody
    public PageResultBean<FeiqiSumVo> feiqiList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<FeiqiSumVo> pageInfo = new PageInfo<>(disuseService.getSumFeiqis(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("废弃列表-重载")
    @GetMapping("/feiqi/reload")
    @ResponseBody
    public PageResultBean<FeiqiSumVo> feiqiListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<FeiqiSumVo> results=disuseService.getSumFeiqis(factorySumCommonQuery,page, limit);
        PageInfo<FeiqiSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/fBareSoilDust")
    public String fBareSoilDustSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/fBareSoilDust-list";
    }
    @OperationLog("查看裸土列表")
    @GetMapping("/fBareSoilDust/list")
    @ResponseBody
    public PageResultBean<FBareSoilDustSourceSumVo> fBareSoilDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<FBareSoilDustSourceSumVo> pageInfo = new PageInfo<>(dustService.getSumFBareSoilDustSources(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("裸土列表-重载")
    @GetMapping("/fBareSoilDust/reload")
    @ResponseBody
    public PageResultBean<FBareSoilDustSourceSumVo> fBareSoilDustListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                       @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<FBareSoilDustSourceSumVo> results=dustService.getSumFBareSoilDustSources(factorySumCommonQuery,page, limit);
        PageInfo<FBareSoilDustSourceSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/fConstructionDust")
    public String fConstructionDustSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/fConstructionDust-list";
    }
    @OperationLog("查看施工列表")
    @GetMapping("/fConstructionDust/list")
    @ResponseBody
    public PageResultBean<FConstructionDustSourceSumVo> fConstructionDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                        @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<FConstructionDustSourceSumVo> pageInfo = new PageInfo<>(dustService.getSumFConstructionDustSources(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("施工列表-重载")
    @GetMapping("/fConstructionDust/reload")
    @ResponseBody
    public PageResultBean<FConstructionDustSourceSumVo> fConstructionDustListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                               @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                               @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<FConstructionDustSourceSumVo> results=dustService.getSumFConstructionDustSources(factorySumCommonQuery,page, limit);
        PageInfo<FConstructionDustSourceSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/fRoadDust")
    public String fRoadDustSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/fRoadDust-list";
    }
    @OperationLog("查看道路列表")
    @GetMapping("/fRoadDust/list")
    @ResponseBody
    public PageResultBean<FRoadDustSourceSumVo> fRoadDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                              @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<FRoadDustSourceSumVo> pageInfo = new PageInfo<>(dustService.getSumFRoadDustSources(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("道路列表-重载")
    @GetMapping("/fRoadDust/reload")
    @ResponseBody
    public PageResultBean<FRoadDustSourceSumVo> fRoadDustListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                     @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<FRoadDustSourceSumVo> results=dustService.getSumFRoadDustSources(factorySumCommonQuery,page, limit);
        PageInfo<FRoadDustSourceSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/fYardDust")
    public String fYardDustSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/fYardDust-list";
    }
    @OperationLog("查看堆场列表")
    @GetMapping("/fYardDust/list")
    @ResponseBody
    public PageResultBean<FYardDustSourceSumVo> fYardDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                              @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<FYardDustSourceSumVo> pageInfo = new PageInfo<>(dustService.getSumFYardDustSources(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("堆场列表-重载")
    @GetMapping("/fYardDust/reload")
    @ResponseBody
    public PageResultBean<FYardDustSourceSumVo> fYardDustListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                     @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<FYardDustSourceSumVo> results=dustService.getSumFYardDustSources(factorySumCommonQuery,page, limit);
        PageInfo<FYardDustSourceSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    @GetMapping("/FNoOrganization")
    public String FNoOrganizationSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/FNoOrganization-list";
    }
    @OperationLog("查看无组织车间列表")
    @GetMapping("/FNoOrganization/list")
    @ResponseBody
    public PageResultBean<FNoOrganizationWorkshopDischargeSumVo> FNoOrganizationList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                          @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<FNoOrganizationWorkshopDischargeSumVo> pageInfo = new PageInfo<>(dustService.getSumFNoOrganizations(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("无组织车间列表-重载")
    @GetMapping("/FNoOrganization/reload")
    @ResponseBody
    public PageResultBean<FNoOrganizationWorkshopDischargeSumVo> FNoOrganizationListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                                 @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<FNoOrganizationWorkshopDischargeSumVo> results=dustService.getSumFNoOrganizations(factorySumCommonQuery,page, limit);
        PageInfo<FNoOrganizationWorkshopDischargeSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
