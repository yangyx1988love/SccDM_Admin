package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
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
public class FarmController {
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

    private  String scc1="17";
    @OperationLog("农牧源-土壤本底")
    @GetMapping("/farm/baseSoil")
    public String baseSoil(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/baseSoil/baseSoil-list";
    }
    @OperationLog("土壤本底-列表")
    @GetMapping("/farm/baseSoil/list")
    @ResponseBody
    public PageResultBean<BaseSoilVo> baseSoilList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                               BaseSoilVo baseSoilVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (baseSoilVo.getCityCode()==null&&baseSoilVo.getCountyId()==null){
            baseSoilVo.setCityCode(cityCode);
            baseSoilVo.setCountyId(countyCode);
        }
        List<BaseSoilVo> results= sourceService.getBaseSoilsByExample(baseSoilVo,page, limit);
        PageInfo<BaseSoilVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("土壤本底-删除")
    @DeleteMapping("/farm/baseSoil/{id}")
    @ResponseBody
    public ResultBean baseSoilDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBaseSoilById(id);
        return ResultBean.success();
    }
    @OperationLog("土壤本底-编辑")
    @GetMapping("/farm/baseSoil/{id}")
    public String baseSoilEdit(@PathVariable("id") Integer id, Model model) {
        BaseSoilVo baseSoilVo=sourceService.getBaseSoilById(id);
        baseSoilVo.setScc1(scc1);
        baseSoilVo.setScc2("04");
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"04");
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"04"+baseSoilVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(baseSoilVo.getCityCode()));
        model.addAttribute("citys", citys);
        model.addAttribute("baseSoilVo", baseSoilVo);
        return "source/farm/baseSoil/baseSoil-update";
    }
    @OperationLog("土壤本底-新增")
    @GetMapping("/farm/baseSoil/add")
    public String baseSoilAdd(Model model) {
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"04");
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "04");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/baseSoil/baseSoil-add";
    }
    @OperationLog("土壤本底-编辑-保存")
    @PutMapping("/farm/baseSoil/edit")
    @ResponseBody
    public ResultBean baseSoilInsertOrUpdate(boolean isCul,BaseSoilVo baseSoilVo)  {
        baseSoilVo.setScccode(scc1+"04"+baseSoilVo.getScc3()+baseSoilVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(baseSoilVo.getScccode());
        baseSoilVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateBaseSoil(baseSoilVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("农牧源-畜禽集约化养殖")
    @GetMapping("/farm/coBreed")
    public String coBreed(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/coBreed/coBreed-list";
    }
    @OperationLog("畜禽集约化养殖-列表")
    @GetMapping("/farm/coBreed/list")
    @ResponseBody
    public PageResultBean<CollectbreedingVo> coBreedList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         CollectbreedingVo collectbreedingVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (collectbreedingVo.getCityCode()==null&&collectbreedingVo.getCountyId()==null){
            collectbreedingVo.setCityCode(cityCode);
            collectbreedingVo.setCountyId(countyCode);
        }
        List<CollectbreedingVo> results= sourceService.getCoBreedsByExample(collectbreedingVo,page, limit);
        PageInfo<CollectbreedingVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("畜禽集约化养殖-删除")
    @DeleteMapping("/farm/coBreed/{id}")
    @ResponseBody
    public ResultBean coBreedDelete(@PathVariable("id") Integer id) {
        sourceService.deleteCoBreedById(id);
        return ResultBean.success();
    }
    @OperationLog("畜禽集约化养殖-编辑")
    @GetMapping("/farm/coBreed/{id}")
    public String coBreedEdit(@PathVariable("id") Integer id, Model model) {
        CollectbreedingVo collectbreedingVo=sourceService.getCoBreedById(id);
        collectbreedingVo.setScc1(scc1);
        collectbreedingVo.setScc2("02");
        List<Scc3> scc3List=selectCommonService.getScc3BySccCode12(scc1+"02");
        List<Scc3> scc3s=new ArrayList<>();
        for (Scc3 scc3:scc3List) {
            if (scc3.getDescription().contains("集中")){
                scc3s.add(scc3);
            }
        }
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"02"+collectbreedingVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(collectbreedingVo.getCityCode()));
        model.addAttribute("collectbreedingVo", collectbreedingVo);
        return "source/farm/coBreed/coBreed-update";
    }
    @OperationLog("畜禽集约化养殖-新增")
    @GetMapping("/farm/coBreed/add")
    public String coBreedAdd(Model model) {
        List<Scc3> scc3List=selectCommonService.getScc3BySccCode12(scc1+"02");
        List<Scc3> scc3s=new ArrayList<>();
        for (Scc3 scc3:scc3List) {
            if (scc3.getDescription().contains("集中")){
                scc3s.add(scc3);
            }
        }
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "02");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/coBreed/coBreed-add";
    }
    @OperationLog("畜禽集约化养殖-编辑-保存")
    @PutMapping("/farm/coBreed/edit")
    @ResponseBody
    public ResultBean coBreedInsertOrUpdate(boolean isCul,CollectbreedingVo collectbreedingVo)  {
        collectbreedingVo.setScccode(scc1+"02"+collectbreedingVo.getScc3()+collectbreedingVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(collectbreedingVo.getScccode());
        collectbreedingVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateCoBreed(collectbreedingVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("农牧源-农肥施用源")
    @GetMapping("/farm/fertil")
    public String fertil(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/fertil/fertil-list";
    }
    @OperationLog("农肥施用源-列表")
    @GetMapping("/farm/fertil/list")
    @ResponseBody
    public PageResultBean<FertilizationVo> fertilList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                      @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                      FertilizationVo fertilizationVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (fertilizationVo.getCityCode()==null&&fertilizationVo.getCountyId()==null){
            fertilizationVo.setCityCode(cityCode);
            fertilizationVo.setCountyId(countyCode);
        }
        List<FertilizationVo> results= sourceService.getFertilsByExample(fertilizationVo,page, limit);
        PageInfo<FertilizationVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农肥施用源-删除")
    @DeleteMapping("/farm/fertil/{id}")
    @ResponseBody
    public ResultBean fertilDelete(@PathVariable("id") Integer id) {
        sourceService.deleteFertilById(id);
        return ResultBean.success();
    }
    @OperationLog("农肥施用源-编辑")
    @GetMapping("/farm/fertil/{id}")
    public String fertilEdit(@PathVariable("id") Integer id, Model model) {
        FertilizationVo fertilizationVo=sourceService.getFertilById(id);
        fertilizationVo.setScc1(scc1);
        fertilizationVo.setScc2("01");
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"01");
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"01"+fertilizationVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("citys", citys);
        model.addAttribute("countys",selectCommonService.getCountysByCityCode(fertilizationVo.getCityCode()));
        model.addAttribute("fertilizationVo", fertilizationVo);
        return "source/farm/fertil/fertil-update";
    }
    @OperationLog("农肥施用源-新增")
    @GetMapping("/farm/fertil/add")
    public String fertilAdd(Model model) {
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"01");
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "01");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/fertil/fertil-add";
    }
    @OperationLog("农肥施用源-编辑-保存")
    @PutMapping("/farm/fertil/edit")
    @ResponseBody
    public ResultBean fertilInsertOrUpdate(boolean isCul,FertilizationVo fertilizationVo)  {
        fertilizationVo.setScccode(scc1+"01"+fertilizationVo.getScc3()+fertilizationVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(fertilizationVo.getScccode());
        fertilizationVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateFertil(fertilizationVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("农牧源-源畜牧散养源")
    @GetMapping("/farm/freeStock")
    public String freeStock(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/freeStock/freeStock-list";
    }
    @OperationLog("源畜牧散养源-列表")
    @GetMapping("/farm/freeStock/list")
    @ResponseBody
    public PageResultBean<FreeStockbreedingVo> freeStockList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                             @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                             FreeStockbreedingVo freeStockbreedingVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (freeStockbreedingVo.getCityCode()==null&&freeStockbreedingVo.getCountyId()==null){
            freeStockbreedingVo.setCityCode(cityCode);
            freeStockbreedingVo.setCountyId(countyCode);
        }
        List<FreeStockbreedingVo> results= sourceService.getFreeStocksByExample(freeStockbreedingVo,page, limit);
        PageInfo<FreeStockbreedingVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("源畜牧散养源-删除")
    @DeleteMapping("/farm/freeStock/{id}")
    @ResponseBody
    public ResultBean freeStockDelete(@PathVariable("id") Integer id) {
        sourceService.deleteFreeStockById(id);
        return ResultBean.success();
    }
    @OperationLog("源畜牧散养源-编辑")
    @GetMapping("/farm/freeStock/{id}")
    public String freeStockEdit(@PathVariable("id") Integer id, Model model) {
        FreeStockbreedingVo freeStockbreedingVo=sourceService.getFreeStockById(id);
        freeStockbreedingVo.setScc1(scc1);
        freeStockbreedingVo.setScc2("02");
        List<Scc3> scc3List=selectCommonService.getScc3BySccCode12(scc1+"02");
        List<Scc3> scc3s=new ArrayList<>();
        for (Scc3 scc3:scc3List) {
            if (!scc3.getDescription().contains("集中")){
                scc3s.add(scc3);
            }
        }
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"02"+freeStockbreedingVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("citys", citys);
        model.addAttribute("countys",selectCommonService.getCountysByCityCode(freeStockbreedingVo.getCityCode()));
        model.addAttribute("freeStockbreedingVo", freeStockbreedingVo);
        return "source/farm/freeStock/freeStock-update";
    }
    @OperationLog("源畜牧散养源-新增")
    @GetMapping("/farm/freeStock/add")
    public String freeStockAdd(Model model) {
        List<Scc3> scc3List=selectCommonService.getScc3BySccCode12(scc1+"02");
        List<Scc3> scc3s=new ArrayList<>();
        for (Scc3 scc3:scc3List) {
            if (!scc3.getDescription().contains("集中")){
                scc3s.add(scc3);
            }
        }
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "02");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/freeStock/freeStock-add";
    }
    @OperationLog("源畜牧散养源-编辑-保存")
    @PutMapping("/farm/freeStock/edit")
    @ResponseBody
    public ResultBean freeStockInsertOrUpdate(boolean isCul,FreeStockbreedingVo freeStockbreedingVo)  {
        freeStockbreedingVo.setScccode(scc1+"02"+freeStockbreedingVo.getScc3()+freeStockbreedingVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(freeStockbreedingVo.getScccode());
        freeStockbreedingVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateFreeStock(freeStockbreedingVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("农牧源-固氮植物源")
    @GetMapping("/farm/nPlant")
    public String nPlant(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/nPlant/nPlant-list";
    }
    @OperationLog("固氮植物源-列表")
    @GetMapping("/farm/nPlant/list")
    @ResponseBody
    public PageResultBean<NPlantVo> nPlantList(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "50")int limit,
                                               NPlantVo nPlantVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (nPlantVo.getCityCode()==null&&nPlantVo.getCountyId()==null){
            nPlantVo.setCityCode(cityCode);
            nPlantVo.setCountyId(countyCode);
        }
        List<NPlantVo> results= sourceService.getNPlantsByExample(nPlantVo,page, limit);
        PageInfo<NPlantVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("固氮植物源-删除")
    @DeleteMapping("/farm/nPlant/{id}")
    @ResponseBody
    public ResultBean nPlantDelete(@PathVariable("id") Integer id) {
        sourceService.deleteNPlantById(id);
        return ResultBean.success();
    }
    @OperationLog("固氮植物源-编辑")
    @GetMapping("/farm/nPlant/{id}")
    public String nPlantEdit(@PathVariable("id") Integer id, Model model) {
        NPlantVo nPlantVo=sourceService.getNPlantById(id);
        nPlantVo.setScc1(scc1);
        nPlantVo.setScc2("05");
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"05");
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"05"+nPlantVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(nPlantVo.getCityCode()));
        model.addAttribute("nPlantVo", nPlantVo);
        return "source/farm/nPlant/nPlant-update";
    }
    @OperationLog("固氮植物源-新增")
    @GetMapping("/farm/nPlant/add")
    public String nPlantAdd(Model model) {
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"05");
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "05");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/nPlant/nPlant-add";
    }
    @OperationLog("固氮植物源-编辑-保存")
    @PutMapping("/farm/nPlant/edit")
    @ResponseBody
    public ResultBean nPlantInsertOrUpdate(boolean isCul,NPlantVo nPlantVo)  {
        nPlantVo.setScccode(scc1+"05"+nPlantVo.getScc3()+nPlantVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(nPlantVo.getScccode());
        nPlantVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateNPlant(nPlantVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("农牧源-农药施用")
    @GetMapping("/farm/pesticide")
    public String pesticide(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/pesticide/pesticide-list";
    }
    @OperationLog("农药施用-列表")
    @GetMapping("/farm/pesticide/list")
    @ResponseBody
    public PageResultBean<PesticideVo> pesticideList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     PesticideVo pesticideVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (pesticideVo.getCityCode()==null&&pesticideVo.getCountyId()==null){
            pesticideVo.setCityCode(cityCode);
            pesticideVo.setCountyId(countyCode);
        }
        List<PesticideVo> results= sourceService.getPesticidesByExample(pesticideVo,page, limit);
        PageInfo<PesticideVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农药施用-删除")
    @DeleteMapping("/farm/pesticide/{id}")
    @ResponseBody
    public ResultBean pesticideDelete(@PathVariable("id") Integer id) {
        sourceService.deletePesticideById(id);
        return ResultBean.success();
    }
    @OperationLog("农药施用-编辑")
    @GetMapping("/farm/pesticide/{id}")
    public String pesticideEdit(@PathVariable("id") Integer id, Model model) {
        PesticideVo pesticideVo=sourceService.getPesticideById(id);
        pesticideVo.setScc1(scc1);
        pesticideVo.setScc2("03");
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"03");
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"03"+pesticideVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(pesticideVo.getCityCode()));
        model.addAttribute("pesticideVo", pesticideVo);
        return "source/farm/pesticide/pesticide-update";
    }
    @OperationLog("农药施用-新增")
    @GetMapping("/farm/pesticide/add")
    public String pesticideAdd(Model model) {
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"03");
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "03");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/pesticide/pesticide-add";
    }
    @OperationLog("农药施用-编辑-保存")
    @PutMapping("/farm/pesticide/edit")
    @ResponseBody
    public ResultBean pesticideInsertOrUpdate(boolean isCul,PesticideVo pesticideVo)  {
        pesticideVo.setScccode(scc1+"03"+pesticideVo.getScc3()+pesticideVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(pesticideVo.getScccode());
        pesticideVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdatePesticide(pesticideVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("农牧源-秸秆堆肥源")
    @GetMapping("/farm/strawCompost")
    public String strawCompost(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/strawCompost/strawCompost-list";
    }
    @OperationLog("农牧源-秸秆堆肥源-列表")
    @GetMapping("/farm/strawCompost/list")
    @ResponseBody
    public PageResultBean<StrawCompostVo> strawCompostList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                           @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                           StrawCompostVo strawCompostVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (strawCompostVo.getCityCode()==null&&strawCompostVo.getCountyId()==null){
            strawCompostVo.setCityCode(cityCode);
            strawCompostVo.setCountyId(countyCode);
        }
        List<StrawCompostVo> results= sourceService.getStrawCompostsByExample(strawCompostVo,page, limit);
        PageInfo<StrawCompostVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("农牧源-秸秆堆肥源-删除")
    @DeleteMapping("/farm/strawCompost/{id}")
    @ResponseBody
    public ResultBean strawCompostDelete(@PathVariable("id") Integer id) {
        sourceService.deleteStrawCompostById(id);
        return ResultBean.success();
    }
    @OperationLog("秸秆堆肥源-编辑")
    @GetMapping("/farm/strawCompost/{id}")
    public String strawCompostEdit(@PathVariable("id") Integer id, Model model) {
        StrawCompostVo strawCompostVo=sourceService.getStrawCompostById(id);
        strawCompostVo.setScc1(scc1);
        strawCompostVo.setScc2("06");
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"06");
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"06"+strawCompostVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(strawCompostVo.getCityCode()));
        model.addAttribute("strawCompostVo", strawCompostVo);
        return "source/farm/strawCompost/strawCompost-update";
    }
    @OperationLog("秸秆堆肥源-新增")
    @GetMapping("/farm/strawCompost/add")
    public String strawCompostAdd(Model model) {
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"06");
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "06");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/farm/strawCompost/strawCompost-add";
    }
    @OperationLog("秸秆堆肥源-编辑-保存")
    @PutMapping("/farm/strawCompost/edit")
    @ResponseBody
    public ResultBean strawCompostInsertOrUpdate(boolean isCul,StrawCompostVo strawCompostVo)  {
        strawCompostVo.setScccode(scc1+"06"+strawCompostVo.getScc3()+strawCompostVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(strawCompostVo.getScccode());
        strawCompostVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateStrawCompost(strawCompostVo,isCul);
        return ResultBean.success();
    }
}
