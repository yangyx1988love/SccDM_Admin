package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
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
public class ProcessController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    private String scc1="11";

    private String scc2="17";

    @OperationLog("工艺过程源-石化有组织废气排放")
    @GetMapping("/process/shGas")
    public String shGas(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/process/shGas/shGas-list";
    }
    @OperationLog("工艺过程源-石化有组织废气排放-列表")
    @GetMapping("/process/shGas/list")
    @ResponseBody
    public PageResultBean<ShGasemissionVo> shGasList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     ShGasemissionVo shGasemissionVo) {
        List<ShGasemissionVo> results= sourceService.getShGasByShGas(shGasemissionVo,page, limit);
        PageInfo<ShGasemissionVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }

    @OperationLog("工艺过程源-石化有组织废气排放-删除")
    @DeleteMapping("/process/shGas/{id}")
    @ResponseBody
    public ResultBean shGasDelete(@PathVariable("id") Integer id) {
        sourceService.deleteShGaById(id);
        return ResultBean.success();
    }

    @OperationLog("石化有组织废气排放-编辑")
    @GetMapping("/process/shGas/{id}")
    public String shGasedit(@PathVariable("id") Integer id, Model model) {
        ShGasemissionVo shGasemissionVo=sourceService.getShGaById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(shGasemissionVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<County> countys=selectCommonService.getCountysByCityCode(shGasemissionVo.getCityCode());
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("shGasemissionVo", shGasemissionVo);
        return "source/process/shGas/shGas-update";
    }
    @OperationLog("石化有组织废气排放-新增")
    @GetMapping("/process/shGas/add")
    public String shGasadd(Model model) {
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("citys", citys);
        model.addAttribute("scc3s", scc3s);
        return "source/process/shGas/shGas-add";
    }
    @OperationLog("废水无组织排放-编辑-保存")
    @PutMapping("/process/shGas/edit")
    @ResponseBody
    public ResultBean shGasInsertOrUpdate(boolean isCul,ShGasemissionVo shGasemissionVo)  {
        shGasemissionVo.setScccode(scc1+scc2+shGasemissionVo.getScc3()+shGasemissionVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(shGasemissionVo.getScccode());
        shGasemissionVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateShGa(shGasemissionVo,isCul);
        return ResultBean.success();
    }

    @OperationLog("工艺过程源-装置密封点")
    @GetMapping("/process/shSeal")
    public String shSeal(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/process/shSeal/shSeal-list";
    }
    @OperationLog("工艺过程源-装置密封点-列表")
    @GetMapping("/process/shSeal/list")
    @ResponseBody
    public PageResultBean<ShSealpointVo> shSealList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "limit", defaultValue = "50")int limit) {
        ShSealpointVo shSealpointVo=new ShSealpointVo();
        List<ShSealpointVo> results= sourceService.getShSealsByExample(shSealpointVo,page, limit);
        PageInfo<ShSealpointVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }

    @OperationLog("工艺过程源-装置密封点-删除")
    @DeleteMapping("/process/shSeal/{id}")
    @ResponseBody
    public ResultBean shSealDelete(@PathVariable("id") Integer id) {
        sourceService.deleteShSealById(id);
        return ResultBean.success();
    }
    @OperationLog("装置密封点-编辑")
    @GetMapping("/process/shSeal/{id}")
    public String shSealEdit(@PathVariable("id") Integer id, Model model) {
        ShSealpointVo shSealpointVo=sourceService.getShSealById(id);

        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(shSealpointVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<County> countys=selectCommonService.getCountysByCityCode(shSealpointVo.getCityCode());
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("shSealpointVo", shSealpointVo);
        return "source/process/shSeal/shSeal-update";
    }
    @OperationLog("装置密封点-新增")
    @GetMapping("/process/shSeal/add")
    public String shSealAdd(Model model) {
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3("170");
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc4s", scc4s);
        return "source/process/shSeal/shSeal-add";
    }
    @OperationLog("装置密封点-编辑-保存")
    @PutMapping("/process/shSeal/edit")
    @ResponseBody
    public ResultBean shSealInsertOrUpdate(boolean isCul,ShSealpointVo shSealpointVo){
        shSealpointVo.setScccode(scc1+scc2+"170"+shSealpointVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(shSealpointVo.getScccode());
        shSealpointVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateShSeal(shSealpointVo,isCul);
        return ResultBean.success();
    }

    @OperationLog("工艺过程源-废水无组织排放")
    @GetMapping("/process/shEff")
    public String shEff(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/process/shEff/shEff-list";
    }
    @OperationLog("工艺过程源-废水无组织排放-列表")
    @GetMapping("/process/shEff/list")
    @ResponseBody
    public PageResultBean<ShEffluentemissionVo> shEffList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                          @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                          ShEffluentemissionVo shEffluentemissionVo) {
        List<ShEffluentemissionVo> results= sourceService.getShEffsByExample(shEffluentemissionVo,page, limit);
        PageInfo<ShEffluentemissionVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("工艺过程源-废水无组织排放-删除")
    @DeleteMapping("/process/shEff/{id}")
    @ResponseBody
    public ResultBean shEffDelete(@PathVariable("id") Integer id) {
        sourceService.deleteShEffById(id);
        return ResultBean.success();
    }
    @OperationLog("废水无组织排放-编辑")
    @GetMapping("/process/shEff/{id}")
    public String shEffedit(@PathVariable("id") Integer id, Model model) {
        ShEffluentemissionVo shEffluentemissionVo=sourceService.getShEffById(id);
        Scc4 scc4=new Scc4();
        scc4.setScc1("11");
        scc4.setScc2("17");
        scc4.setScc3("140");
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);
        List<County> countys=selectCommonService.getCountysByCityCode(shEffluentemissionVo.getCityCode());
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("shEffluentemissionVo", shEffluentemissionVo);
        return "source/process/shEff/shEff-update";
    }
    @OperationLog("废水无组织排放-新增")
    @GetMapping("/process/shEff/add")
    public String shEffadd(Model model) {
        Scc4 scc4=new Scc4();
        scc4.setScc1("11");
        scc4.setScc2("17");
        scc4.setScc3("140");
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc4s", scc4s);
        return "source/process/shEff/shEff-add";
    }
    @OperationLog("废水无组织排放-编辑-保存")
    @PutMapping("/process/shEff/edit")
    @ResponseBody
    public ResultBean shEffInsertOrUpdate(boolean isCul,ShEffluentemissionVo shEffluentemissionVo)  {
        shEffluentemissionVo.setScccode("1117140"+shEffluentemissionVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(shEffluentemissionVo.getScccode());
        shEffluentemissionVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateShEff(shEffluentemissionVo,isCul);
        return ResultBean.success();
    }

    @OperationLog("工艺过程源-VOC处理装置")
    @GetMapping("/process/shVoc")
    public String shVoc(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/process/shVoc/shVoc-list";
    }
    @OperationLog("工艺过程源-VOC处理装置-列表")
    @GetMapping("/process/shVoc/list")
    @ResponseBody
    public PageResultBean<ShVocdeviceeffiVo> shVocList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit) {
        ShVocdeviceeffiVo shVocdeviceeffiVo=new ShVocdeviceeffiVo();
        List<ShVocdeviceeffiVo> results= sourceService.getShVocsByExample(shVocdeviceeffiVo,page, limit);
        PageInfo<ShVocdeviceeffiVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }

    @OperationLog("工艺过程源-VOC处理装置-删除")
    @DeleteMapping("/process/shVoc/{id}")
    @ResponseBody
    public ResultBean shVocDelete(@PathVariable("id") Integer id) {
        sourceService.deleteShVocById(id);
        return ResultBean.success();
    }
    @OperationLog("VOC处理装置-编辑")
    @GetMapping("/process/shVoc/{id}")
    public String shVocEdit(@PathVariable("id") Integer id, Model model) {
        ShVocdeviceeffiVo shVocdeviceeffiVo=sourceService.getShVocById(id);
        List<County> countys=selectCommonService.getCountysByCityCode(shVocdeviceeffiVo.getCityCode());
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("shVocdeviceeffiVo", shVocdeviceeffiVo);
        return "source/process/shVoc/shVoc-update";
    }
    @OperationLog("VOC处理装置-新增")
    @GetMapping("/process/shVoc/add")
    public String shVocAdd(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/process/shVoc/shVoc-add";
    }
    @OperationLog("VOC处理装置-编辑-保存")
    @PutMapping("/process/shVoc/edit")
    @ResponseBody
    public ResultBean shVocInsertOrUpdate(boolean isCul,ShVocdeviceeffiVo shVocdeviceeffiVo)  {
        shVocdeviceeffiVo.setScccode("1117400211");
        SccVo sccVo=selectCommonService.selectBySccCode("1117400211");
        shVocdeviceeffiVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateShVoc(shVocdeviceeffiVo,isCul);
        return ResultBean.success();
    }
}
