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
public class TransportController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    private String scc1="15";

    @OperationLog("存储运输源-加气站")
    @GetMapping("/transport/gas")
    public String gas(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/transport/gas/gas-list";
    }
    @OperationLog("加气站-列表")
    @GetMapping("/transport/gas/list")
    @ResponseBody
    public PageResultBean<GasSourceVo> gasList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit) {
        GasSourceVo gasSourceVo=new GasSourceVo();
        List<GasSourceVo> results= sourceService.getGassByExample(gasSourceVo,page, limit);
        PageInfo<GasSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("加气站-删除")
    @DeleteMapping("/transport/gas/{id}")
    @ResponseBody
    public ResultBean gasDelete(@PathVariable("id") Integer id) {
        sourceService.deleteGasById(id);
        return ResultBean.success();
    }
    @OperationLog("加气站-编辑")
    @GetMapping("/transport/gas/{id}")
    public String gasEdit(@PathVariable("id") Integer id, Model model) {
        GasSourceVo gasSourceVo=sourceService.getGasById(id);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2("23");
        scc4.setScc3(gasSourceVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(gasSourceVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("gasSourceVo", gasSourceVo);
        return "source/transport/gas/gas-update";
    }
    @OperationLog("加气站-新增")
    @GetMapping("/transport/gas/add")
    public String gasAdd(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "23");
        return "source/transport/gas/gas-add";
    }
    @OperationLog("加气站-编辑-保存")
    @PutMapping("/transport/gas/edit")
    @ResponseBody
    public ResultBean gasInsertOrUpdate(boolean isCul,GasSourceVo gasSourceVo)  {
        gasSourceVo.setScccode(scc1+"23"+gasSourceVo.getScc3()+gasSourceVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(gasSourceVo.getScccode());
        gasSourceVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateGas(gasSourceVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("存储运输源-加油站")
    @GetMapping("/transport/oil")
    public String oil(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/transport/oil/oil-list";
    }
    @OperationLog("加油站-列表")
    @GetMapping("/transport/oil/list")
    @ResponseBody
    public PageResultBean<OilSourceVo> oilList(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "50")int limit) {
        OilSourceVo oilSourceVo=new OilSourceVo();
        List<OilSourceVo> results= sourceService.getOilsByExample(oilSourceVo,page, limit);
        PageInfo<OilSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("加油站-删除")
    @DeleteMapping("/transport/oil/{id}")
    @ResponseBody
    public ResultBean oilDelete(@PathVariable("id") Integer id) {
        sourceService.deleteOilById(id);
        return ResultBean.success();
    }
    @OperationLog("加油站-编辑")
    @GetMapping("/transport/oil/{id}")
    public String oilEdit(@PathVariable("id") Integer id, Model model) {
        OilSourceVo oilSourceVo=sourceService.getOilById(id);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2("23");
        scc4.setScc3(oilSourceVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(oilSourceVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("oilSourceVo", oilSourceVo);
        return "source/transport/oil/oil-update";
    }
    @OperationLog("加油站-新增")
    @GetMapping("/transport/oil/add")
    public String oilAdd(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "23");
        return "source/transport/oil/oil-add";
    }
    @OperationLog("加油站-编辑-保存")
    @PutMapping("/transport/oil/edit")
    @ResponseBody
    public ResultBean oilInsertOrUpdate(boolean isCul,OilSourceVo oilSourceVo)  {
        oilSourceVo.setScccode(scc1+"23"+oilSourceVo.getScc3()+oilSourceVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(oilSourceVo.getScccode());
        oilSourceVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateOil(oilSourceVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("存储运输源-装载过程排放")
    @GetMapping("/transport/oilTran")
    public String oilTran(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/transport/oilTran/oilTran-list";
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
    @OperationLog("装载过程排放-删除")
    @DeleteMapping("/transport/oilTran/{id}")
    @ResponseBody
    public ResultBean oilTranDelete(@PathVariable("id") Integer id) {
        sourceService.deleteOilTranById(id);
        return ResultBean.success();
    }
    @OperationLog("存储运输源-编辑")
    @GetMapping("/transport/oilTran/{id}")
    public String oilTranEdit(@PathVariable("id") Integer id, Model model) {
        OilTransportVo oilTransportVo=sourceService.getOilTranById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(oilTransportVo.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);

        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(oilTransportVo.getScc2());
        scc4.setScc3(oilTransportVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(oilTransportVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("oilTransportVo", oilTransportVo);
        return "source/transport/oilTran/oilTran-update";
    }
    @OperationLog("存储运输源-新增")
    @GetMapping("/transport/oilTran/add")
    public String oilTranAdd(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/transport/oilTran/oilTran-add";
    }
    @OperationLog("存储运输源-编辑-保存")
    @PutMapping("/transport/oilTran/edit")
    @ResponseBody
    public ResultBean oilTranInsertOrUpdate(boolean isCul,OilTransportVo oilTransportVo)  {
        oilTransportVo.setScccode(scc1+oilTransportVo.getScc2()+oilTransportVo.getScc3()+oilTransportVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(oilTransportVo.getScccode());
        oilTransportVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateOilTran(oilTransportVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("存储运输源-储罐存储")
    @GetMapping("/transport/tank")
    public String tank(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/transport/tank/tank-list";
    }
    @OperationLog("储罐存储-列表")
    @GetMapping("/transport/tank/list")
    @ResponseBody
    public PageResultBean<TankSourceVo> tankList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit) {
        TankSourceVo tankSourceVo=new TankSourceVo();
        List<TankSourceVo> results= sourceService.getTanksByExample(tankSourceVo,page, limit);
        PageInfo<TankSourceVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("储罐存储-删除")
    @DeleteMapping("/transport/tank/{id}")
    @ResponseBody
    public ResultBean tankDelete(@PathVariable("id") Integer id) {
        sourceService.deleteTankById(id);
        return ResultBean.success();
    }
    @OperationLog("储罐存储-编辑")
    @GetMapping("/transport/tank/{id}")
    public String tankEdit(@PathVariable("id") Integer id, Model model) {
        TankSourceVo tankSourceVo=sourceService.getTankById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(tankSourceVo.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);

        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(tankSourceVo.getScc2());
        scc4.setScc3(tankSourceVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(tankSourceVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("tankSourceVo", tankSourceVo);
        return "source/transport/tank/tank-update";
    }
    @OperationLog("储罐存储-新增")
    @GetMapping("/transport/tank/add")
    public String tankAdd(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/transport/tank/tank-add";
    }
    @OperationLog("储罐存储-编辑-保存")
    @PutMapping("/transport/tank/edit")
    @ResponseBody
    public ResultBean tankInsertOrUpdate(boolean isCul,TankSourceVo tankSourceVo)  {
        tankSourceVo.setScccode(scc1+tankSourceVo.getScc2()+tankSourceVo.getScc3()+tankSourceVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(tankSourceVo.getScccode());
        tankSourceVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateTank(tankSourceVo,isCul);
        return ResultBean.success();
    }
}
