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
import nankai.xl.system.model.Dept;
import nankai.xl.system.service.AdminuserService;
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
@RequestMapping("/factoryAuth")
public class FactoryAuthController {

    @Resource
    private FactoryService factoryService;
    @Resource
    private ExhaustService exhaustService;
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SccService sccService;
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
    @Resource
    private AdminuserService adminuserService;
    @Resource
    private MailService mailService;
    @Resource
    private DeptService deptService;

    @GetMapping("/index")
    public String auth(Model model) {
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
        return "factoryAuth/factory-list";
    }
    @OperationLog("查看工厂列表")
    @GetMapping("/list")
    @ResponseBody
    public PageResultBean<Factory> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<Factory> rolePageInfo = new PageInfo<>(factoryService.getFactorysByuser(user,page,limit));
            return new PageResultBean<>(rolePageInfo.getTotal(), rolePageInfo.getList());
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
    @OperationLog("进入企业审核界面")
    @GetMapping("/{factoryId}/edit")
    public String edit(@PathVariable("factoryId") Integer factoryId, Model model, HttpServletRequest request) {
        model.addAttribute("factoryId", factoryId);
        return "factoryAuth/factory-Info";
    }
    @OperationLog("企业审核界面-企业基本信息")
    @GetMapping("/base/{factoryId}")
    public String baseInfo(@PathVariable("factoryId") Integer factoryId,Model model) {
        Factory factory=factoryService.getFactoryById(factoryId);
        if (factory!=null){
            String cityCode=factory.getCountyCity();

            List<City> citys=selectCommonService.getAllCitys();
            List<County> countys=selectCommonService.getCountysByCityCode(cityCode);
            List<String> statusdecs=new ArrayList<>();
            List<Status> Statuss=selectCommonService.getAllStatus();
            for (Status status:Statuss) {
                statusdecs.add(status.getIntroduction());
            }
            List<IndustryBig> industryBigs=selectCommonService.getAllIndustryBigs();
            List<Industry> industrys=selectCommonService.getIndustrysByCode(factory.getIndustryBigid());
            String[] sourceTypes={"废气国控","废气省控","废气市控","废气其它"};
            model.addAttribute("countys", countys);
            model.addAttribute("citys", citys);
            model.addAttribute("statusdecs", statusdecs);
            model.addAttribute("industrys", industrys);
            model.addAttribute("industryBigs", industryBigs);
            model.addAttribute("sourceTypes", sourceTypes);
            model.addAttribute("factory", factory);
            return "factoryAuth/factory-Info-base";
        }else{
            return ResultBean.error("企业信息错误！！").getMsg();
        }
    }
    @OperationLog("更新企业-基本信息")
    @PostMapping("/base/{factoryId}/edit")
    @ResponseBody
    public ResultBean resetPassword(@Validated(Create.class) Factory factory) {
        String countyRegisterCity=factory.getCountyRegisterCity();//注册城市编码
        String countyidRegister=factory.getCountyidRegister();//注册区县编码
        String countyCity=factory.getCountyCity();//实际城市编码cityCode ,表中cityId有何用？？？
        String countyId=factory.getCountyId();//实际区县编码

        City cityReg=selectCommonService.getCityByCode(countyRegisterCity);
        County countyReg=selectCommonService.getCountyById(countyidRegister);

        City city=selectCommonService.getCityByCode(countyCity);
        County county=selectCommonService.getCountyById(countyId);

        factory.setCountyRegisterCityDec(cityReg.getCityName());
        factory.setCountyidRegisterDec(countyReg.getCountyName());
        factory.setCityName(city.getCityName());
        //factory.setCountyCityDec(city.getCityName());
        factory.setCountyName(county.getCountyName());
        factoryService.updateByFactoryId(factory);
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-排气筒信息")
    @GetMapping("/{factoryId}/exhaust")
    public String exhaust(@PathVariable("factoryId") Integer factoryId, Model model,HttpSession session) {
        List<Exhaust> exhausts=exhaustService.getByFactoryId(factoryId);
        Integer exhaustNum=exhausts.size();
        model.addAttribute("exhausts", exhausts);
        model.addAttribute("exhaustNum", exhaustNum);
        return "factoryAuth/factory-Info-exhaust";
    }
    @OperationLog("更新企业-排气筒信息")
    @PostMapping(value="/exhaust/update")
    @ResponseBody
    public ResultBean exhaustUpdate(ExhaustVo exhaustVo) {
        //判断提交的排气筒编号（nkNo）是否重复
        boolean nkNoIsRepeat= ArrayRepaetCheck.cheakIsRepeat(exhaustVo.getNkNo());
        if (nkNoIsRepeat){
            List<Exhaust> exhaustList=ExhaustVo.recoverExhaustList(exhaustVo);
            for (Exhaust exhaust:exhaustList) {
                exhaustService.updateExhaustByExfId(exhaust);
            }
            return ResultBean.success();
        }else{
            return ResultBean.error("排气筒编号重复！");
        }
    }
    @OperationLog("企业审核界面-总锅炉信息")
    @GetMapping("/{factoryId}/boiler")
    public String boiler(@PathVariable("factoryId") Integer factoryId,Model model,HttpSession session) {
        List<BoilerVo> boilerVos=furnaceCommonService.getBoilersByFactoryId(factoryId);
        model.addAttribute("factoryId", factoryId);
        model.addAttribute("boilerNum", boilerVos.size());
        model.addAttribute("boilerVos", boilerVos);
        return "furnace/factory-Info-boiler";
    }
    @OperationLog("企业审核界面-锅炉表单信息")
    @GetMapping("/boiler/boilerForm")
    public String boilerForm(Integer factoryId, Integer id,Model model,HttpSession session) {
        List<Exhaust> exhausts=exhaustService.getByFactoryId(factoryId);
        Boiler boiler=furnaceCommonService.getBoilerById(id);
        String scc1="10";
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(boiler.getFunctio());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(boiler.getFunctio());
        scc4.setScc3(boiler.getFueltype());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<Dustremove> dustremoves=selectCommonService.getAllDustremoves();
        List<Nitreremove> nitreremoves=selectCommonService.getAllNitreremoves();
        List<Sulphurremove> sulphurremoves=selectCommonService.getAllSulphurremoves();

        model.addAttribute("scc1", scc1);
        model.addAttribute("boiler", boiler);
        model.addAttribute("scc2s", scc2s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("exhausts", exhausts);
        model.addAttribute("dustremoves", dustremoves);
        model.addAttribute("nitreremoves", nitreremoves);
        model.addAttribute("sulphurremoves", sulphurremoves);
        model.addAttribute("factoryId", factoryId);
        return "furnace/boiler";
    }
    @OperationLog("更新企业-锅炉信息")
    @PostMapping("/boiler/edit/{id}")
    @ResponseBody
    public ResultBean updateBoiler(Boiler boiler,Integer factoryId) {
        List<BoilerVo> boilerVos=furnaceCommonService.getBoilersByFactoryId(factoryId);
        Integer[] nkNos=new Integer[boilerVos.size()];
        for (int i = 0; i <boilerVos.size() ; i++) {
            if (boilerVos.get(i).getId().equals(boiler.getId())){
                nkNos[i]=boiler.getNkNo();
            }else{
                nkNos[i]=boilerVos.get(i).getNkNo();
            }
        }
        boolean nkNoIsRepeat= ArrayRepaetCheck.cheakIsRepeat(nkNos);
        if (nkNoIsRepeat){
            //12个月的填报用量之和
            Double fuelAusageAll=boiler.getJanUseamount()+boiler.getFebUseamount()+boiler.getMarUseamount()+boiler.getAprUseamount()
                    +boiler.getMayUseamount()+boiler.getJuneUseamount()+boiler.getJulyUseamount()+boiler.getAugUseamount()
                    +boiler.getSeptUseamount()+boiler.getOctUseAmount()+boiler.getNovUseamount()+boiler.getDecUseamount();
            if (fuelAusageAll>boiler.getFuelAusage()){
                return ResultBean.error("12个月的燃料使用量之和大于燃料年使用量，请重新填写！");
            }else{
                String sccCode="10"+boiler.getFunctio()+boiler.getFueltype()+boiler.getModel();
                boiler.setScc(sccCode);
//                    Dustremove dustremove=removeCommonService.getDustremoveById(boiler.getDustremoveId());
//                    boiler.setDustremoveDec(dustremove.getDustRemoveName());
//                    Nitreremove nitreremove=removeCommonService.getNitrremoveById(boiler.getNitreremoveId());
//                    boiler.setNitreremoveDec(nitreremove.getNitreMethod());
//                    Sulphurremove sulphurremove=removeCommonService.getSulphurremoveById(boiler.getSulphurremoveId());
//                    boiler.setSulphurremoveDec(sulphurremove.getSulphurMethod());
                //通过scc重新计算
                Scc scc=sccService.getSccByScc(sccCode);
                if (scc!=null) {
                    boiler.setPm(boiler.getPm() * scc.getPm());
                    boiler.setPm10(boiler.getPm10() * scc.getPm10());
                    boiler.setPm25(boiler.getPm25() * scc.getPm25());
                    boiler.setCo(boiler.getCo() * scc.getCo());
                    boiler.setVoc(boiler.getVoc() * scc.getVocs());
                    boiler.setSo2(boiler.getSo2() * scc.getSo2());
                    boiler.setBc(boiler.getBc() * scc.getBc());
                    boiler.setOc(boiler.getOc() * scc.getOc());
                    //除尘、脱销等计算还待商榷，
                }
                furnaceCommonService.updateBoilerById(boiler);
                return ResultBean.success();
            }
        }else{
            return ResultBean.error("锅炉编号重复！");
        }
    }
    @OperationLog("企业审核界面-窑炉信息")
    @GetMapping("/{factoryId}/kiln")
    public String kiln(@PathVariable("factoryId") Integer factoryId,Model model,HttpSession session) {
        List<KilnVo> kilnVos=furnaceCommonService.getKilnsByFactoryId(factoryId);
        model.addAttribute("factoryId", factoryId);
        model.addAttribute("kilnNum", kilnVos.size());
        model.addAttribute("kilnVos", kilnVos);
        return "furnace/factory-Info-kiln";
    }
    @OperationLog("企业审核界面-锅炉表单信息")
    @GetMapping("/kiln/kilnForm")
    public String kilnForm(Integer factoryId, Integer id,Model model,HttpSession session) {
        List<Exhaust> exhausts=exhaustService.getByFactoryId(factoryId);

        Kiln kiln=furnaceCommonService.getKilnById(id);
        String scc1="11";
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(kiln.getFunctio());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(kiln.getFunctio());
        scc4.setScc3(kiln.getFueltype());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<Dustremove> dustremoves=selectCommonService.getAllDustremoves();
        List<Nitreremove> nitreremoves=selectCommonService.getAllNitreremoves();
        List<Sulphurremove> sulphurremoves=selectCommonService.getAllSulphurremoves();

        model.addAttribute("scc1", scc1);
        model.addAttribute("kiln", kiln);
        model.addAttribute("scc2s", scc2s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("exhausts", exhausts);
        model.addAttribute("dustremoves", dustremoves);
        model.addAttribute("nitreremoves", nitreremoves);
        model.addAttribute("sulphurremoves", sulphurremoves);
        model.addAttribute("factoryId", factoryId);
        return "furnace/kiln";
    }
    @OperationLog("更新企业-窑炉信息")
    @PostMapping("/kiln/edit/{id}")
    @ResponseBody
    public ResultBean updatekiln(Kiln kiln,Integer factoryId) {
        List<KilnVo> kilnVos=furnaceCommonService.getKilnsByFactoryId(factoryId);
        Integer[] kilnNkNos=new Integer[kilnVos.size()];
        for (int i = 0; i <kilnVos.size() ; i++) {
            if (kilnVos.get(i).getId().equals(kiln.getId())){
                kilnNkNos[i]=kiln.getNkNo();
            }else {
                kilnNkNos[i]=kilnVos.get(i).getNkNo();
            }
        }
        boolean nkNoIsRepeat= ArrayRepaetCheck.cheakIsRepeat(kilnNkNos);
        if (nkNoIsRepeat){
            //12个月的填报用量之和
            Double fuelAusageAll=kiln.getJanUseamount()+kiln.getFebUseamount()+kiln.getMarUseamount()+kiln.getAprUseamount()
                    +kiln.getMayUseamount()+kiln.getJuneUseamount()+kiln.getJulyUseamount()+kiln.getAugUseamount()
                    +kiln.getSeptUseamount()+kiln.getOctUseAmount()+kiln.getNovUseamount()+kiln.getDecUseamount();
            if (fuelAusageAll>kiln.getKilnFuelAusage()){
                return ResultBean.error("12个月的燃料使用量之和大于燃料年使用量，请重新填写！");
            }else{
                String sccCode="11"+kiln.getFunctio()+kiln.getFueltype()+kiln.getModel();
                kiln.setScccode(sccCode);
//                    Dustremove dustremove=removeCommonService.getDustremoveById(kiln.getDustremoveid());
//                    kiln.setDustremovedec(dustremove.getDustRemoveName());
//                    Nitreremove nitreremove=removeCommonService.getNitrremoveById(kiln.getNitreremoveid());
//                    kiln.setNitreremovedec(nitreremove.getNitreMethod());
//                    Sulphurremove sulphurremove=removeCommonService.getSulphurremoveById(kiln.getSulphurremoveid());
//                    kiln.setSulphurremovedec(sulphurremove.getSulphurMethod());
                //通过scc重新计算
                Scc scc=sccService.getSccByScc(sccCode);
                if (scc!=null) {
                    kiln.setPm(kiln.getPm() * scc.getPm());
                    kiln.setPm10(kiln.getPm10() * scc.getPm10());
                    kiln.setPm25(kiln.getPm25() * scc.getPm25());
                    kiln.setCo(kiln.getCo() * scc.getCo());
                    kiln.setVoc(kiln.getVoc() * scc.getVocs());
                    kiln.setSo2(kiln.getSo2() * scc.getSo2());
                    kiln.setBc(kiln.getBc() * scc.getBc());
                    kiln.setOc(kiln.getOc() * scc.getOc());
                }
                //除尘、脱销等计算还待商榷，
                furnaceCommonService.updateKilnById(kiln);
                return ResultBean.success();
            }
        }else{
            return ResultBean.error("窑炉编号重复！");
        }
    }
    @OperationLog("企业审核界面-工艺过程")
    @GetMapping("/{factoryId}/process")
    public String process(@PathVariable("factoryId") Integer factoryId, Model model, HttpSession session) {
        List<DeviceVo> deviceVos=deviceCommonService.getDevicesByFactoryId(factoryId);
        List<DeviceRawVo> deviceRawVos=deviceCommonService.getDeviceRawsByFactoryId(factoryId);
        List<DeviceProductVo> deviceProductVos=deviceCommonService.getDeviceProductsByFactoryId(factoryId);

        model.addAttribute("deviceNum", deviceVos.size());
        model.addAttribute("deviceRawNum", deviceRawVos.size());
        model.addAttribute("deviceProductNum", deviceProductVos.size());
        model.addAttribute("deviceVos", deviceVos);
        model.addAttribute("deviceRawVos", deviceRawVos);
        model.addAttribute("deviceProductVos", deviceProductVos);
        model.addAttribute("factoryId", factoryId);
        return "device/factory-Info-process";
    }
    @OperationLog("企业审核界面-工艺过程-设备")
    @GetMapping("/device/deviceForm")
    public String deviceLoad(Integer factoryId, Integer id,Model model) {
        List<Exhaust> exhausts=exhaustService.getByFactoryId(factoryId);
        Device device=deviceCommonService.getDeviceById(id);
        model.addAttribute("device", device);
        model.addAttribute("exhausts", exhausts);
        model.addAttribute("factoryId", factoryId);
        return "device/device";
    }
    @OperationLog("企业审核界面-更新-工艺工程-设备")
    @PostMapping("/device/edit/{id}")
    @ResponseBody
    public ResultBean updateDevice(Device device, Integer factoryId) {
        List<DeviceVo> deviceVos=deviceCommonService.getDevicesByFactoryId(factoryId);
        Integer[] deviceNkNos=new Integer[deviceVos.size()];
        for (int i = 0; i <deviceVos.size() ; i++) {
            if (deviceVos.get(i).getId().equals(device.getId())){
                deviceNkNos[i]=device.getNkNo();
            }else {
                deviceNkNos[i]=deviceVos.get(i).getNkNo();
            }
        }
        boolean nkNoIsRepeat= ArrayRepaetCheck.cheakIsRepeat(deviceNkNos);
        if (nkNoIsRepeat){
            deviceCommonService.updateDeviceById(device);
            return ResultBean.success();
        }else {
            return ResultBean.error("设备编号重复！");
        }
    }
    @OperationLog("企业审核界面-工艺过程-原料")
    @GetMapping("/device/deviceRawForm")
    public String deviceRawLoad(Integer factoryId, Integer id,Model model) {
        List<DeviceVo> deviceVos=deviceCommonService.getDevicesByFactoryId(factoryId);
        DeviceRaw deviceRaw=deviceCommonService.getDeviceRawById(id);
        String scc1="11";
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(deviceRaw.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(deviceRaw.getScc2());
        scc4.setScc3(deviceRaw.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<Dustremove> dustremoves=selectCommonService.getAllDustremoves();
        List<Nitreremove> nitreremoves=selectCommonService.getAllNitreremoves();
        List<Sulphurremove> sulphurremoves=selectCommonService.getAllSulphurremoves();
        model.addAttribute("deviceRaw", deviceRaw);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2s", scc2s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("deviceVos", deviceVos);
        return "device/deviceRaw";
    }
    @OperationLog("企业审核界面-更新-工艺过程-原料")
    @PostMapping("/deviceRaw/edit/{id}")
    @ResponseBody
    public ResultBean updateDeviceRaw(DeviceRaw deviceRaw) {
        Double fuelAusageAll=deviceRaw.getJanUseamount()+deviceRaw.getFebUseamount()+deviceRaw.getMarUseamount()+deviceRaw.getAprUseamount()
                +deviceRaw.getMayUseamount()+deviceRaw.getJuneUseamount()+deviceRaw.getJulyUseamount()+deviceRaw.getAugUseamount()
                +deviceRaw.getSeptUseamount()+deviceRaw.getOctUseAmount()+deviceRaw.getNovUseamount()+deviceRaw.getDecUseamount();
        if (fuelAusageAll>deviceRaw.getMusage()){
            return ResultBean.error("12个月的燃料使用量之和大于燃料年使用量，请重新填写！");
        }else {
            String sccCode = "11" + deviceRaw.getScc2() + deviceRaw.getScc3() + deviceRaw.getScc4();
            deviceRaw.setSccCode(sccCode);

//                    Dustremove dustremove=removeCommonService.getDustremoveById(deviceRaw.getDustremoveid());
//                    deviceRaw.setDustremovedec(dustremove.getDustRemoveName());
//                    Nitreremove nitreremove=removeCommonService.getNitrremoveById(deviceRaw.getNitreremoveid());
//                    deviceRaw.setNitreremovedec(nitreremove.getNitreMethod());
//                    Sulphurremove sulphurremove=removeCommonService.getSulphurremoveById(deviceRaw.getSulphurremoveid());
//                    deviceRaw.setSulphurremovedec(sulphurremove.getSulphurMethod());
            //通过scc重新计算
//            Scc scc = sccService.getSccByScc(sccCode);
//            if (scc!=null){
//                deviceRaw.setPm(deviceRaw.getPm() * scc.getPm());
//                deviceRaw.setPm10(deviceRaw.getPm10() * scc.getPm10());
//                deviceRaw.setPm25(deviceRaw.getPm25() * scc.getPm25());
//                deviceRaw.setCo(deviceRaw.getCo() * scc.getCo());
//                deviceRaw.setVoc(deviceRaw.getVoc() * scc.getVocs());
//                deviceRaw.setSo2(deviceRaw.getSo2() * scc.getSo2());
//                deviceRaw.setBc(deviceRaw.getBc() * scc.getBc());
//                deviceRaw.setOc(deviceRaw.getOc() * scc.getOc());
//            }
            //除尘、脱销等计算还待商榷，
            deviceCommonService.updateDeviceRawById(deviceRaw);
            return ResultBean.success();
        }
    }
    @OperationLog("企业审核界面-工艺过程-产品")
    @GetMapping("/device/deviceProductForm")
    public String deviceProductLoad(Integer factoryId, Integer id,Model model) {
        List<DeviceVo> deviceVos=deviceCommonService.getDevicesByFactoryId(factoryId);
        DeviceProduct deviceProduct=deviceCommonService.getDeviceProductById(id);

        String scc1="11";
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(deviceProduct.getActivitiesCategory());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(deviceProduct.getActivitiesCategory());
        scc4.setScc3(deviceProduct.getNameCategory());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<Dustremove> dustremoves=selectCommonService.getAllDustremoves();
        List<Nitreremove> nitreremoves=selectCommonService.getAllNitreremoves();
        List<Sulphurremove> sulphurremoves=selectCommonService.getAllSulphurremoves();
        model.addAttribute("deviceProduct", deviceProduct);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2s", scc2s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("deviceVos", deviceVos);
        return "device/deviceProduct";
    }
    @OperationLog("企业审核界面-更新-工艺过程-产品")
    @PostMapping("/deviceProduct/edit/{id}")
    @ResponseBody
    public ResultBean updateDeviceProduct(DeviceProduct deviceProduct) {
        Double fuelAusageAll=deviceProduct.getJanUseamount()+deviceProduct.getFebUseamount()+deviceProduct.getMarUseamount()+deviceProduct.getAprUseamount()
                +deviceProduct.getMayUseamount()+deviceProduct.getJuneUseamount()+deviceProduct.getJulyUseamount()+deviceProduct.getAugUseamount()
                +deviceProduct.getSeptUseamount()+deviceProduct.getOctUseAmount()+deviceProduct.getNovUseamount()+deviceProduct.getDecUseamount();
        if (fuelAusageAll>deviceProduct.getAnnualOutput()){
            return ResultBean.error("12个月的燃料使用量之和大于燃料年使用量，请重新填写！");
        }else {
            String sccCode = "11" + deviceProduct.getActivitiesCategory() + deviceProduct.getNameCategory() + deviceProduct.getDrainageProcess();
            deviceProduct.setSccCode(sccCode);
//                    Dustremove dustremove=removeCommonService.getDustremoveById(deviceProduct.getDustremoveId());
//                    deviceProduct.setDustremoveDec(dustremove.getDustRemoveName());
//                    Nitreremove nitrerefdhmove=removeCommonService.getNitrremoveById(deviceProduct.getNitreremoveId());
//                    deviceProduct.setNitreremoveDec(nitreremove.getNitreMethod());
//                    Sulphurremove sulphurremove=removeCommonService.getSulphurremoveById(deviceProduct.getSulphurremoveId());
//                    deviceProduct.setSulphurremoveDec(sulphurremove.getSulphurMethod());
            //通过scc重新计算
            Scc scc = sccService.getSccByScc(sccCode);
            if (scc!=null){
                deviceProduct.setPm(deviceProduct.getPm() * scc.getPm());
                deviceProduct.setPm10(deviceProduct.getPm10() * scc.getPm10());
                deviceProduct.setPm25(deviceProduct.getPm25() * scc.getPm25());
                deviceProduct.setCo(deviceProduct.getCo() * scc.getCo());
                deviceProduct.setVoc(deviceProduct.getVoc() * scc.getVocs());
                deviceProduct.setSo2(deviceProduct.getSo2() * scc.getSo2());
                deviceProduct.setBc(deviceProduct.getBc() * scc.getBc());
                deviceProduct.setOc(deviceProduct.getOc() * scc.getOc());
            }
            //除尘、脱销等计算还待商榷，
            deviceCommonService.updateDeviceProductById(deviceProduct);
            return ResultBean.success();
        }
    }
    @OperationLog("企业审核界面-溶剂")
    @GetMapping("/{factoryId}/solvent")
    public String solvent(@PathVariable("factoryId") Integer factoryId,Model model) {
        List<RongjiRawVo> rongjiRawVos=solventService.getRawsByFactoryId(factoryId);
        List<RongjiProductVo> rongjiProductVos=solventService.getProductsByFactoryId(factoryId);
        model.addAttribute("rongjiRawVoNum", rongjiRawVos.size());
        model.addAttribute("rongjiProductVoNum", rongjiProductVos.size());
        model.addAttribute("rongjiRawVos", rongjiRawVos);
        model.addAttribute("rongjiProductVos", rongjiProductVos);
        model.addAttribute("factoryId", factoryId);
        return "solvent/factory-Info-solvent";
    }
    @OperationLog("企业审核界面-溶剂-原料")
    @GetMapping("/solvent/rongjiRawForm")
    public String rongjiRawLoad(Integer factoryId, Integer id,Model model) {
        RongjiRaw rongjiRaw=solventService.getRawById(id);
        String scc1="14";
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(rongjiRaw.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(rongjiRaw.getScc2());
        scc4.setScc3(rongjiRaw.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);


        model.addAttribute("rongjiRaw", rongjiRaw);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2s", scc2s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        return "solvent/rongjiRaw";
    }
    @OperationLog("企业审核界面-更新-溶剂-原料")
    @PostMapping("/rongjiRaw/edit/{id}")
    @ResponseBody
    public ResultBean updateRongjiRaw(RongjiRaw rongjiRaw) {
        Double fuelAusageAll=rongjiRaw.getJanUseamount()+rongjiRaw.getFebUseamount()+rongjiRaw.getMarUseamount()+rongjiRaw.getAprUseamount()
                +rongjiRaw.getMayUseamount()+rongjiRaw.getJuneUseamount()+rongjiRaw.getJulyUseamount()+rongjiRaw.getAugUseamount()
                +rongjiRaw.getSeptUseamount()+rongjiRaw.getOctUseAmount()+rongjiRaw.getNovUseamount()+rongjiRaw.getDecUseamount();
        if (fuelAusageAll>rongjiRaw.getMusage()){
            return ResultBean.error("12个月的燃料使用量之和大于燃料年使用量，请重新填写！");
        }else {
            String sccCode = "11" + rongjiRaw.getScc2() + rongjiRaw.getScc3() + rongjiRaw.getScc4();
            rongjiRaw.setSccCode(sccCode);
            //通过scc重新计算
//            Scc scc = sccService.getSccByScc(sccCode);
//            if (scc!=null){
//                rongjiRaw.setPm(rongjiRaw.getPm() * scc.getPm());
//                rongjiRaw.setPm10(rongjiRaw.getPm10() * scc.getPm10());
//                rongjiRaw.setPm25(rongjiRaw.getPm25() * scc.getPm25());
//                rongjiRaw.setCo(rongjiRaw.getCo() * scc.getCo());
//                rongjiRaw.setVoc(rongjiRaw.getVoc() * scc.getVocs());
//                rongjiRaw.setSo2(rongjiRaw.getSo2() * scc.getSo2());
//                rongjiRaw.setBc(rongjiRaw.getBc() * scc.getBc());
//                rongjiRaw.setOc(rongjiRaw.getOc() * scc.getOc());
//            }
            //除尘、脱销等计算还待商榷，
            solventService.updateRawById(rongjiRaw);
            return ResultBean.success();
        }
    }
    @OperationLog("企业审核界面-溶剂-产品")
    @GetMapping("/solvent/rongjiProductForm")
    public String rongjiProductLoad(Integer factoryId, Integer id,Model model) {
        RongjiProduct rongjiProduct=solventService.getProductById(id);

        String scc1="14";
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(rongjiProduct.getActivitiesCategory());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(rongjiProduct.getActivitiesCategory());
        scc4.setScc3(rongjiProduct.getNameCategory());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2s", scc2s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("rongjiProduct", rongjiProduct);
        return "solvent/rongjiProduct";
    }
    @OperationLog("企业审核界面-更新-溶剂-产品")
    @PostMapping("/rongjiProduct/edit/{id}")
    @ResponseBody
    public ResultBean updateRongjiProduct(RongjiProduct rongjiProduct) {
        Double fuelAusageAll=rongjiProduct.getJanUseamount()+rongjiProduct.getFebUseamount()+rongjiProduct.getMarUseamount()+rongjiProduct.getAprUseamount()
                +rongjiProduct.getMayUseamount()+rongjiProduct.getJuneUseamount()+rongjiProduct.getJulyUseamount()+rongjiProduct.getAugUseamount()
                +rongjiProduct.getSeptUseamount()+rongjiProduct.getOctUseAmount()+rongjiProduct.getNovUseamount()+rongjiProduct.getDecUseamount();
        if (fuelAusageAll>rongjiProduct.getAnnualOutput()){
            return ResultBean.error("12个月的燃料使用量之和大于燃料年使用量，请重新填写！");
        }else {
            String sccCode = "11" + rongjiProduct.getActivitiesCategory() + rongjiProduct.getNameCategory() + rongjiProduct.getDrainageProcess();
            rongjiProduct.setSccCode(sccCode);
            //通过scc重新计算
//            Scc scc = sccService.getSccByScc(sccCode);
//            if (scc!=null){
//                rongjiProduct.setPm(rongjiProduct.getPm() * scc.getPm());
//                rongjiProduct.setPm10(rongjiProduct.getPm10() * scc.getPm10());
//                rongjiProduct.setPm25(rongjiProduct.getPm25() * scc.getPm25());
//                rongjiProduct.setCo(rongjiProduct.getCo() * scc.getCo());
//                rongjiProduct.setVoc(rongjiProduct.getVoc() * scc.getVocs());
//                rongjiProduct.setSo2(rongjiProduct.getSo2() * scc.getSo2());
//                rongjiProduct.setBc(rongjiProduct.getBc() * scc.getBc());
//                rongjiProduct.setOc(rongjiProduct.getOc() * scc.getOc());
//            }
            //除尘、脱销等计算还待商榷，
            solventService.updateProductById(rongjiProduct);
            return ResultBean.success();
        }
    }
    @OperationLog("企业审核界面-废弃设备")
    @GetMapping("/{factoryId}/feiqi")
    public String feiqi(@PathVariable("factoryId") Integer factoryId, Model model) {
        List<FeiqiVo> feiqiVos=disuseService.getFeiqisByFactoryId(factoryId);
        model.addAttribute("feiqiNum", feiqiVos.size());
        model.addAttribute("feiqiVos", feiqiVos);
        model.addAttribute("factoryId", factoryId);
        return "disuse/factory-Info-feiqi";
    }
    @OperationLog("企业审核界面-废弃设备")
    @GetMapping("/feiqi/feiqiForm")
    public String feiqiLoad(Integer factoryId, Integer id,Model model) {
        Feiqi feiqi=disuseService.getFeiqiById(id);

        String scc1="21";
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(feiqi.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(feiqi.getScc2());
        scc4.setScc3(feiqi.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2s", scc2s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("feiqi", feiqi);
        return "disuse/feiqi";
    }
    @OperationLog("企业审核界面-更新-废弃设备")
    @PostMapping("/feiqi/edit/{id}")
    @ResponseBody
    public ResultBean updateFeiqi(Feiqi feiqi) {
        String sccCode = "21" + feiqi.getScc2() + feiqi.getScc3() + feiqi.getScc4();
        feiqi.setSccCode(sccCode);
        //通过scc重新计算
//            Scc scc = sccService.getSccByScc(sccCode);
//            if (scc!=null){
//                feiqi.setPm(feiqi.getPm() * scc.getPm());
//                feiqi.setPm10(feiqi.getPm10() * scc.getPm10());
//                feiqi.setPm25(feiqi.getPm25() * scc.getPm25());
//                feiqi.setCo(feiqi.getCo() * scc.getCo());
//                feiqi.setVoc(feiqi.getVoc() * scc.getVocs());
//                feiqi.setSo2(feiqi.getSo2() * scc.getSo2());
//                feiqi.setBc(feiqi.getBc() * scc.getBc());
//                feiqi.setOc(feiqi.getOc() * scc.getOc());
//            }
        //除尘、脱销等计算还待商榷，
        disuseService.updateFeiqiById(feiqi);
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-扬尘")
    @GetMapping("/{factoryId}/dust")
    public String dust(@PathVariable("factoryId") Integer factoryId, Model model) {
        List<Integer> fbareIds=dustService.getFBareIdsByFactoryId(factoryId);
        List<Integer> fconIds=dustService.getFConIdsByFactoryId(factoryId);
        List<Integer> froadIds=dustService.getFRoadIdsByFactoryId(factoryId);
        List<Integer> fyardIds=dustService.getFYardIdsByFactoryId(factoryId);
        model.addAttribute("fconIds", fconIds);
        model.addAttribute("fyardIds", fyardIds);
        model.addAttribute("froadIds", froadIds);
        model.addAttribute("fbareIds", fbareIds);
        model.addAttribute("factoryId", factoryId);
        return "dust/factory-Info-dust";
    }
    @OperationLog("企业审核界面-扬尘-施工")
    @GetMapping("/con/conForm")
    public String conLoad(Integer factoryId, Integer id,Model model) {
        FConstructionDustSource fCon=dustService.getFConById(id);
        model.addAttribute("fCon", fCon);
        return "dust/construction";
    }
    @OperationLog("企业审核界面-更新-扬尘-施工")
    @PostMapping("/fCon/edit/{id}")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @ResponseBody
    public ResultBean updateFcon(FConstructionDustSource fCon) {
        dustService.updateFConById(fCon);
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-扬尘-堆场")
    @GetMapping("/yard/yardForm")
    public String yardLoad(Integer factoryId, Integer id,Model model) {
        FYardDustSource yard=dustService.getFYardById(id);
        model.addAttribute("yard", yard);
        return "dust/yard";
    }
    @OperationLog("企业审核界面-更新-扬尘-堆场")
    @PostMapping("/yard/edit/{id}")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @ResponseBody
    public ResultBean updateYard(FYardDustSource yard) {
        dustService.updateFYardById(yard);
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-扬尘-道路")
    @GetMapping("/road/roadForm")
    public String roadLoad(Integer factoryId, Integer id,Model model) {
        FRoadDustSource road=dustService.getFRoadById(id);
        model.addAttribute("road", road);
        return "dust/road";
    }
    @OperationLog("企业审核界面-更新-扬尘-道路")
    @PostMapping("/road/edit/{id}")
    @ResponseBody
    public ResultBean updateRoad(FRoadDustSource road) {
        dustService.updateFRoadById(road);
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-扬尘-裸土")
    @GetMapping("/bare/bareForm")
    public String bareLoad(Integer factoryId, Integer id,Model model) {
        FBareSoilDustSource bare=dustService.getFBareById(id);
        model.addAttribute("bare", bare);
        return "dust/bare";
    }
    @OperationLog("企业审核界面-更新-扬尘-裸土")
    @PostMapping("/bare/edit/{id}")
    @ResponseBody
    public ResultBean updateBare(FBareSoilDustSource bare) {
        dustService.updateFBareById(bare);
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-扬尘-无组织车间")
    @GetMapping("/{factoryId}/noOrg")
    public String noOrg(@PathVariable("factoryId") Integer factoryId, Model model) {
        List<FNoOrganizationWorkshopDischarge> fNoOrgs=dustService.getFnoOrgByFactoryId(factoryId);
        model.addAttribute("fNoOrgs", fNoOrgs);
        model.addAttribute("fNoOrgNum", fNoOrgs.size());
        model.addAttribute("factoryId", factoryId);
        return "dust/factory-Info-noOrg";
    }
    @OperationLog("企业审核界面-排气筒信息更新")
    @PostMapping(value="/fNoOrg/update")
    @ResponseBody
    public ResultBean fNoOrgUpdate(FNoOrgVo fNoOrgVo) {
        //判断提交的排气筒编号（nkNo）是否重复
        boolean nkNoIsRepeat= ArrayRepaetCheck.cheakIsRepeat(fNoOrgVo.getWorkshopid());
        if (nkNoIsRepeat){
            List<FNoOrganizationWorkshopDischarge> list=fNoOrgVo.recover(fNoOrgVo);
            for (FNoOrganizationWorkshopDischarge f:list) {
                dustService.updateFnoOrgById(f);
            }
            return ResultBean.success();
        }else{
            return ResultBean.error("车间编号编号重复！");
        }
    }
    @OperationLog("企业审核-审核通过")
    @PostMapping("/{factoryId}/past")
    @ResponseBody
    public ResultBean pastFactory(@PathVariable("factoryId") Integer factoryId, HttpSession session) {
        Integer[] ids={factoryId};
        factoryService.auditFactory(ids);
        return ResultBean.success();
    }
    @OperationLog("企业审核-未通过界面")
    @GetMapping("/{factoryId}/reject")
    public String rejectFactory(@PathVariable("factoryId") Integer factoryId, Model model) {
        Adminuser user = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        Factory factory=factoryService.getFactoryById(factoryId);
        String mailContent=factory.getFactoryName()+" "+factory.getPrincipalName()+"您好："
                +"\r\n"
                +"                                "+user.getRealname()
                +"\n"
                +"                                "+deptService.selectByPrimaryKey(user.getDeptId()).getDeptName();
        model.addAttribute("mailContent", mailContent);
        model.addAttribute("factoryId", factoryId);
        return "factoryAuth/mail";
    }
    @OperationLog("企业审核-未通过-反馈邮件")
    @PostMapping("/{factoryId}/reject/mail")
    @ResponseBody
    public ResultBean rejectmail(Integer factoryId,String mailContent) {
        User factoryUser=factoryService.getUserByFactoryId(factoryId);
        new Thread(() ->
                mailService.sendHTMLMail(factoryUser.getEmail(),"污染源清单管理系统 审核通知", mailContent))
                .start();
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-上一家企业")
    @PostMapping("/{factoryId}/back")
    @ResponseBody
    public ResultBean back(@PathVariable("factoryId") Integer factoryId, Model model) {
        model.addAttribute("factoryId", factoryService.getBackById(factoryId).getFactoryId());
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-下一家企业")
    @PostMapping("/{factoryId}/next")
    @ResponseBody
    public ResultBean next(@PathVariable("factoryId") Integer factoryId, Model model) {
        model.addAttribute("factoryId", factoryService.getNextById(factoryId).getFactoryId());
        return ResultBean.success();
    }
    @OperationLog("企业审核界面-一键审核")
    @PostMapping("/authAll")
    @ResponseBody
    public ResultBean auth(Integer[] ids) {
        Adminuser user = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        if (ids.length>0){
            factoryService.auditFactory(ids);
            return ResultBean.success();
        }else{
            return ResultBean.error("选中的企业数据不存在！");
        }
    }
}
