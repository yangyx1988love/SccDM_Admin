package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.ScatteredCoalVo;
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
public class ScatCoalController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;
    @OperationLog("源管理界面-散煤")
    @GetMapping("/fixed/coal")
    public String process(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/fixed/list";
    }
    @OperationLog("散煤-列表")
    @GetMapping("/fixed/coal/list")
    @ResponseBody
    public PageResultBean<ScatteredCoalVo> getCoalList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit) {

        List<ScatteredCoalVo> results= sourceService.getAllScatteredCoals(page, limit);
        PageInfo<ScatteredCoalVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("散煤-重载")
    @GetMapping("/fixed/coal/reload")
    @ResponseBody
    public PageResultBean<ScatteredCoalVo> coalReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                      ScatteredCoal scatteredCoal) {

        List<ScatteredCoalVo> results= sourceService.getByScatteredCoals(scatteredCoal,page, limit);
        PageInfo<ScatteredCoalVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
//    @OperationLog("散煤-编辑")
//    @GetMapping("/fixed/coal/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("散煤-删除")
    @DeleteMapping("/fixed/coal/{id}")
    @ResponseBody
    public ResultBean delete(@PathVariable("id") Integer id) {
        sourceService.deleteScatById(id);
        return ResultBean.success();
    }
    @OperationLog("进入企业审核界面")
    @GetMapping("/fixed/coal/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
        return "factoryAuth/factory-Info";
    }
}
