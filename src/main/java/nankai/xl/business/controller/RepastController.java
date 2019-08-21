package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.RepastFamily;
import nankai.xl.business.model.vo.*;
import nankai.xl.business.service.RepastService;
import nankai.xl.business.service.SelectCommonService;
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
    private RepastService repastService;

    @OperationLog("其他源-社会餐饮")
    @GetMapping("/repast/repast")
    public String repast(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/repast/repast-list";
    }
    @OperationLog("其他源-社会餐饮-列表")
    @GetMapping("/repast/repast/list")
    @ResponseBody
    public PageResultBean<RepastVo> repastList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                  @RequestParam(value = "limit", defaultValue = "50")int limit) {
        RepastVo repastVo=new RepastVo();
        List<RepastVo> results= repastService.getByExample(repastVo,page, limit);
        PageInfo<RepastVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("其他源-社会餐饮-重载")
    @GetMapping("/repast/repast/reload")
    @ResponseBody
    public PageResultBean<RepastVo> repastReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                           @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                 RepastVo repastVo) {
        List<RepastVo> results= repastService.getByExample(repastVo,page, limit);
        PageInfo<RepastVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/repast/repast/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", repastService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("其他源-社会餐饮-删除")
    @DeleteMapping("/repast/repast/{id}")
    @ResponseBody
    public ResultBean repastDelete(@PathVariable("id") Integer id) {
        repastService.deleteById(id);
        return ResultBean.success();
    }

    @OperationLog("其他源-家庭餐饮")
    @GetMapping("/repast/family")
    public String family(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/repast/family-list";
    }
    @OperationLog("其他源-家庭餐饮-列表")
    @GetMapping("/repast/family/list")
    @ResponseBody
    public PageResultBean<RepastFamily> familyList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "50")int limit) {
        RepastFamily family=new RepastFamily();
        List<RepastFamily> results= repastService.getByExample(family,page, limit);
        PageInfo<RepastFamily> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("其他源-家庭餐饮-重载")
    @GetMapping("/repast/family/reload")
    @ResponseBody
    public PageResultBean<RepastFamily> familyReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     RepastFamily family) {
        List<RepastFamily> results= repastService.getByExample(family,page, limit);
        PageInfo<RepastFamily> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/repast/repast/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", repastService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("其他源-家庭餐饮-删除")
    @DeleteMapping("/repast/family/{id}")
    @ResponseBody
    public ResultBean familyDelete(@PathVariable("id") Integer id) {
        repastService.deleteFamilyById(id);
        return ResultBean.success();
    }

    @OperationLog("其他源-烧烤")
    @GetMapping("/repast/barbecue")
    public String barbecue(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/repast/barbecue-list";
    }
    @OperationLog("其他源-烧烤-列表")
    @GetMapping("/repast/barbecue/list")
    @ResponseBody
    public PageResultBean<RepastBarbecueVo> barbecueList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit) {
        RepastBarbecueVo repastBarbecueVo=new RepastBarbecueVo();
        List<RepastBarbecueVo> results= repastService.getByExample(repastBarbecueVo,page, limit);
        PageInfo<RepastBarbecueVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("其他源-烧烤-重载")
    @GetMapping("/repast/barbecue/reload")
    @ResponseBody
    public PageResultBean<RepastBarbecueVo> barbecueReload(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                           RepastBarbecueVo repastBarbecueVo) {
        List<RepastBarbecueVo> results= repastService.getByExample(repastBarbecueVo,page, limit);
        PageInfo<RepastBarbecueVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/repast/repast/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", repastService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("其他源-烧烤-删除")
    @DeleteMapping("/repast/barbecue/{id}")
    @ResponseBody
    public ResultBean barbecueDelete(@PathVariable("id") Integer id) {
        repastService.deleteBarbecueById(id);
        return ResultBean.success();
    }
}
