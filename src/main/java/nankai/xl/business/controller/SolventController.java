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
public class SolventController {
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
    private String scc1="14";

    @OperationLog("溶剂使用源-建筑涂装")
    @GetMapping("/solvent/build")
    public String build(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/build/build-list";
    }
    @OperationLog("建筑涂装-列表")
    @GetMapping("/solvent/build/list")
    @ResponseBody
    public PageResultBean<BuildingSmearVo> buildList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     BuildingSmearVo buildingSmearVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (buildingSmearVo.getCityCode()==null&&buildingSmearVo.getCountyId()==null){
            buildingSmearVo.setCityCode(cityCode);
            buildingSmearVo.setCountyId(countyCode);
        }
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
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(buildingSmearVo.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(buildingSmearVo.getScc2());
        scc4.setScc3(buildingSmearVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(buildingSmearVo.getCityCode()));
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("buildingSmearVo", buildingSmearVo);
        return "source/solvent/build/build-update";
    }
    @OperationLog("建筑涂装-新增")
    @GetMapping("/solvent/build/add")
    public String buildAdd(Model model) {
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/solvent/build/build-add";
    }
    @OperationLog("建筑涂装-编辑-保存")
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
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/car/car-list";
    }
    @OperationLog("汽修店-列表")
    @GetMapping("/solvent/car/list")
    @ResponseBody
    public PageResultBean<CarRepairVo> carList(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "50")int limit,
                                               CarRepairVo carRepairVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (carRepairVo.getCityCode()==null&&carRepairVo.getCountyId()==null){
            carRepairVo.setCityCode(cityCode);
            carRepairVo.setCountyId(countyCode);
        }
        List<CarRepairVo> results= sourceService.getCarsByExample(carRepairVo,page, limit);
        PageInfo<CarRepairVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }

    @OperationLog("汽修店-删除")
    @DeleteMapping("/solvent/car/{id}")
    @ResponseBody
    public ResultBean carDelete(@PathVariable("id") Integer id) {
        sourceService.deleteCarById(id);
        return ResultBean.success();
    }
    @OperationLog("汽修店-编辑")
    @GetMapping("/solvent/car/{id}")
    public String carEdit(@PathVariable("id") Integer id, Model model) {
        CarRepairVo carRepairVo=sourceService.getCarById(id);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(carRepairVo.getCityCode()));
        model.addAttribute("carRepairVo", carRepairVo);
        return "source/solvent/car/car-update";
    }
    @OperationLog("汽修店-新增")
    @GetMapping("/solvent/car/add")
    public String carAdd(Model model) {
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/solvent/car/car-add";
    }
    @OperationLog("汽修店-编辑-保存")
    @PutMapping("/solvent/car/edit")
    @ResponseBody
    public ResultBean carInsertOrUpdate(boolean isCul,CarRepairVo carRepairVo)  {
        carRepairVo.setScccode(scc1+"31"+carRepairVo.getScc3()+"000");
        SccVo sccVo=selectCommonService.selectBySccCode(carRepairVo.getScccode());
        carRepairVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateCar(carRepairVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("溶剂使用源-去油污")
    @GetMapping("/solvent/deoil")
    public String deoil(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/deoil/deoil-list";
    }
    @OperationLog("去油污-列表")
    @GetMapping("/solvent/deoil/list")
    @ResponseBody
    public PageResultBean<DeoilVo> deoilList(@RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "limit", defaultValue = "50")int limit,
                                             DeoilVo deoilVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (deoilVo.getCityCode()==null&&deoilVo.getCountyId()==null){
            deoilVo.setCityCode(cityCode);
            deoilVo.setCountyId(countyCode);
        }
        List<DeoilVo> results= sourceService.getDeoilsByExample(deoilVo,page, limit);
        PageInfo<DeoilVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("去油污-删除")
    @DeleteMapping("/solvent/deoil/{id}")
    @ResponseBody
    public ResultBean deoilDelete(@PathVariable("id") Integer id) {
        sourceService.deleteDeoilById(id);
        return ResultBean.success();
    }
    @OperationLog("去油污-编辑")
    @GetMapping("/solvent/deoil/{id}")
    public String deoilEdit(@PathVariable("id") Integer id, Model model) {
        DeoilVo deoilVo=sourceService.getDeoilById(id);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(deoilVo.getCityCode()));
        model.addAttribute("deoilVo", deoilVo);
        return "source/solvent/deoil/deoil-update";
    }
    @OperationLog("去油污-新增")
    @GetMapping("/solvent/deoil/add")
    public String deoilAdd(Model model) {
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/deoil/deoil-add";
    }
    @OperationLog("去油污-编辑-保存")
    @PutMapping("/solvent/deoil/edit")
    @ResponseBody
    public ResultBean deoilInsertOrUpdate(boolean isCul,DeoilVo deoilVo)  {
        deoilVo.setScccode("1451000000");
        SccVo sccVo=selectCommonService.selectBySccCode(deoilVo.getScccode());
        deoilVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateDeoil(deoilVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("溶剂使用源-干洗店")
    @GetMapping("/solvent/dry")
    public String dry(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/dry/dry-list";
    }
    @OperationLog("干洗店-列表")
    @GetMapping("/solvent/dry/list")
    @ResponseBody
    public PageResultBean<DryCleanerVo> dryList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                DryCleanerVo dryCleanerVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (dryCleanerVo.getCityCode()==null&&dryCleanerVo.getCountyId()==null){
            dryCleanerVo.setCityCode(cityCode);
            dryCleanerVo.setCountyId(countyCode);
        }
        List<DryCleanerVo> results= sourceService.getDrysByExample(dryCleanerVo,page, limit);
        PageInfo<DryCleanerVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("干洗店-删除")
    @DeleteMapping("/solvent/dry/{id}")
    @ResponseBody
    public ResultBean dryDelete(@PathVariable("id") Integer id) {
        sourceService.deleteDryById(id);
        return ResultBean.success();
    }
    @OperationLog("干洗店-编辑")
    @GetMapping("/solvent/dry/{id}")
    public String dryEdit(@PathVariable("id") Integer id, Model model) {
        DryCleanerVo dryCleanerVo=sourceService.getDryById(id);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(dryCleanerVo.getCityCode()));
        model.addAttribute("dryCleanerVo", dryCleanerVo);
        return "source/solvent/dry/dry-update";
    }
    @OperationLog("干洗店-新增")
    @GetMapping("/solvent/dry/add")
    public String dryAdd(Model model) {
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/solvent/dry/dry-add";
    }
    @OperationLog("干洗店-编辑-保存")
    @PutMapping("/solvent/dry/edit")
    @ResponseBody
    public ResultBean dryInsertOrUpdate(boolean isCul,DryCleanerVo dryCleanerVo)  {
        dryCleanerVo.setScccode(scc1+"30000"+dryCleanerVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(dryCleanerVo.getScccode());
        dryCleanerVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateDry(dryCleanerVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("溶剂使用源-家庭家居")
    @GetMapping("/solvent/house")
    public String house(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/house/house-list";
    }
    @OperationLog("家庭家居-列表")
    @GetMapping("/solvent/house/list")
    @ResponseBody
    public PageResultBean<HouseVo> houseList(@RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "limit", defaultValue = "50")int limit,
                                             HouseVo houseVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (houseVo.getCityCode()==null&&houseVo.getCountyId()==null){
            houseVo.setCityCode(cityCode);
            houseVo.setCountyId(countyCode);
        }
        List<HouseVo> results= sourceService.getHousesByExample(houseVo,page, limit);
        PageInfo<HouseVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("家庭家居-删除")
    @DeleteMapping("/solvent/house/{id}")
    @ResponseBody
    public ResultBean houseDelete(@PathVariable("id") Integer id) {
        sourceService.deleteHouseById(id);
        return ResultBean.success();
    }
    @OperationLog("家庭家居-编辑")
    @GetMapping("/solvent/house/{id}")
    public String houseEdit(@PathVariable("id") Integer id, Model model) {
        HouseVo houseVo=sourceService.getHouseById(id);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(houseVo.getCityCode()));
        model.addAttribute("houseVo", houseVo);
        return "source/solvent/house/house-update";
    }
    @OperationLog("家庭家居-新增")
    @GetMapping("/solvent/house/add")
    public String houseAdd(Model model) {
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/solvent/house/house-add";
    }
    @OperationLog("家庭家居-编辑-保存")
    @PutMapping("/solvent/house/edit")
    @ResponseBody
    public ResultBean houseInsertOrUpdate(boolean isCul,HouseVo houseVo)  {
        houseVo.setScccode(scc1+houseVo.getScc2()+"000000");
        SccVo sccVo=selectCommonService.selectBySccCode(houseVo.getScccode());
        houseVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateHouse(houseVo,isCul);
        return ResultBean.success();
    }

    @OperationLog("溶剂使用源-道路铺装")
    @GetMapping("/solvent/roadPa")
    public String roadPa(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/solvent/roadPa/roadPa-list";
    }
    @OperationLog("道路铺装-列表")
    @GetMapping("/solvent/roadPa/list")
    @ResponseBody
    public PageResultBean<RoadPaveVo> roadPaList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                 RoadPaveVo roadPaveVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (roadPaveVo.getCityCode()==null&&roadPaveVo.getCountyId()==null){
            roadPaveVo.setCityCode(cityCode);
            roadPaveVo.setCountyId(countyCode);
        }
        List<RoadPaveVo> results= sourceService.getRoadPasByExample(roadPaveVo,page, limit);
        PageInfo<RoadPaveVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("道路铺装-删除")
    @DeleteMapping("/solvent/roadPa/{id}")
    @ResponseBody
    public ResultBean roadPaDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRoadPaById(id);
        return ResultBean.success();
    }
    @OperationLog("道路铺装-编辑")
    @GetMapping("/solvent/roadPa/{id}")
    public String roadPaEdit(@PathVariable("id") Integer id, Model model) {
        RoadPaveVo roadPaveVo=sourceService.getRoadPaById(id);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(roadPaveVo.getCityCode()));
        model.addAttribute("roadPaveVo", roadPaveVo);
        return "source/solvent/roadPa/roadPa-update";
    }
    @OperationLog("道路铺装-新增")
    @GetMapping("/solvent/roadPa/add")
    public String roadPaAdd(Model model) {
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("citys", citys);
        return "source/solvent/roadPa/roadPa-add";
    }
    /*
        因为有scc表scc4有外键 scc中无
     */
    @OperationLog("道路铺装-编辑-保存")
    @PutMapping("/solvent/roadPa/edit")
    @ResponseBody
    public ResultBean roadPaInsertOrUpdate(boolean isCul,RoadPaveVo roadPaveVo)  {
        SccVo sccVo=selectCommonService.selectBySccCode(roadPaveVo.getScccode());
        roadPaveVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateRoadPa(roadPaveVo,isCul);
        return ResultBean.success();
    }
}
