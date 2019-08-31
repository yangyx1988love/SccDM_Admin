package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.vo.*;
import nankai.xl.business.service.NonRoadService;
import nankai.xl.business.service.SelectCommonService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/source")
public class NonRoadController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private NonRoadService nonRoadService;

    @OperationLog("非道路移动源-农用运输车")
    @GetMapping("/nonRoad/agriculture")
    public String agriculture(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/nonRoad/agriculture-list";
    }
    @OperationLog("非道路移动源-农用运输车-列表")
    @GetMapping("/nonRoad/agriculture/list")
    @ResponseBody
    public PageResultBean<AgricultureMachineryVo> agricultureList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                  @RequestParam(value = "limit", defaultValue = "50")int limit) {
        AgricultureMachineryVo agricultureMachineryVo=new AgricultureMachineryVo();
        List<AgricultureMachineryVo> results= nonRoadService.getByExample(agricultureMachineryVo,page, limit);
        PageInfo<AgricultureMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("非道路移动源-农用运输车-重载")
    @GetMapping("/nonRoad/agriculture/reload")
    @ResponseBody
    public PageResultBean<AgricultureMachineryVo> agricultureReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                           @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                    AgricultureMachineryVo agricultureMachineryVo) {
        List<AgricultureMachineryVo> results= nonRoadService.getByExample(agricultureMachineryVo,page, limit);
        PageInfo<AgricultureMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/nonRoad/agriculture/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", nonRoadService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("非道路移动源-农用运输车-删除")
    @DeleteMapping("/nonRoad/agriculture/{id}")
    @ResponseBody
    public ResultBean agricultureDelete(@PathVariable("id") Integer id) {
        nonRoadService.deleteAgricultureById(id);
        return ResultBean.success();
    }

    @OperationLog("非道路移动源-飞机")
    @GetMapping("/nonRoad/airplane")
    public String airplane(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/airplane-list";
    }
    @OperationLog("非道路移动源-飞机-列表")
    @GetMapping("/nonRoad/airplane/list")
    @ResponseBody
    public PageResultBean<AirplaneVo> airplaneList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit) {
        AirplaneVo airplaneVo=new AirplaneVo();
        List<AirplaneVo> results= nonRoadService.getByExample(airplaneVo,page, limit);
        PageInfo<AirplaneVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("非道路移动源-飞机-重载")
    @GetMapping("/nonRoad/airplane/reload")
    @ResponseBody
    public PageResultBean<AirplaneVo> airplaneReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                              @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     AirplaneVo airplaneVo) {
        List<AirplaneVo> results= nonRoadService.getByExample(airplaneVo,page, limit);
        PageInfo<AirplaneVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/nonRoad/airplane/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", nonRoadService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("非道路移动源-飞机-删除")
    @DeleteMapping("/nonRoad/airplane/{id}")
    @ResponseBody
    public ResultBean airplaneDelete(@PathVariable("id") Integer id) {
        nonRoadService.deleteAirplaneById(id);
        return ResultBean.success();
    }

    @OperationLog("非道路移动源-非道路机械")
    @GetMapping("/nonRoad/machinery")
    public String machinery(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/machinery-list";
    }
    @OperationLog("非道路移动源-非道路机械-列表")
    @GetMapping("/nonRoad/machinery/list")
    @ResponseBody
    public PageResultBean<NonroadMachineryVo> machineryList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                            @RequestParam(value = "limit", defaultValue = "50")int limit) {
        NonroadMachineryVo nonroadMachineryVo=new NonroadMachineryVo();
        List<NonroadMachineryVo> results= nonRoadService.getByExample(nonroadMachineryVo,page, limit);
        PageInfo<NonroadMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("非道路移动源-非道路机械-重载")
    @GetMapping("/nonRoad/machinery/reload")
    @ResponseBody
    public PageResultBean<NonroadMachineryVo> machineryReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                              NonroadMachineryVo nonroadMachineryVo) {
        List<NonroadMachineryVo> results= nonRoadService.getByExample(nonroadMachineryVo,page, limit);
        PageInfo<NonroadMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/nonRoad/machinery/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", nonRoadService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("非道路移动源-非道路机械-删除")
    @DeleteMapping("/nonRoad/machinery/{id}")
    @ResponseBody
    public ResultBean machineryDelete(@PathVariable("id") Integer id) {
        nonRoadService.deleteMachineryById(id);
        return ResultBean.success();
    }

    @OperationLog("非道路移动源-铁路内燃机")
    @GetMapping("/nonRoad/railway")
    public String railway(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/railway-list";
    }
    @OperationLog("非道路移动源-铁路内燃机-列表")
    @GetMapping("/nonRoad/railway/list")
    @ResponseBody
    public PageResultBean<RailwayEngineVo> railwayList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit) {
        RailwayEngineVo railwayEngineVo=new RailwayEngineVo();
        List<RailwayEngineVo> results= nonRoadService.getByExample(railwayEngineVo,page, limit);
        PageInfo<RailwayEngineVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("非道路移动源-铁路内燃机-重载")
    @GetMapping("/nonRoad/railway/reload")
    @ResponseBody
    public PageResultBean<RailwayEngineVo> railwayReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                          @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         RailwayEngineVo railwayEngineVo) {
        List<RailwayEngineVo> results= nonRoadService.getByExample(railwayEngineVo,page, limit);
        PageInfo<RailwayEngineVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/nonRoad/railway/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", nonRoadService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("非道路移动源-铁路内燃机-删除")
    @DeleteMapping("/nonRoad/railway/{id}")
    @ResponseBody
    public ResultBean railwayDelete(@PathVariable("id") Integer id) {
        nonRoadService.deleteRailwayById(id);
        return ResultBean.success();
    }

    @OperationLog("非道路移动源-小型通用机械")
    @GetMapping("/nonRoad/smallMachinery")
    public String smallMachinery(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/nonRoad/smallMachinery-list";
    }
    @OperationLog("非道路移动源-小型通用机械-列表")
    @GetMapping("/nonRoad/smallMachinery/list")
    @ResponseBody
    public PageResultBean<SmallMachineryVo> smallMachineryList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                               @RequestParam(value = "limit", defaultValue = "50")int limit) {
        SmallMachineryVo smallMachineryVo=new SmallMachineryVo();
        List<SmallMachineryVo> results= nonRoadService.getByExample(smallMachineryVo,page, limit);
        PageInfo<SmallMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("非道路移动源-小型通用机械-重载")
    @GetMapping("/nonRoad/smallMachinery/reload")
    @ResponseBody
    public PageResultBean<SmallMachineryVo> smallMachineryReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                 SmallMachineryVo smallMachineryVo) {
        List<SmallMachineryVo> results= nonRoadService.getByExample(smallMachineryVo,page, limit);
        PageInfo<SmallMachineryVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/nonRoad/smallMachinery/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", nonRoadService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("非道路移动源-小型通用机械-删除")
    @DeleteMapping("/nonRoad/smallMachinery/{id}")
    @ResponseBody
    public ResultBean smallMachineryDelete(@PathVariable("id") Integer id) {
        nonRoadService.deleteSmallMachineryById(id);
        return ResultBean.success();
    }
}
