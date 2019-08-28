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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/source")
public class SolventController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    private String scc1="14";

    @OperationLog("溶剂使用源-建筑涂装")
    @GetMapping("/solvent/build")
    public String build(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/solvent/build/build-list";
    }
    @OperationLog("建筑涂装-列表")
    @GetMapping("/solvent/build/list")
    @ResponseBody
    public PageResultBean<BuildingSmearVo> buildList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     BuildingSmearVo buildingSmearVo) {
        List<BuildingSmearVo> results= sourceService.getBuildsByExample(buildingSmearVo,page, limit);
        PageInfo<BuildingSmearVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("建筑涂装-删除")
    @DeleteMapping("/solvent/build/{id}")
    @ResponseBody
    public ResultBean buildDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBuildById(id);
        return ResultBean.success();
    }

    @OperationLog("建筑涂装-编辑")
    @GetMapping("/solvent/build/{id}")
    public String buildEdit(@PathVariable("id") Integer id, Model model) {
        BuildingSmearVo buildingSmearVo=sourceService.getBuildById(id);
        buildingSmearVo.setScc1(scc1);
        buildingSmearVo.setScc2(buildingSmearVo.getScccode().substring(2,4));
        buildingSmearVo.setScc3(buildingSmearVo.getScccode().substring(4,7));
        buildingSmearVo.setScc4(buildingSmearVo.getScccode().substring(7,10));

        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(buildingSmearVo.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(buildingSmearVo.getScc2());
        scc4.setScc3(buildingSmearVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(buildingSmearVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("buildingSmearVo", buildingSmearVo);
        return "source/solvent/build/build-update";
    }
    @OperationLog("石化有组织废气排放-新增")
    @GetMapping("/solvent/build/add")
    public String buildAdd(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/solvent/build/build-add";
    }
    @OperationLog("废水无组织排放-编辑-保存")
    @PutMapping("/solvent/build/edit")
    @ResponseBody
    public ResultBean buildInsertOrUpdate(boolean isCul,BuildingSmearVo buildingSmearVo)  {
        buildingSmearVo.setScccode(scc1+buildingSmearVo.getScc2()+buildingSmearVo.getScc3()+buildingSmearVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(buildingSmearVo.getScccode());
        buildingSmearVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateBuild(buildingSmearVo,isCul);
        return ResultBean.success();
    }
    

    @OperationLog("溶剂使用源-汽修店")
    @GetMapping("/solvent/car")
    public String car(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/car-list";
    }
    @OperationLog("溶剂使用源-汽修店-列表")
    @GetMapping("/solvent/car/list")
    @ResponseBody
    public PageResultBean<CarRepairVo> carList(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "50")int limit) {
        CarRepairVo carRepairVo=new CarRepairVo();
        List<CarRepairVo> results= sourceService.getCarsByExample(carRepairVo,page, limit);
        PageInfo<CarRepairVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("溶剂使用源-汽修店-重载")
    @GetMapping("/solvent/car/reload")
    @ResponseBody
    public PageResultBean<CarRepairVo> carReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                 CarRepairVo carRepairVo) {
        List<CarRepairVo> results= sourceService.getCarsByExample(carRepairVo,page, limit);
        PageInfo<CarRepairVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/solvent/car/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("溶剂使用源-汽修店-删除")
    @DeleteMapping("/solvent/car/{id}")
    @ResponseBody
    public ResultBean carDelete(@PathVariable("id") Integer id) {
        sourceService.deleteCarById(id);
        return ResultBean.success();
    }

    @OperationLog("溶剂使用源-去油污")
    @GetMapping("/solvent/deoil")
    public String deoil(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/deoil-list";
    }
    @OperationLog("溶剂使用源-去油污-列表")
    @GetMapping("/solvent/deoil/list")
    @ResponseBody
    public PageResultBean<DeoilVo> deoilList(@RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "limit", defaultValue = "50")int limit) {
        DeoilVo deoilVo=new DeoilVo();
        List<DeoilVo> results= sourceService.getDeoilsByExample(deoilVo,page, limit);
        PageInfo<DeoilVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("溶剂使用源-去油污-重载")
    @GetMapping("/solvent/deoil/reload")
    @ResponseBody
    public PageResultBean<DeoilVo> deoilReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                               DeoilVo deoilVo) {
        List<DeoilVo> results= sourceService.getDeoilsByExample(deoilVo,page, limit);
        PageInfo<DeoilVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/solvent/deoil/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("溶剂使用源-去油污-删除")
    @DeleteMapping("/solvent/deoil/{id}")
    @ResponseBody
    public ResultBean deoilDelete(@PathVariable("id") Integer id) {
        sourceService.deleteDeoilById(id);
        return ResultBean.success();
    }

    @OperationLog("溶剂使用源-干洗店")
    @GetMapping("/solvent/dry")
    public String dry(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/dry-list";
    }
    @OperationLog("溶剂使用源-干洗店-列表")
    @GetMapping("/solvent/dry/list")
    @ResponseBody
    public PageResultBean<DryCleanerVo> dryList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                @RequestParam(value = "limit", defaultValue = "50")int limit) {
        DryCleanerVo dryCleanerVo=new DryCleanerVo();
        List<DryCleanerVo> results= sourceService.getDrysByExample(dryCleanerVo,page, limit);
        PageInfo<DryCleanerVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("溶剂使用源-干洗店-重载")
    @GetMapping("/solvent/dry/reload")
    @ResponseBody
    public PageResultBean<DryCleanerVo> dryReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                  DryCleanerVo dryCleanerVo) {
        List<DryCleanerVo> results= sourceService.getDrysByExample(dryCleanerVo,page, limit);
        PageInfo<DryCleanerVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/solvent/dry/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("溶剂使用源-干洗店-删除")
    @DeleteMapping("/solvent/dry/{id}")
    @ResponseBody
    public ResultBean dryDelete(@PathVariable("id") Integer id) {
        sourceService.deleteDryById(id);
        return ResultBean.success();
    }

    @OperationLog("溶剂使用源-家庭家居")
    @GetMapping("/solvent/house")
    public String house(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/house-list";
    }
    @OperationLog("溶剂使用源-家庭家居-列表")
    @GetMapping("/solvent/house/list")
    @ResponseBody
    public PageResultBean<HouseVo> houseList(@RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "limit", defaultValue = "50")int limit) {
        HouseVo houseVo=new HouseVo();
        List<HouseVo> results= sourceService.getHousesByExample(houseVo,page, limit);
        PageInfo<HouseVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("溶剂使用源-家庭家居-重载")
    @GetMapping("/solvent/house/reload")
    @ResponseBody
    public PageResultBean<HouseVo> houseReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                               HouseVo houseVo) {
        List<HouseVo> results= sourceService.getHousesByExample(houseVo,page, limit);
        PageInfo<HouseVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/solvent/house/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("溶剂使用源-家庭家居-删除")
    @DeleteMapping("/solvent/house/{id}")
    @ResponseBody
    public ResultBean houseDelete(@PathVariable("id") Integer id) {
        sourceService.deleteHouseById(id);
        return ResultBean.success();
    }

    @OperationLog("溶剂使用源-家庭家居")
    @GetMapping("/solvent/roadPa")
    public String roadPa(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/roadPa-list";
    }
    @OperationLog("溶剂使用源-家庭家居-列表")
    @GetMapping("/solvent/roadPa/list")
    @ResponseBody
    public PageResultBean<RoadPaveVo> roadPaList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit) {
        RoadPaveVo roadPaveVo=new RoadPaveVo();
        List<RoadPaveVo> results= sourceService.getRoadPasByExample(roadPaveVo,page, limit);
        PageInfo<RoadPaveVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("溶剂使用源-家庭家居-重载")
    @GetMapping("/solvent/roadPa/reload")
    @ResponseBody
    public PageResultBean<RoadPaveVo> roadPaReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                   RoadPaveVo roadPaveVo) {
        List<RoadPaveVo> results= sourceService.getRoadPasByExample(roadPaveVo,page, limit);
        PageInfo<RoadPaveVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/solvent/roadPa/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("溶剂使用源-家庭家居-删除")
    @DeleteMapping("/solvent/roadPa/{id}")
    @ResponseBody
    public ResultBean roadPaDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRoadPaById(id);
        return ResultBean.success();
    }
}
