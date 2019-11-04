package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.Scc3;
import nankai.xl.business.model.Scc4;
import nankai.xl.business.model.vo.*;
import nankai.xl.business.service.SelectCommonService;
import nankai.xl.business.service.SourceService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ResultBean;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.system.model.Adminuser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/source")
public class NonRoadController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;
    //页面加载时，根据用户加载城市和区县
    private List<City> citys=new ArrayList<>();
    private List<County> countys=new ArrayList<>();
    //根据用户显示该地区的源信息
    private String cityCode=null;
    private String countyCode=null;

    private String scc1="13";

    @OperationLog("非道路移动源-农用运输车")
    @GetMapping("/nonRoad/agriculture")
    public String agriculture(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/agriculture/agriculture-list";
    }
    @OperationLog("农用运输车-列表")
    @GetMapping("/nonRoad/agriculture/list")
    @ResponseBody
    public PageResultBean<AgricultureMachineryVo> agricultureList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                  @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                    AgricultureMachineryVo agricultureMachineryVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (agricultureMachineryVo.getCityCode()==null&&agricultureMachineryVo.getCountyId()==null){
            agricultureMachineryVo.setCityCode(cityCode);
            agricultureMachineryVo.setCountyId(countyCode);
        }
        List<AgricultureMachineryVo> results= sourceService.getByExample(agricultureMachineryVo,page, limit);
        PageInfo<AgricultureMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农用运输车-删除")
    @DeleteMapping("/nonRoad/agriculture/{id}")
    @ResponseBody
    public ResultBean agricultureDelete(@PathVariable("id") Integer id) {
        sourceService.deleteAgricultureById(id);
        return ResultBean.success();
    }
    @OperationLog("农用运输车-新增")
    @GetMapping("/nonRoad/agriculture/add")
    public String agricultureAdd(Model model) {
        String scc2="01";
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/agriculture/agriculture-add";
    }
    @OperationLog("农用运输车-编辑")
    @GetMapping("/nonRoad/agriculture/{id}")
    public String agricultureEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="01";
        AgricultureMachineryVo agricultureMachineryVo=sourceService.getAgricultureById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(agricultureMachineryVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(agricultureMachineryVo.getCityCode()));
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("agricultureMachineryVo", agricultureMachineryVo);
        return "source/nonRoad/agriculture/agriculture-update";
    }
    @OperationLog("农用运输车-编辑-保存")
    @PutMapping("/nonRoad/agriculture/edit")
    @ResponseBody
    public ResultBean agricultureInsertOrUpdate(boolean isCul,AgricultureMachineryVo agricultureMachineryVo) {
        agricultureMachineryVo.setSccCode(scc1+"01"+agricultureMachineryVo.getScc3()+agricultureMachineryVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(agricultureMachineryVo.getSccCode());
        agricultureMachineryVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdate(agricultureMachineryVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("非道路移动源-飞机")
    @GetMapping("/nonRoad/airplane")
    public String airplane(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/airplane/airplane-list";
    }
    @OperationLog("飞机-列表")
    @GetMapping("/nonRoad/airplane/list")
    @ResponseBody
    public PageResultBean<AirplaneVo> airplaneList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     AirplaneVo airplaneVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (airplaneVo.getCityCode()==null&&airplaneVo.getCountyId()==null){
            airplaneVo.setCityCode(cityCode);
            airplaneVo.setCountyId(countyCode);
        }
        List<AirplaneVo> results= sourceService.getByExample(airplaneVo,page, limit);
        PageInfo<AirplaneVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("飞机-删除")
    @DeleteMapping("/nonRoad/airplane/{id}")
    @ResponseBody
    public ResultBean airplaneDelete(@PathVariable("id") Integer id) {
        sourceService.deleteAirplaneById(id);
        return ResultBean.success();
    }
    @OperationLog("飞机-新增")
    @GetMapping("/nonRoad/airplane/add")
    public String airplaneAdd(Model model) {
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/airplane/airplane-add";
    }
    @OperationLog("飞机-编辑")
    @GetMapping("/nonRoad/airplane/{id}")
    public String airplaneEdit(@PathVariable("id") Integer id, Model model) {
        AirplaneVo airplaneVo=sourceService.getAirplaneById(id);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(airplaneVo.getCityCode()));
        model.addAttribute("airplaneVo", airplaneVo);
        return "source/nonRoad/airplane/airplane-update";
    }
    @OperationLog("飞机-编辑-保存")
    @PutMapping("/nonRoad/airplane/edit")
    @ResponseBody
    public ResultBean airplaneInsertOrUpdate(boolean isCul,AirplaneVo airplaneVo) {
        airplaneVo.setSccCode("1304401001");
        SccVo sccVo=selectCommonService.selectBySccCode(airplaneVo.getSccCode());
        airplaneVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdate(airplaneVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("非道路移动源-非道路机械")
    @GetMapping("/nonRoad/machinery")
    public String machinery(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/machinery/machinery-list";
    }
    @OperationLog("非道路机械-列表")
    @GetMapping("/nonRoad/machinery/list")
    @ResponseBody
    public PageResultBean<NonroadMachineryVo> machineryList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                            @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                NonroadMachineryVo nonroadMachineryVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (nonroadMachineryVo.getCityCode()==null&&nonroadMachineryVo.getCountyId()==null){
            nonroadMachineryVo.setCityCode(cityCode);
            nonroadMachineryVo.setCountyId(countyCode);
        }
        List<NonroadMachineryVo> results= sourceService.getByExample(nonroadMachineryVo,page, limit);
        PageInfo<NonroadMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("非道路机械-删除")
    @DeleteMapping("/nonRoad/machinery/{id}")
    @ResponseBody
    public ResultBean machineryDelete(@PathVariable("id") Integer id) {
        sourceService.deleteMachineryById(id);
        return ResultBean.success();
    }
    @OperationLog("非道路机械-新增")
    @GetMapping("/nonRoad/machinery/add")
    public String machineryAdd(Model model) {
        String scc2="02";
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);

        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/machinery/machinery-add";
    }
    @OperationLog("非道路机械-编辑")
    @GetMapping("/nonRoad/machinery/{id}")
    public String machineryEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="02";
        NonroadMachineryVo nonroadMachineryVo=sourceService.getMachineryById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(nonroadMachineryVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(nonroadMachineryVo.getCityCode()));
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("nonroadMachineryVo", nonroadMachineryVo);
        return "source/nonRoad/machinery/machinery-update";
    }
    @OperationLog("非道路机械-编辑-保存")
    @PutMapping("/nonRoad/machinery/edit")
    @ResponseBody
    public ResultBean machineryInsertOrUpdate(boolean isCul,NonroadMachineryVo nonroadMachineryVo) {
        nonroadMachineryVo.setSccCode(scc1+"02"+nonroadMachineryVo.getScc3()+nonroadMachineryVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(nonroadMachineryVo.getSccCode());
        nonroadMachineryVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdate(nonroadMachineryVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("非道路移动源-铁路内燃机")
    @GetMapping("/nonRoad/railway")
    public String railway(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/railway/railway-list";
    }
    @OperationLog("铁路内燃机-列表")
    @GetMapping("/nonRoad/railway/list")
    @ResponseBody
    public PageResultBean<RailwayEngineVo> railwayList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                        RailwayEngineVo railwayEngineVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (railwayEngineVo.getCityCode()==null&&railwayEngineVo.getCountyId()==null){
            railwayEngineVo.setCityCode(cityCode);
            railwayEngineVo.setCountyId(countyCode);
        }
        List<RailwayEngineVo> results= sourceService.getByExample(railwayEngineVo,page, limit);
        PageInfo<RailwayEngineVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("铁路内燃机-删除")
    @DeleteMapping("/nonRoad/railway/{id}")
    @ResponseBody
    public ResultBean railwayDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRailwayById(id);
        return ResultBean.success();
    }
    @OperationLog("铁路内燃机-新增")
    @GetMapping("/nonRoad/railway/add")
    public String railwayAdd(Model model) {
        String scc2="03";
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);

        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/railway/railway-add";
    }
    @OperationLog("铁路内燃机-编辑")
    @GetMapping("/nonRoad/railway/{id}")
    public String railwayEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="03";
        RailwayEngineVo railwayEngineVo=sourceService.getRailwayById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(railwayEngineVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(railwayEngineVo.getCityCode()));
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("railwayEngineVo", railwayEngineVo);
        return "source/nonRoad/railway/railway-update";
    }
    @OperationLog("铁路内燃机-编辑-保存")
    @PutMapping("/nonRoad/railway/edit")
    @ResponseBody
    public ResultBean railwayInsertOrUpdate(boolean isCul,RailwayEngineVo railwayEngineVo) {
        railwayEngineVo.setSccCode(scc1+"03"+railwayEngineVo.getScc3()+railwayEngineVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(railwayEngineVo.getSccCode());
        railwayEngineVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdate(railwayEngineVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("非道路移动源-小型通用机械")
    @GetMapping("/nonRoad/smallMachinery")
    public String smallMachinery(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/smallMachinery/smallMachinery-list";
    }
    @OperationLog("小型通用机械-列表")
    @GetMapping("/nonRoad/smallMachinery/list")
    @ResponseBody
    public PageResultBean<SmallMachineryVo> smallMachineryList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                               @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                 SmallMachineryVo smallMachineryVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (smallMachineryVo.getCityCode()==null&&smallMachineryVo.getCountyId()==null){
            smallMachineryVo.setCityCode(cityCode);
            smallMachineryVo.setCountyId(countyCode);
        }
        List<SmallMachineryVo> results= sourceService.getByExample(smallMachineryVo,page, limit);
        PageInfo<SmallMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("小型通用机械-删除")
    @DeleteMapping("/nonRoad/smallMachinery/{id}")
    @ResponseBody
    public ResultBean smallMachineryDelete(@PathVariable("id") Integer id) {
        sourceService.deleteSmallMachineryById(id);
        return ResultBean.success();
    }
    @OperationLog("小型通用机械-新增")
    @GetMapping("/nonRoad/smallMachinery/add")
    public String smallMachineryAdd(Model model) {
        String scc2="02";
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);

        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/smallMachinery/smallMachinery-add";
    }
    @OperationLog("小型通用机械-编辑")
    @GetMapping("/nonRoad/smallMachinery/{id}")
    public String smallMachineryEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="02";
        SmallMachineryVo smallMachineryVo=sourceService.getSmallMachineryById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(smallMachineryVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(smallMachineryVo.getCityCode()));
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("smallMachineryVo", smallMachineryVo);
        return "source/nonRoad/smallMachinery/smallMachinery-update";
    }
    @OperationLog("小型通用机械-编辑-保存")
    @PutMapping("/nonRoad/smallMachinery/edit")
    @ResponseBody
    public ResultBean smallMachineryInsertOrUpdate(boolean isCul,SmallMachineryVo smallMachineryVo) {
        smallMachineryVo.setSccCode(scc1+"02"+smallMachineryVo.getScc3()+smallMachineryVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(smallMachineryVo.getSccCode());
        smallMachineryVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdate(smallMachineryVo,isCul);
        return ResultBean.success();
    }
}
