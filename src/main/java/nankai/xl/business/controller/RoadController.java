package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.vo.RoadMoveVo;
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
public class RoadController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    @OperationLog("道路移动源")
    @GetMapping("/road/roadMove")
    public String roadMove(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/road/roadMove-list";
    }
    @OperationLog("道路移动源-列表")
    @GetMapping("/road/roadMove/list")
    @ResponseBody
    public PageResultBean<RoadMoveVo> roadMoveList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit) {
        RoadMoveVo roadMoveVo=new RoadMoveVo();
        List<RoadMoveVo> results= sourceService.getRoadMovesByExample(roadMoveVo,page, limit);
        PageInfo<RoadMoveVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("道路移动源-重载")
    @GetMapping("/road/roadMove/reload")
    @ResponseBody
    public PageResultBean<RoadMoveVo> roadMoveReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     RoadMoveVo roadMoveVo) {
        List<RoadMoveVo> results= sourceService.getRoadMovesByExample(roadMoveVo,page, limit);
        PageInfo<RoadMoveVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/road/roadMove/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", sourceService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("道路移动源-删除")
    @DeleteMapping("/road/roadMove/{id}")
    @ResponseBody
    public ResultBean roadMoveDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRoadMoveById(id);
        return ResultBean.success();
    }
}
