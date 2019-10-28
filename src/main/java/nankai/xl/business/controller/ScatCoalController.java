package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.ScatteredCoalVo;
import nankai.xl.business.model.vo.SccVo;
import nankai.xl.business.service.SelectCommonService;
import nankai.xl.business.service.SourceService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.annotation.RefreshFilterChain;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ResultBean;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/source")
public class ScatCoalController {
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
    private String scc1="10";
    private String scc2="05";
    @OperationLog("源管理界面-散煤")
    @GetMapping("/fixed/coal")
    public String process(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/fixed/coal-list";
    }
    @OperationLog("散煤-列表")
    @GetMapping("/fixed/coal/list")
    @ResponseBody
    public PageResultBean<ScatteredCoalVo> getCoalList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       ScatteredCoalVo scatteredCoalVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (scatteredCoalVo.getCityCode()==null&&scatteredCoalVo.getCountyId()==null){
            scatteredCoalVo.setCityCode(cityCode);
            scatteredCoalVo.setCountyId(countyCode);
        }
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
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/fixed/coal-add";
    }
    @OperationLog("散煤-编辑")
    @GetMapping("/fixed/coal/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        ScatteredCoalVo scatteredCoalVo=sourceService.getScatById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(scatteredCoalVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(scatteredCoalVo.getCityCode()));
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("scatteredCoalVo", scatteredCoalVo);
        return "source/fixed/coal-update";
    }
    @OperationLog("散煤-编辑-保存")
    @PutMapping("/fixed/coal/edit")
    @ResponseBody
    public ResultBean insertOrUpdate(boolean isCul,ScatteredCoalVo scatteredCoalVo) {
        scatteredCoalVo.setSccCode(scc1+scc2+scatteredCoalVo.getScc3()+scatteredCoalVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(scatteredCoalVo.getSccCode());
        scatteredCoalVo.setSourceDescription(sccVo.getDescription());
        sourceService.insertOrUpdateScatteredCoal(scatteredCoalVo,isCul);
        return ResultBean.success();
    }
}
