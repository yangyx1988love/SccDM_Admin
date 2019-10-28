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
public class RepastController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SourceService sourceService;
    
    private String scc1="20";

    private String scc2="01";
    
    @OperationLog("其他源-社会餐饮")
    @GetMapping("/repast/repast")
    public String repast() {
        return "source/repast/repast/repast-list";
    }
    @OperationLog("社会餐饮-列表")
    @GetMapping("/repast/repast/list")
    @ResponseBody
    public PageResultBean<RepastVo> repastList(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "50")int limit,
                                               RepastVo repastVo) {
        List<RepastVo> results= sourceService.getRepastsByExample(repastVo,page, limit);
        PageInfo<RepastVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("社会餐饮-删除")
    @DeleteMapping("/repast/repast/{id}")
    @ResponseBody
    public ResultBean repastDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRepastById(id);
        return ResultBean.success();
    }
    @OperationLog("社会餐饮-编辑")
    @GetMapping("/repast/repast/{id}")
    public String repastEdit(@PathVariable("id") Integer id, Model model) {
        RepastVo repastVo=sourceService.getRepastById(id);
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+scc2);
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+scc2+repastVo.getScc3());
        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(repastVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("repastVo", repastVo);
        return "source/repast/repast/repast-update";
    }
    @OperationLog("社会餐饮-新增")
    @GetMapping("/repast/repast/add")
    public String repastAdd(Model model) {
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        return "source/repast/repast/repast-add";
    }
    @OperationLog("社会餐饮-编辑-保存")
    @PutMapping("/repast/repast/edit")
    @ResponseBody
    public ResultBean repastInsertOrUpdate(boolean isCul,RepastVo repastVo)  {
        repastVo.setScccode(scc1+scc2+repastVo.getScc3()+repastVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(repastVo.getScccode());
        repastVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateRepast(repastVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("其他源-家庭餐饮")
    @GetMapping("/repast/family")
    public String family() {
        return "source/repast/family/family-list";
    }
    @OperationLog("家庭餐饮-列表")
    @GetMapping("/repast/family/list")
    @ResponseBody
    public PageResultBean<RepastFamilyVo> familyList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                   RepastFamilyVo repastFamilyVo) {
        List<RepastFamilyVo> results= sourceService.getRepastFamilysByExample(repastFamilyVo,page, limit);
        PageInfo<RepastFamilyVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("家庭餐饮-删除")
    @DeleteMapping("/repast/family/{id}")
    @ResponseBody
    public ResultBean familyDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRepastFamilyById(id);
        return ResultBean.success();
    }
    @OperationLog("家庭餐饮-编辑")
    @GetMapping("/repast/family/{id}")
    public String familyEdit(@PathVariable("id") Integer id, Model model) {
        RepastFamilyVo repastFamilyVo=sourceService.getRepastFamilyById(id);
        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(repastFamilyVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("repastFamilyVo", repastFamilyVo);
        return "source/repast/family/family-update";
    }
    @OperationLog("家庭餐饮-新增")
    @GetMapping("/repast/family/add")
    public String familyAdd() {
        return "source/repast/family/family-add";
    }
    @OperationLog("家庭餐饮-编辑-保存")
    @PutMapping("/repast/family/edit")
    @ResponseBody
    public ResultBean familyInsertOrUpdate(boolean isCul,RepastFamilyVo repastFamilyVo)  {
        repastFamilyVo.setScccode("2001000108");
        SccVo sccVo=selectCommonService.selectBySccCode(repastFamilyVo.getScccode());
        repastFamilyVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateRepastFamily(repastFamilyVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("其他源-烧烤")
    @GetMapping("/repast/barbecue")
    public String barbecue() {
        return "source/repast/barbecue/barbecue-list";
    }
    @OperationLog("烧烤-列表")
    @GetMapping("/repast/barbecue/list")
    @ResponseBody
    public PageResultBean<RepastBarbecueVo> barbecueList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         RepastBarbecueVo repastBarbecueVo) {
        List<RepastBarbecueVo> results= sourceService.getRepastsBarbecuesByExample(repastBarbecueVo,page, limit);
        PageInfo<RepastBarbecueVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("烧烤-删除")
    @DeleteMapping("/repast/barbecue/{id}")
    @ResponseBody
    public ResultBean barbecueDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRepastBarbecueById(id);
        return ResultBean.success();
    }
    @OperationLog("烧烤-编辑")
    @GetMapping("/repast/barbecue/{id}")
    public String barbecueEdit(@PathVariable("id") Integer id, Model model) {
        RepastBarbecueVo repastBarbecueVo=sourceService.getRepastBarbecueById(id);
        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(repastBarbecueVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("repastBarbecueVo", repastBarbecueVo);
        return "source/repast/barbecue/barbecue-update";
    }
    @OperationLog("烧烤-新增")
    @GetMapping("/repast/barbecue/add")
    public String barbecueAdd() {
        return "source/repast/barbecue/barbecue-add";
    }
    @OperationLog("烧烤-编辑-保存")
    @PutMapping("/repast/barbecue/edit")
    @ResponseBody
    public ResultBean barbecueInsertOrUpdate(boolean isCul,RepastBarbecueVo repastBarbecueVo)  {
        repastBarbecueVo.setScccode(scc1+scc2+"300000");
        SccVo sccVo=selectCommonService.selectBySccCode(repastBarbecueVo.getScccode());
        repastBarbecueVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdateRepastBarbecue(repastBarbecueVo,isCul);
        return ResultBean.success();
    }
}
