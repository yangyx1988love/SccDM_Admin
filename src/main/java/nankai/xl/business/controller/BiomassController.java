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
public class BiomassController {
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

    private String scc1="18";

    @OperationLog("生物质燃烧源-生物质锅炉")
    @GetMapping("/biomass/bioBoiler")
    public String bioBoiler(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioBoiler/bioBoiler-list";
    }
    @OperationLog("生物质锅炉-列表")
    @GetMapping("/biomass/bioBoiler/list")
    @ResponseBody
    public PageResultBean<BiomassBoilerVo> bioBoilerList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         BiomassBoilerVo biomassBoilerVo) {
        if (biomassBoilerVo.getCityCode()==null&&biomassBoilerVo.getCountyId()==null){
            biomassBoilerVo.setCityCode(cityCode);
            biomassBoilerVo.setCountyId(countyCode);
        }
        List<BiomassBoilerVo> results= sourceService.getBioBoilersByExample(biomassBoilerVo,page, limit);
        PageInfo<BiomassBoilerVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("生物质锅炉-删除")
    @DeleteMapping("/biomass/bioBoiler/{id}")
    @ResponseBody
    public ResultBean bioBoilerDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBioBoilerById(id);
        return ResultBean.success();
    }
    @OperationLog("生物质锅炉-编辑")
    @GetMapping("/biomass/bioBoiler/{id}")
    public String bioBoilerEdit(@PathVariable("id") Integer id, Model model) {
        BiomassBoilerVo biomassBoilerVo=sourceService.getBioBoilerById(id);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(biomassBoilerVo.getCityCode()));
        model.addAttribute("citys", citys);
        model.addAttribute("biomassBoilerVo", biomassBoilerVo);
        return "source/biomass/bioBoiler/bioBoiler-update";
    }
    @OperationLog("生物质锅炉-新增")
    @GetMapping("/biomass/bioBoiler/add")
    public String bioBoilerAdd(Model model) {
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioBoiler/bioBoiler-add";
    }
    @OperationLog("生物质锅炉-编辑-保存")
    @PutMapping("/biomass/bioBoiler/edit")
    @ResponseBody
    public ResultBean bioBoilerInsertOrUpdate(boolean isCul,BiomassBoilerVo biomassBoilerVo)  {
        biomassBoilerVo.setSccCode("1801001000");
        SccVo sccVo=selectCommonService.selectBySccCode(biomassBoilerVo.getSccCode());
        biomassBoilerVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateBioBoiler(biomassBoilerVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("生物质燃烧源-森林火灾与草原火灾")
    @GetMapping("/biomass/bioForest")
    public String bioForest(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioForest/bioForest-list";
    }
    @OperationLog("森林火灾与草原火灾-列表")
    @GetMapping("/biomass/bioForest/list")
    @ResponseBody
    public PageResultBean<BiomassForestGrasslandVo> bioForestList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                  BiomassForestGrasslandVo biomassForestGrasslandVo) {
        if (biomassForestGrasslandVo.getCityCode()==null&&biomassForestGrasslandVo.getCountyId()==null){
            biomassForestGrasslandVo.setCityCode(cityCode);
            biomassForestGrasslandVo.setCountyId(countyCode);
        }
        List<BiomassForestGrasslandVo> results= sourceService.getBioForestsByExample(biomassForestGrasslandVo,page, limit);
        PageInfo<BiomassForestGrasslandVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("森林火灾与草原火灾-删除")
    @DeleteMapping("/biomass/bioForest/{id}")
    @ResponseBody
    public ResultBean bioForestDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBioForestById(id);
        return ResultBean.success();
    }
    @OperationLog("森林火灾与草原火灾-编辑")
    @GetMapping("/biomass/bioForest/{id}")
    public String bioForestEdit(@PathVariable("id") Integer id, Model model) {
        BiomassForestGrasslandVo biomassForestGrasslandVo=sourceService.getBioForestById(id);
        biomassForestGrasslandVo.setScc1(scc1);
        biomassForestGrasslandVo.setScc2("04");
        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(biomassForestGrasslandVo.getCityCode());
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"04");
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"04"+biomassForestGrasslandVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(biomassForestGrasslandVo.getCityCode()));
        model.addAttribute("citys", citys);
        model.addAttribute("biomassForestGrasslandVo", biomassForestGrasslandVo);
        return "source/biomass/bioForest/bioForest-update";
    }
    @OperationLog("森林火灾与草原火灾-新增")
    @GetMapping("/biomass/bioForest/add")
    public String bioForestAdd(Model model) {
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"04");
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "04");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioForest/bioForest-add";
    }
    @OperationLog("森林火灾与草原火灾-编辑-保存")
    @PutMapping("/biomass/bioForest/edit")
    @ResponseBody
    public ResultBean bioForestInsertOrUpdate(boolean isCul,BiomassForestGrasslandVo biomassForestGrasslandVo)  {
        biomassForestGrasslandVo.setSccCode("1804"+biomassForestGrasslandVo.getScc3()+biomassForestGrasslandVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(biomassForestGrasslandVo.getSccCode());
        biomassForestGrasslandVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateBioForest(biomassForestGrasslandVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("生物质燃烧源-生物质户用生物质炉具")
    @GetMapping("/biomass/bioStove")
    public String bioStove(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioStove/bioStove-list";
    }
    @OperationLog("生物质户用生物质炉具-列表")
    @GetMapping("/biomass/bioStove/list")
    @ResponseBody
    public PageResultBean<BiomassStoveVo> bioStoveList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       BiomassStoveVo biomassStoveVo) {
        if (biomassStoveVo.getCityCode()==null&&biomassStoveVo.getCountyId()==null){
            biomassStoveVo.setCityCode(cityCode);
            biomassStoveVo.setCountyId(countyCode);
        }
        List<BiomassStoveVo> results= sourceService.getBioStovesByExample(biomassStoveVo,page, limit);
        PageInfo<BiomassStoveVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("生物质户用生物质炉具-删除")
    @DeleteMapping("/biomass/bioStove/{id}")
    @ResponseBody
    public ResultBean bioStoveDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBioStoveById(id);
        return ResultBean.success();
    }
    @OperationLog("生物质户用生物质炉具-编辑")
    @GetMapping("/biomass/bioStove/{id}")
    public String bioStoveEdit(@PathVariable("id") Integer id, Model model) {
        BiomassStoveVo biomassStoveVo=sourceService.getBioStoveById(id);
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+biomassStoveVo.getScc2());
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+biomassStoveVo.getScc2()+biomassStoveVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(biomassStoveVo.getCityCode()));
        model.addAttribute("citys", citys);
        model.addAttribute("biomassStoveVo", biomassStoveVo);
        return "source/biomass/bioStove/bioStove-update";
    }
    @OperationLog("生物质户用生物质炉具-新增")
    @GetMapping("/biomass/bioStove/add")
    public String bioStoveAdd(Model model) {
        model.addAttribute("scc1", scc1);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioStove/bioStove-add";
    }
    @OperationLog("生物质户用生物质炉具-编辑-保存")
    @PutMapping("/biomass/bioStove/edit")
    @ResponseBody
    public ResultBean bioStoveInsertOrUpdate(boolean isCul,BiomassStoveVo biomassStoveVo)  {
        biomassStoveVo.setSccCode("18"+biomassStoveVo.getScc2()+biomassStoveVo.getScc3()+biomassStoveVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(biomassStoveVo.getSccCode());
        biomassStoveVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateBioStove(biomassStoveVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("生物质燃烧源-秸秆露天焚烧")
    @GetMapping("/biomass/bioStraw")
    public String bioStraw(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioStraw/bioStraw-list";
    }
    @OperationLog("秸秆露天焚烧-列表")
    @GetMapping("/biomass/bioStraw/list")
    @ResponseBody
    public PageResultBean<BiomassStrawVo> bioStrawList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       BiomassStrawVo biomassStrawVo) {
        if (biomassStrawVo.getCityCode()==null&&biomassStrawVo.getCountyId()==null){
            biomassStrawVo.setCityCode(cityCode);
            biomassStrawVo.setCountyId(countyCode);
        }
        List<BiomassStrawVo> results= sourceService.getBioStrawsByExample(biomassStrawVo,page, limit);
        PageInfo<BiomassStrawVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("秸秆露天焚烧-删除")
    @DeleteMapping("/biomass/bioStraw/{id}")
    @ResponseBody
    public ResultBean bioStrawDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBioStrawById(id);
        return ResultBean.success();
    }
    @OperationLog("秸秆露天焚烧-编辑")
    @GetMapping("/biomass/bioStraw/{id}")
    public String bioStrawEdit(@PathVariable("id") Integer id, Model model) {
        BiomassStrawVo biomassStrawVo=sourceService.getBioStrawById(id);
        biomassStrawVo.setScc1(scc1);
        biomassStrawVo.setScc2("04");
        biomassStrawVo.setScc3("001");
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"04"+"001");
        List<County> countys=selectCommonService.getCountysByCityCode(biomassStrawVo.getCityCode());
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(biomassStrawVo.getCityCode()));
        model.addAttribute("citys", citys);
        model.addAttribute("biomassStrawVo", biomassStrawVo);
        return "source/biomass/bioStraw/bioStraw-update";
    }
    @OperationLog("秸秆露天焚烧-新增")
    @GetMapping("/biomass/bioStraw/add")
    public String bioStrawAdd(Model model) {
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"04"+"001");
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "04");
        model.addAttribute("scc3", "001");
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioStraw/bioStraw-add";
    }
    @OperationLog("秸秆露天焚烧-编辑-保存")
    @PutMapping("/biomass/bioStraw/edit")
    @ResponseBody
    public ResultBean bioStrawInsertOrUpdate(boolean isCul,BiomassStrawVo biomassStrawVo)  {
        biomassStrawVo.setSccCode("1804"+biomassStrawVo.getScc3()+biomassStrawVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(biomassStrawVo.getSccCode());
        biomassStrawVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdateBioStraw(biomassStrawVo,isCul);
        return ResultBean.success();
    }
}
