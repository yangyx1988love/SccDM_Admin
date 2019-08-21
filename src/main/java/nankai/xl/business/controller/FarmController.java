package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.NPlant;
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
public class FarmController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    @OperationLog("农牧源-土壤本底")
    @GetMapping("/farm/baseSoil")
    public String baseSoil(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/baseSoil-list";
    }
    @OperationLog("农牧源-土壤本底-列表")
    @GetMapping("/farm/baseSoil/list")
    @ResponseBody
    public PageResultBean<BaseSoilVo> baseSoilList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit) {
        BaseSoilVo baseSoilVo=new BaseSoilVo();
        List<BaseSoilVo> results= sourceService.getBaseSoilsByExample(baseSoilVo,page, limit);
        PageInfo<BaseSoilVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农牧源-土壤本底-重载")
    @GetMapping("/farm/baseSoil/reload")
    @ResponseBody
    public PageResultBean<BaseSoilVo> baseSoilReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     BaseSoilVo baseSoilVo) {
        List<BaseSoilVo> results= sourceService.getBaseSoilsByExample(baseSoilVo,page, limit);
        PageInfo<BaseSoilVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/farm/baseSoil/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("农牧源-土壤本底-删除")
    @DeleteMapping("/farm/baseSoil/{id}")
    @ResponseBody
    public ResultBean baseSoilDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBaseSoilById(id);
        return ResultBean.success();
    }

    @OperationLog("农牧源-畜禽集约化养殖")
    @GetMapping("/farm/coBreed")
    public String coBreed(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/coBreed-list";
    }
    @OperationLog("农牧源-畜禽集约化养殖-列表")
    @GetMapping("/farm/coBreed/list")
    @ResponseBody
    public PageResultBean<CollectbreedingVo> coBreedList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit) {
        CollectbreedingVo collectbreedingVo=new CollectbreedingVo();
        List<CollectbreedingVo> results= sourceService.getCoBreedsByExample(collectbreedingVo,page, limit);
        PageInfo<CollectbreedingVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农牧源-畜禽集约化养殖-重载")
    @GetMapping("/farm/coBreed/reload")
    @ResponseBody
    public PageResultBean<CollectbreedingVo> coBreedReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                           CollectbreedingVo collectbreedingVo) {
        List<CollectbreedingVo> results= sourceService.getCoBreedsByExample(collectbreedingVo,page, limit);
        PageInfo<CollectbreedingVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/farm/coBreed/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("农牧源-畜禽集约化养殖-删除")
    @DeleteMapping("/farm/coBreed/{id}")
    @ResponseBody
    public ResultBean coBreedDelete(@PathVariable("id") Integer id) {
        sourceService.deleteCoBreedById(id);
        return ResultBean.success();
    }

    @OperationLog("农牧源-农肥施用源")
    @GetMapping("/farm/fertil")
    public String fertil(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/fertil-list";
    }
    @OperationLog("农牧源-农肥施用源-列表")
    @GetMapping("/farm/fertil/list")
    @ResponseBody
    public PageResultBean<FertilizationVo> fertilList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                      @RequestParam(value = "limit", defaultValue = "50")int limit) {
        FertilizationVo fertilizationVo=new FertilizationVo();
        List<FertilizationVo> results= sourceService.getFertilsByExample(fertilizationVo,page, limit);
        PageInfo<FertilizationVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农牧源-农肥施用源-重载")
    @GetMapping("/farm/fertil/reload")
    @ResponseBody
    public PageResultBean<FertilizationVo> fertilReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                        FertilizationVo fertilizationVo) {
        List<FertilizationVo> results= sourceService.getFertilsByExample(fertilizationVo,page, limit);
        PageInfo<FertilizationVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/farm/fertil/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("农牧源-农肥施用源-删除")
    @DeleteMapping("/farm/fertil/{id}")
    @ResponseBody
    public ResultBean fertilDelete(@PathVariable("id") Integer id) {
        sourceService.deleteFertilById(id);
        return ResultBean.success();
    }

    @OperationLog("农牧源-源畜牧散养源源")
    @GetMapping("/farm/freeStock")
    public String freeStock(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/freeStock-list";
    }
    @OperationLog("农牧源-源畜牧散养源源-列表")
    @GetMapping("/farm/freeStock/list")
    @ResponseBody
    public PageResultBean<FreeStockbreedingVo> freeStockList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                             @RequestParam(value = "limit", defaultValue = "50")int limit) {
        FreeStockbreedingVo freeStockbreedingVo=new FreeStockbreedingVo();
        List<FreeStockbreedingVo> results= sourceService.getFreeStocksByExample(freeStockbreedingVo,page, limit);
        PageInfo<FreeStockbreedingVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农牧源-源畜牧散养源源-重载")
    @GetMapping("/farm/freeStock/reload")
    @ResponseBody
    public PageResultBean<FreeStockbreedingVo> freeStockReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                               FreeStockbreedingVo freeStockbreedingVo) {
        List<FreeStockbreedingVo> results= sourceService.getFreeStocksByExample(freeStockbreedingVo,page, limit);
        PageInfo<FreeStockbreedingVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/farm/freeStock/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("农牧源-源畜牧散养源源-删除")
    @DeleteMapping("/farm/freeStock/{id}")
    @ResponseBody
    public ResultBean freeStockDelete(@PathVariable("id") Integer id) {
        sourceService.deleteFreeStockById(id);
        return ResultBean.success();
    }

    @OperationLog("农牧源-固氮植物源")
    @GetMapping("/farm/nPlant")
    public String nPlant(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/nPlant-list";
    }
    @OperationLog("农牧源-固氮植物源-列表")
    @GetMapping("/farm/nPlant/list")
    @ResponseBody
    public PageResultBean<NPlantVo> nPlantList(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "50")int limit) {
        NPlantVo nPlantVo=new NPlantVo();
        List<NPlantVo> results= sourceService.getNPlantsByExample(nPlantVo,page, limit);
        PageInfo<NPlantVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农牧源-固氮植物源-重载")
    @GetMapping("/farm/nPlant/reload")
    @ResponseBody
    public PageResultBean<NPlantVo> nPlantReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                 NPlantVo nPlantVo) {
        List<NPlantVo> results= sourceService.getNPlantsByExample(nPlantVo,page, limit);
        PageInfo<NPlantVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/farm/nPlant/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("农牧源-固氮植物源-删除")
    @DeleteMapping("/farm/nPlant/{id}")
    @ResponseBody
    public ResultBean nPlantDelete(@PathVariable("id") Integer id) {
        sourceService.deleteNPlantById(id);
        return ResultBean.success();
    }

    @OperationLog("农牧源-农药施用")
    @GetMapping("/farm/pesticide")
    public String pesticide(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/pesticide-list";
    }
    @OperationLog("农牧源-农药施用-列表")
    @GetMapping("/farm/pesticide/list")
    @ResponseBody
    public PageResultBean<PesticideVo> pesticideList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit) {
        PesticideVo pesticideVo=new PesticideVo();
        List<PesticideVo> results= sourceService.getPesticidesByExample(pesticideVo,page, limit);
        PageInfo<PesticideVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农牧源-农药施用-重载")
    @GetMapping("/farm/pesticide/reload")
    @ResponseBody
    public PageResultBean<PesticideVo> pesticideReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       PesticideVo pesticideVo) {
        List<PesticideVo> results= sourceService.getPesticidesByExample(pesticideVo,page, limit);
        PageInfo<PesticideVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/farm/pesticide/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("农牧源-农药施用-删除")
    @DeleteMapping("/farm/pesticide/{id}")
    @ResponseBody
    public ResultBean pesticideDelete(@PathVariable("id") Integer id) {
        sourceService.deletePesticideById(id);
        return ResultBean.success();
    }

    @OperationLog("农牧源-秸秆堆肥源")
    @GetMapping("/farm/strawCompost")
    public String strawCompost(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/strawCompost-list";
    }
    @OperationLog("农牧源-秸秆堆肥源-列表")
    @GetMapping("/farm/strawCompost/list")
    @ResponseBody
    public PageResultBean<StrawCompostVo> strawCompostList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                           @RequestParam(value = "limit", defaultValue = "50")int limit) {
        StrawCompostVo strawCompostVo=new StrawCompostVo();
        List<StrawCompostVo> results= sourceService.getStrawCompostsByExample(strawCompostVo,page, limit);
        PageInfo<StrawCompostVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农牧源-秸秆堆肥源-重载")
    @GetMapping("/farm/strawCompost/reload")
    @ResponseBody
    public PageResultBean<StrawCompostVo> strawCompostReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                             @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                             StrawCompostVo strawCompostVo) {
        List<StrawCompostVo> results= sourceService.getStrawCompostsByExample(strawCompostVo,page, limit);
        PageInfo<StrawCompostVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/farm/strawCompost/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("农牧源-秸秆堆肥源-删除")
    @DeleteMapping("/farm/strawCompost/{id}")
    @ResponseBody
    public ResultBean strawCompostDelete(@PathVariable("id") Integer id) {
        sourceService.deleteStrawCompostById(id);
        return ResultBean.success();
    }
}
