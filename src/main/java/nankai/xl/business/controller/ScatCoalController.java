package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.ScatteredCoalVo;
import nankai.xl.business.service.SelectCommonService;
import nankai.xl.business.service.SourceService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.annotation.RefreshFilterChain;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ResultBean;
import nankai.xl.system.model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/source")
public class ScatCoalController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;
    @OperationLog("源管理界面-散煤")
    @GetMapping("/fixed/coal")
    public String process(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        return "source/fixed/list";
    }
    @OperationLog("散煤-列表")
    @GetMapping("/fixed/coal/list")
    @ResponseBody
    public PageResultBean<ScatteredCoalVo> getCoalList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       ScatteredCoalVo scatteredCoalVo) {
        List<ScatteredCoalVo> results= sourceService.getByScatteredCoals(scatteredCoalVo,page, limit);
        PageInfo<ScatteredCoalVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("散煤-删除")
    @DeleteMapping("/fixed/coal/{id}")
    @ResponseBody
    public ResultBean delete(@PathVariable("id") Integer id) {
        sourceService.deleteScatById(id);
        return ResultBean.success();
    }
    @OperationLog("散煤-新增")
    @GetMapping("/fixed/coal/add")
    public String add(Model model) {
        String scc1Code="10";
        String scc2Code="05";

        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1Code);
        scc3.setScc2(scc2Code);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);

        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1Code);
        model.addAttribute("scc2", scc2Code);
        model.addAttribute("scc3s", scc3s);
        return "source/fixed/coal-add";
    }
    @OperationLog("散煤-编辑")
    @GetMapping("/fixed/coal/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        ScatteredCoalVo scatteredCoalVo=sourceService.getScatById(id);
        String scc1Code="10";
        String scc2Code="05";
        String scc3Code=null;
        String scc4Code=null;
        if (scatteredCoalVo!=null){
            String sccCode=scatteredCoalVo.getSccCode();
            scc3Code=sccCode.substring(4,7);
            scc4Code=sccCode.substring(7,10);
        }else {
            scatteredCoalVo=new ScatteredCoalVo();
        }
        scatteredCoalVo.setScc3(scc3Code);
        scatteredCoalVo.setScc4(scc4Code);

        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1Code);
        scc3.setScc2(scc2Code);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1Code);
        scc4.setScc2(scc2Code);
        scc4.setScc3(scc3Code);
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("scc1", scc1Code);
        model.addAttribute("scc2", scc2Code);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("scatteredCoalVo", scatteredCoalVo);
        return "source/fixed/coal-update";
    }
    @OperationLog("编辑")
    @PutMapping("/fixed/coal/edit/{id}")
    @ResponseBody
    public ResultBean insertOrUpdate(@PathVariable("id") Integer id,ScatteredCoalVo scatteredCoalVo) {
        scatteredCoalVo.setSccCode("1005"+scatteredCoalVo.getScc3()+scatteredCoalVo.getScc4());
        sourceService.updateScatById(scatteredCoalVo);
        return ResultBean.success();
    }
    @OperationLog("新增")
    @PostMapping("/fixed/coal/add/")
    @ResponseBody
    public ResultBean insert(boolean isCul,ScatteredCoalVo scatteredCoalVo) {
        scatteredCoalVo.setSccCode("1005"+scatteredCoalVo.getScc3()+scatteredCoalVo.getScc4());
        sourceService.insertScatteredCoal(scatteredCoalVo);
        return ResultBean.success();
    }
}
