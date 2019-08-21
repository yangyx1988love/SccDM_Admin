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
public class BiomassController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    @OperationLog("生物质燃烧源-生物质锅炉")
    @GetMapping("/biomass/bioBoiler")
    public String bioBoiler(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioBoiler-list";
    }
    @OperationLog("生物质燃烧源-生物质锅炉-列表")
    @GetMapping("/biomass/bioBoiler/list")
    @ResponseBody
    public PageResultBean<BiomassBoilerVo> bioBoilerList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit) {
        BiomassBoilerVo biomassBoilerVo=new BiomassBoilerVo();
        List<BiomassBoilerVo> results= sourceService.getBioBoilersByExample(biomassBoilerVo,page, limit);
        PageInfo<BiomassBoilerVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("生物质燃烧源-生物质锅炉-重载")
    @GetMapping("/biomass/bioBoiler/reload")
    @ResponseBody
    public PageResultBean<BiomassBoilerVo> bioBoilerReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                           BiomassBoilerVo biomassBoilerVo) {
        List<BiomassBoilerVo> results= sourceService.getBioBoilersByExample(biomassBoilerVo,page, limit);
        PageInfo<BiomassBoilerVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/biomass/bioBoiler/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("生物质燃烧源-生物质锅炉-删除")
    @DeleteMapping("/biomass/bioBoiler/{id}")
    @ResponseBody
    public ResultBean bioBoilerDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBioBoilerById(id);
        return ResultBean.success();
    }

    @OperationLog("生物质燃烧源-森林火灾与草原火灾")
    @GetMapping("/biomass/bioForest")
    public String bioForest(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioForest-list";
    }
    @OperationLog("生物质燃烧源-森林火灾与草原火灾-列表")
    @GetMapping("/biomass/bioForest/list")
    @ResponseBody
    public PageResultBean<BiomassForestGrasslandVo> bioForestList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit) {
        BiomassForestGrasslandVo biomassForestGrasslandVo=new BiomassForestGrasslandVo();
        List<BiomassForestGrasslandVo> results= sourceService.getBioForestsByExample(biomassForestGrasslandVo,page, limit);
        PageInfo<BiomassForestGrasslandVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("生物质燃烧源-森林火灾与草原火灾-重载")
    @GetMapping("/biomass/bioForest/reload")
    @ResponseBody
    public PageResultBean<BiomassForestGrasslandVo> bioForestReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                           @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                                    BiomassForestGrasslandVo biomassForestGrasslandVo) {
        List<BiomassForestGrasslandVo> results= sourceService.getBioForestsByExample(biomassForestGrasslandVo,page, limit);
        PageInfo<BiomassForestGrasslandVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/biomass/bioForest/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("生物质燃烧源-森林火灾与草原火灾-删除")
    @DeleteMapping("/biomass/bioForest/{id}")
    @ResponseBody
    public ResultBean bioForestDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBioForestById(id);
        return ResultBean.success();
    }

    @OperationLog("生物质燃烧源-生物质户用生物质炉具")
    @GetMapping("/biomass/bioStove")
    public String bioStove(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioStove-list";
    }
    @OperationLog("生物质燃烧源-生物质户用生物质炉具-列表")
    @GetMapping("/biomass/bioStove/list")
    @ResponseBody
    public PageResultBean<BiomassStoveVo> bioStoveList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit) {
        BiomassStoveVo biomassStoveVo=new BiomassStoveVo();
        List<BiomassStoveVo> results= sourceService.getStovesByExample(biomassStoveVo,page, limit);
        PageInfo<BiomassStoveVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("生物质燃烧源-生物质户用生物质炉具-重载")
    @GetMapping("/biomass/bioStove/reload")
    @ResponseBody
    public PageResultBean<BiomassStoveVo> bioStoveReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                          @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                          BiomassStoveVo biomassStoveVo) {
        List<BiomassStoveVo> results= sourceService.getStovesByExample(biomassStoveVo,page, limit);
        PageInfo<BiomassStoveVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/biomass/bioStove/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("生物质燃烧源-生物质户用生物质炉具-删除")
    @DeleteMapping("/biomass/bioStove/{id}")
    @ResponseBody
    public ResultBean bioStoveDelete(@PathVariable("id") Integer id) {
        sourceService.deleteStoveById(id);
        return ResultBean.success();
    }

    @OperationLog("生物质燃烧源-秸秆露天焚烧")
    @GetMapping("/biomass/bioStraw")
    public String bioStraw(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/biomass/bioStraw-list";
    }
    @OperationLog("生物质燃烧源-秸秆露天焚烧-列表")
    @GetMapping("/biomass/bioStraw/list")
    @ResponseBody
    public PageResultBean<BiomassStrawVo> bioStrawList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "limit", defaultValue = "50")int limit) {
        BiomassStrawVo biomassStrawVo=new BiomassStrawVo();
        List<BiomassStrawVo> results= sourceService.getBioStrawsByExample(biomassStrawVo,page, limit);
        PageInfo<BiomassStrawVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("生物质燃烧源-秸秆露天焚烧-重载")
    @GetMapping("/biomass/bioStraw/reload")
    @ResponseBody
    public PageResultBean<BiomassStrawVo> bioStrawReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                          @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         BiomassStrawVo biomassStrawVo) {
        List<BiomassStrawVo> results= sourceService.getBioStrawsByExample(biomassStrawVo,page, limit);
        PageInfo<BiomassStrawVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/biomass/bioStraw/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("生物质燃烧源-秸秆露天焚烧-删除")
    @DeleteMapping("/biomass/bioStraw/{id}")
    @ResponseBody
    public ResultBean bioStrawDelete(@PathVariable("id") Integer id) {
        sourceService.deleteBioStrawById(id);
        return ResultBean.success();
    }
}
