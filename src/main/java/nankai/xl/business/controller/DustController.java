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
public class DustController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    @OperationLog("扬尘源-土壤扬尘源")
    @GetMapping("/dust/soilDust")
    public String soilDust(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/soilDust-list";
    }
    @OperationLog("扬尘源-土壤扬尘源-列表")
    @GetMapping("/dust/soilDust/list")
    @ResponseBody
    public PageResultBean<XjsoildustVo> soilDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit) {
        XjsoildustVo xjsoildustVo=new XjsoildustVo();
        List<XjsoildustVo> results= sourceService.getSoilDustsByExample(xjsoildustVo,page, limit);
        PageInfo<XjsoildustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("扬尘源-土壤扬尘源-重载")
    @GetMapping("/dust/soilDust/reload")
    @ResponseBody
    public PageResultBean<XjsoildustVo> soilDustReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       XjsoildustVo xjsoildustVo) {
        List<XjsoildustVo> results= sourceService.getSoilDustsByExample(xjsoildustVo,page, limit);
        PageInfo<XjsoildustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/dust/soilDust/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("扬尘源-土壤扬尘源-删除")
    @DeleteMapping("/dust/soilDust/{id}")
    @ResponseBody
    public ResultBean soilDustDelete(@PathVariable("id") Integer id) {
        sourceService.deleteSoilDustById(id);
        return ResultBean.success();
    }

    @OperationLog("扬尘源-道路扬尘源")
    @GetMapping("/dust/roadDust")
    public String roadDust(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/roadDust-list";
    }
    @OperationLog("扬尘源-道路扬尘源-列表")
    @GetMapping("/dust/roadDust/list")
    @ResponseBody
    public PageResultBean<XjroaddustVo> roadDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit) {
        XjroaddustVo xjroaddustVo=new XjroaddustVo();
        List<XjroaddustVo> results= sourceService.getRoadDustsByExample(xjroaddustVo,page, limit);
        PageInfo<XjroaddustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("扬尘源-道路扬尘源-重载")
    @GetMapping("/dust/roadDust/reload")
    @ResponseBody
    public PageResultBean<XjroaddustVo> roadDustReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       XjroaddustVo xjroaddustVo) {
        List<XjroaddustVo> results= sourceService.getRoadDustsByExample(xjroaddustVo,page, limit);
        PageInfo<XjroaddustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/dust/roadDust/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("扬尘源-道路扬尘源-删除")
    @DeleteMapping("/dust/roadDust/{id}")
    @ResponseBody
    public ResultBean roadDustDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRoadDustById(id);
        return ResultBean.success();
    }

    @OperationLog("扬尘源-施工扬尘源")
    @GetMapping("/dust/conDust")
    public String conDust(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/conDust-list";
    }
    @OperationLog("扬尘源-施工扬尘源-列表")
    @GetMapping("/dust/conDust/list")
    @ResponseBody
    public PageResultBean<XjconstructdustVo> conDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit) {
        XjconstructdustVo xjconstructdustVo=new XjconstructdustVo();
        List<XjconstructdustVo> results= sourceService.getConsByExample(xjconstructdustVo,page, limit);
        PageInfo<XjconstructdustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("扬尘源-施工扬尘源-重载")
    @GetMapping("/dust/conDust/reload")
    @ResponseBody
    public PageResultBean<XjconstructdustVo> conDustReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                           XjconstructdustVo xjconstructdustVo) {
        List<XjconstructdustVo> results= sourceService.getConsByExample(xjconstructdustVo,page, limit);
        PageInfo<XjconstructdustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/dust/conDust/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("扬尘源-施工扬尘源-删除")
    @DeleteMapping("/dust/conDust/{id}")
    @ResponseBody
    public ResultBean conDustDelete(@PathVariable("id") Integer id) {
        sourceService.deleteConById(id);
        return ResultBean.success();
    }

    @OperationLog("扬尘源-堆场装卸扬尘源")
    @GetMapping("/dust/dustLoad")
    public String dustLoad(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/dustLoad-list";
    }
    @OperationLog("扬尘源-堆场装卸扬尘源-列表")
    @GetMapping("/dust/dustLoad/list")
    @ResponseBody
    public PageResultBean<XjcydustLoadVo> dustLoadList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit) {
        XjcydustLoadVo xjcydustLoadVo=new XjcydustLoadVo();
        List<XjcydustLoadVo> results= sourceService.getDustLoadsByExample(xjcydustLoadVo,page, limit);
        PageInfo<XjcydustLoadVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("扬尘源-堆场装卸扬尘源-重载")
    @GetMapping("/dust/dustLoad/reload")
    @ResponseBody
    public PageResultBean<XjcydustLoadVo> dustLoadReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         XjcydustLoadVo xjcydustLoadVo) {
        List<XjcydustLoadVo> results= sourceService.getDustLoadsByExample(xjcydustLoadVo,page, limit);
        PageInfo<XjcydustLoadVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/dust/dustLoad/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("扬尘源-堆场装卸扬尘源-删除")
    @DeleteMapping("/dust/dustLoad/{id}")
    @ResponseBody
    public ResultBean dustLoadDelete(@PathVariable("id") Integer id) {
        sourceService.deleteDustLoadById(id);
        return ResultBean.success();
    }

    @OperationLog("扬尘源-堆场风蚀扬尘源")
    @GetMapping("/dust/dustStack")
    public String dustStack(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/dustStack-list";
    }
    @OperationLog("扬尘源-堆场风蚀扬尘源-列表")
    @GetMapping("/dust/dustStack/list")
    @ResponseBody
    public PageResultBean<XjcydustStackVo> dustStackList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit) {
        XjcydustStackVo xjcydustStackVo=new XjcydustStackVo();
        List<XjcydustStackVo> results= sourceService.getDustStacksByExample(xjcydustStackVo,page, limit);
        PageInfo<XjcydustStackVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("扬尘源-堆场风蚀扬尘源-重载")
    @GetMapping("/dust/dustStack/reload")
    @ResponseBody
    public PageResultBean<XjcydustStackVo> dustStackReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                           XjcydustStackVo xjcydustStackVo) {
        List<XjcydustStackVo> results= sourceService.getDustStacksByExample(xjcydustStackVo,page, limit);
        PageInfo<XjcydustStackVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/dust/dustStack/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("扬尘源-堆场风蚀扬尘源-删除")
    @DeleteMapping("/dust/dustStack/{id}")
    @ResponseBody
    public ResultBean dustStackDelete(@PathVariable("id") Integer id) {
        sourceService.deleteDustStackById(id);
        return ResultBean.success();
    }
}
