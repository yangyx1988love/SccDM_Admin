package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.ScatteredCoal;
import nankai.xl.business.model.ShGasemission;
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
    @OperationLog("工艺过程源-石化有组织废气排放")
    @GetMapping("/process/shGas")
    public String shGas(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/process/shGas-list";
    }
    @OperationLog("工艺过程源-石化有组织废气排放-列表")
    @GetMapping("/process/shGas/list")
    @ResponseBody
    public PageResultBean<ShGasemissionVo> shGasList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit) {
        ShGasemissionVo shGasemissionVo=new ShGasemissionVo();
        List<ShGasemissionVo> results= sourceService.getShGasByShGas(shGasemissionVo,page, limit);
        PageInfo<ShGasemissionVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("工艺过程源-石化有组织废气排放-重载")
    @GetMapping("/process/shGas/reload")
    @ResponseBody
    public PageResultBean<ShGasemissionVo> shGasReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       ShGasemissionVo shGasemissionVo) {
        List<ShGasemissionVo> results= sourceService.getShGasByShGas(shGasemissionVo,page, limit);
        PageInfo<ShGasemissionVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
//    @OperationLog("散煤-编辑")
//    @GetMapping("/process/shGas/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("工艺过程源-石化有组织废气排放-删除")
    @DeleteMapping("/process/shGas/{id}")
    @ResponseBody
    public ResultBean shGasDelete(@PathVariable("id") Integer id) {
        sourceService.deleteShGaById(id);
        return ResultBean.success();
    }

    @OperationLog("工艺过程源-装置密封点")
    @GetMapping("/process/shSeal")
    public String shSeal(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/process/shSeal-list";
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
    @OperationLog("工艺过程源-装置密封点-重载")
    @GetMapping("/process/shSeal/reload")
    @ResponseBody
    public PageResultBean<ShSealpointVo> shSealReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                      ShSealpointVo shSealpointVo) {
        List<ShSealpointVo> results= sourceService.getShSealsByExample(shSealpointVo,page, limit);
        PageInfo<ShSealpointVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/process/shSeal/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("工艺过程源-装置密封点-删除")
    @DeleteMapping("/process/shSeal/{id}")
    @ResponseBody
    public ResultBean shSealDelete(@PathVariable("id") Integer id) {
        sourceService.deleteShSealById(id);
        return ResultBean.success();
    }

    @OperationLog("工艺过程源-废水无组织排放")
    @GetMapping("/process/shEff")
    public String shEff(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/process/shEff-list";
    }
    @OperationLog("工艺过程源-废水无组织排放-列表")
    @GetMapping("/process/shEff/list")
    @ResponseBody
    public PageResultBean<ShEffluentemissionVo> shEffList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                          @RequestParam(value = "limit", defaultValue = "50")int limit) {
        ShEffluentemissionVo shEffluentemissionVo=new ShEffluentemissionVo();
        List<ShEffluentemissionVo> results= sourceService.getShEffsByExample(shEffluentemissionVo,page, limit);
        PageInfo<ShEffluentemissionVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("工艺过程源-废水无组织排放-重载")
    @GetMapping("/process/shEff/reload")
    @ResponseBody
    public PageResultBean<ShEffluentemissionVo> shEffReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                        ShEffluentemissionVo shEffluentemissionVo) {
        List<ShEffluentemissionVo> results= sourceService.getShEffsByExample(shEffluentemissionVo,page, limit);
        PageInfo<ShEffluentemissionVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/process/shEff/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("工艺过程源-废水无组织排放-删除")
    @DeleteMapping("/process/shEff/{id}")
    @ResponseBody
    public ResultBean shEffDelete(@PathVariable("id") Integer id) {
        sourceService.deleteShEffById(id);
        return ResultBean.success();
    }

    @OperationLog("工艺过程源-VOC处理装置")
    @GetMapping("/process/shVoc")
    public String shVoc(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/process/shVoc-list";
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
    @OperationLog("工艺过程源-VOC处理装置-重载")
    @GetMapping("/process/shVoc/reload")
    @ResponseBody
    public PageResultBean<ShVocdeviceeffiVo> shVocReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                            @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         ShVocdeviceeffiVo shVocdeviceeffiVo) {
        List<ShVocdeviceeffiVo> results= sourceService.getShVocsByExample(shVocdeviceeffiVo,page, limit);
        PageInfo<ShVocdeviceeffiVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/process/shVoc/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("工艺过程源-VOC处理装置-删除")
    @DeleteMapping("/process/shVoc/{id}")
    @ResponseBody
    public ResultBean shVocDelete(@PathVariable("id") Integer id) {
        sourceService.deleteShVocById(id);
        return ResultBean.success();
    }
}
