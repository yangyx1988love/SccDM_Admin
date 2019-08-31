package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.RoadMoveVo;
import nankai.xl.business.model.vo.SccVo;
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
public class RoadMoveController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;

    private String scc1="12";

    @OperationLog("道路移动源")
    @GetMapping("/road/roadMove")
    public String roadMove(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
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
    @OperationLog("道路移动源-删除")
    @DeleteMapping("/road/roadMove/{id}")
    @ResponseBody
    public ResultBean roadMoveDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRoadMoveById(id);
        return ResultBean.success();
    }
    @OperationLog("建筑涂装-编辑")
    @GetMapping("/road/roadMove/{id}")
    public String roadMoveEdit(@PathVariable("id") Integer id, Model model) {
        RoadMoveVo roadMoveVo=sourceService.getRoadMoveById(id);
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);

        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(roadMoveVo.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(roadMoveVo.getScc2());
        scc4.setScc3(roadMoveVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(roadMoveVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc2s", scc2s);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("roadMoveVo", roadMoveVo);
        return "source/road/roadMove-update";
    }
    @OperationLog("建筑涂装-新增")
    @GetMapping("/road/roadMove/add")
    public String roadMoveAdd(Model model) {
        Scc2 scc2=new Scc2();
        scc2.setScc1(scc1);
        List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2s", scc2s);
        return "source/road/roadMove-add";
    }
    @OperationLog("建筑涂装-编辑-保存")
    @PutMapping("/road/roadMove/edit")
    @ResponseBody
    public ResultBean roadMoveInsertOrUpdate(boolean isCul,RoadMoveVo roadMoveVo)  {
        roadMoveVo.setScccode(scc1+roadMoveVo.getScc2()+roadMoveVo.getScc3()+roadMoveVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(roadMoveVo.getScccode());
        roadMoveVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateRoadMove(roadMoveVo,isCul);
        return ResultBean.success();
    }
}
