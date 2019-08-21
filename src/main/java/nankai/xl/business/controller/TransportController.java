package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
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
public class TransportController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    @OperationLog("存储运输源-加气站")
    @GetMapping("/transport/gas")
    public String gas(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/transport/gas-list";
    }
    @OperationLog("存储运输源-加气站-列表")
    @GetMapping("/transport/gas/list")
    @ResponseBody
    public PageResultBean<GasSourceVo> gasList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit) {
        GasSourceVo gasSourceVo=new GasSourceVo();
        List<GasSourceVo> results= sourceService.getGassByExample(gasSourceVo,page, limit);
        PageInfo<GasSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("存储运输源-加气站-重载")
    @GetMapping("/transport/gas/reload")
    @ResponseBody
    public PageResultBean<GasSourceVo> gasReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                 GasSourceVo gasSourceVo) {
        List<GasSourceVo> results= sourceService.getGassByExample(gasSourceVo,page, limit);
        PageInfo<GasSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/transport/gas/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("存储运输源-加气站-删除")
    @DeleteMapping("/transport/gas/{id}")
    @ResponseBody
    public ResultBean gasDelete(@PathVariable("id") Integer id) {
        sourceService.deleteGasById(id);
        return ResultBean.success();
    }


    @OperationLog("存储运输源-加油站")
    @GetMapping("/transport/oil")
    public String oil(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/transport/oil-list";
    }
    @OperationLog("存储运输源-加油站-列表")
    @GetMapping("/transport/oil/list")
    @ResponseBody
    public PageResultBean<OilSourceVo> oilList(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "50")int limit) {
        OilSourceVo oilSourceVo=new OilSourceVo();
        List<OilSourceVo> results= sourceService.getOilsByExample(oilSourceVo,page, limit);
        PageInfo<OilSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("存储运输源-加油站-重载")
    @GetMapping("/transport/oil/reload")
    @ResponseBody
    public PageResultBean<OilSourceVo> oilReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                 OilSourceVo oilSourceVo) {
        List<OilSourceVo> results= sourceService.getOilsByExample(oilSourceVo,page, limit);
        PageInfo<OilSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/transport/oil/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("存储运输源-加油站-删除")
    @DeleteMapping("/transport/oil/{id}")
    @ResponseBody
    public ResultBean oilDelete(@PathVariable("id") Integer id) {
        sourceService.deleteOilById(id);
        return ResultBean.success();
    }

    @OperationLog("存储运输源-装载过程排放")
    @GetMapping("/transport/oilTran")
    public String oilTran(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/transport/oilTran-list";
    }
    @OperationLog("存储运输源-装载过程排放-列表")
    @GetMapping("/transport/oilTran/list")
    @ResponseBody
    public PageResultBean<OilTransportVo> oilTranList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit) {
        OilTransportVo oilTransportVo=new OilTransportVo();
        List<OilTransportVo> results= sourceService.getOilTransByExample(oilTransportVo,page, limit);
        PageInfo<OilTransportVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("存储运输源-装载过程排放-重载")
    @GetMapping("/transport/oilTran/reload")
    @ResponseBody
    public PageResultBean<OilTransportVo> oilTranReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                        OilTransportVo oilTransportVo) {
        List<OilTransportVo> results= sourceService.getOilTransByExample(oilTransportVo,page, limit);
        PageInfo<OilTransportVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/transport/oilTran/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("存储运输源-装载过程排放-删除")
    @DeleteMapping("/transport/oilTran/{id}")
    @ResponseBody
    public ResultBean oilTranDelete(@PathVariable("id") Integer id) {
        sourceService.deleteOilTranById(id);
        return ResultBean.success();
    }

    @OperationLog("存储运输源-储罐存储")
    @GetMapping("/transport/tank")
    public String tank(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/transport/tank-list";
    }
    @OperationLog("存储运输源-储罐存储-列表")
    @GetMapping("/transport/tank/list")
    @ResponseBody
    public PageResultBean<TankSourceVo> tankList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit) {
        TankSourceVo tankSourceVo=new TankSourceVo();
        List<TankSourceVo> results= sourceService.getTanksByExample(tankSourceVo,page, limit);
        PageInfo<TankSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("存储运输源-储罐存储-重载")
    @GetMapping("/transport/tank/reload")
    @ResponseBody
    public PageResultBean<TankSourceVo> tankReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                   TankSourceVo tankSourceVo) {
        List<TankSourceVo> results= sourceService.getTanksByExample(tankSourceVo,page, limit);
        PageInfo<TankSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/transport/tank/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("存储运输源-储罐存储-删除")
    @DeleteMapping("/transport/tank/{id}")
    @ResponseBody
    public ResultBean tankDelete(@PathVariable("id") Integer id) {
        sourceService.deleteTankById(id);
        return ResultBean.success();
    }
}
