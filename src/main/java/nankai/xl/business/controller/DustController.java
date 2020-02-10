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
public class DustController {
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

    private String scc1="16";
    @OperationLog("扬尘源-土壤扬尘源")
    @GetMapping("/dust/soilDust")
    public String soilDust(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/soilDust/soilDust-list";
    }
    @OperationLog("土壤扬尘源-列表")
    @GetMapping("/dust/soilDust/list")
    @ResponseBody
    public PageResultBean<YcSoildustVo> soilDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     YcSoildustVo xjsoildustVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (xjsoildustVo.getCityCode()==null&&xjsoildustVo.getCountyId()==null){
            xjsoildustVo.setCityCode(cityCode);
            xjsoildustVo.setCountyId(countyCode);
        }
        List<YcSoildustVo> results= sourceService.getSoilDustsByExample(xjsoildustVo,page, limit);
        PageInfo<YcSoildustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("土壤扬尘源-删除")
    @DeleteMapping("/dust/soilDust/{id}")
    @ResponseBody
    public ResultBean soilDustDelete(@PathVariable("id") Integer id) {
        sourceService.deleteSoilDustById(id);
        return ResultBean.success();
    }
    @OperationLog("土壤扬尘源-编辑")
    @GetMapping("/dust/soilDust/{id}")
    public String soilDustEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="01";
        YcSoildustVo xjsoildustVo=sourceService.getSoilDustById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(xjsoildustVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(xjsoildustVo.getCityCode()));
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("xjsoildustVo", xjsoildustVo);
        return "source/dust/soilDust/soilDust-update";
    }
    @OperationLog("土壤扬尘源-新增")
    @GetMapping("/dust/soilDust/add")
    public String soilDustAdd(Model model) {
        String scc2="01";
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        return "source/dust/soilDust/soilDust-add";
    }
    @OperationLog("土壤扬尘源-编辑-保存")
    @PutMapping("/dust/soilDust/edit")
    @ResponseBody
    public ResultBean soilDustInsertOrUpdate(boolean isCul, YcSoildustVo xjsoildustVo)  {
        xjsoildustVo.setScccode(scc1+"01"+xjsoildustVo.getScc3()+xjsoildustVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(xjsoildustVo.getScccode());
        xjsoildustVo.setSccDescribe(sccVo.getDescription());
        sourceService.insertOrUpdateSoilDust(xjsoildustVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("扬尘源-道路扬尘源")
    @GetMapping("/dust/roadDust")
    public String roadDust(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/roadDust/roadDust-list";
    }
    @OperationLog("道路扬尘源-列表")
    @GetMapping("/dust/roadDust/list")
    @ResponseBody
    public PageResultBean<YcRoaddustVo> roadDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     YcRoaddustVo xjroaddustVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (xjroaddustVo.getCityCode()==null&&xjroaddustVo.getCountyId()==null){
            xjroaddustVo.setCityCode(cityCode);
            xjroaddustVo.setCountyId(countyCode);
        }
        List<YcRoaddustVo> results= sourceService.getRoadDustsByExample(xjroaddustVo,page, limit);
        PageInfo<YcRoaddustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }

    @OperationLog("道路扬尘源-删除")
    @DeleteMapping("/dust/roadDust/{id}")
    @ResponseBody
    public ResultBean roadDustDelete(@PathVariable("id") Integer id) {
        sourceService.deleteRoadDustById(id);
        return ResultBean.success();
    }
    @OperationLog("道路扬尘源-编辑")
    @GetMapping("/dust/roadDust/{id}")
    public String roadDustEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="02";
        YcRoaddustVo xjroaddustVo=sourceService.getRoadDustById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(xjroaddustVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(xjroaddustVo.getCityCode()));
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("xjroaddustVo", xjroaddustVo);
        return "source/dust/roadDust/roadDust-update";
    }
    @OperationLog("道路扬尘源-新增")
    @GetMapping("/dust/roadDust/add")
    public String roadDustAdd(Model model) {
        String scc2="02";
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        return "source/dust/roadDust/roadDust-add";
    }
    @OperationLog("道路扬尘源-编辑-保存")
    @PutMapping("/dust/roadDust/edit")
    @ResponseBody
    public ResultBean roadDustInsertOrUpdate(boolean isCul, YcRoaddustVo xjroaddustVo)  {
        xjroaddustVo.setScccode(scc1+"02"+xjroaddustVo.getScc3()+xjroaddustVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(xjroaddustVo.getScccode());
        xjroaddustVo.setSccDescribe(sccVo.getDescription());
        sourceService.insertOrUpdateRoadDust(xjroaddustVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("扬尘源-施工扬尘源")
    @GetMapping("/dust/conDust")
    public String conDust(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/conDust/conDust-list";
    }
    @OperationLog("施工扬尘源-列表")
    @GetMapping("/dust/conDust/list")
    @ResponseBody
    public PageResultBean<ycConstructdustVo> conDustList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                         ycConstructdustVo xjconstructdustVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (xjconstructdustVo.getCityCode()==null&&xjconstructdustVo.getCountyId()==null){
            xjconstructdustVo.setCityCode(cityCode);
            xjconstructdustVo.setCountyId(countyCode);
        }
        List<ycConstructdustVo> results= sourceService.getConsByExample(xjconstructdustVo,page, limit);
        PageInfo<ycConstructdustVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("施工扬尘源-删除")
    @DeleteMapping("/dust/conDust/{id}")
    @ResponseBody
    public ResultBean conDustDelete(@PathVariable("id") Integer id) {
        sourceService.deleteConById(id);
        return ResultBean.success();
    }
    @OperationLog("施工扬尘源-编辑")
    @GetMapping("/dust/conDust/{id}")
    public String conDustEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="03";
        ycConstructdustVo xjconstructdustVo=sourceService.getConById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(xjconstructdustVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(xjconstructdustVo.getCityCode()));
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("xjconstructdustVo", xjconstructdustVo);
        return "source/dust/conDust/conDust-update";
    }
    @OperationLog("施工扬尘源-新增")
    @GetMapping("/dust/conDust/add")
    public String conDustAdd(Model model) {
        String scc2="03";
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        return "source/dust/conDust/conDust-add";
    }
    @OperationLog("施工扬尘源-编辑-保存")
    @PutMapping("/dust/conDust/edit")
    @ResponseBody
    public ResultBean conDustInsertOrUpdate(boolean isCul, ycConstructdustVo xjconstructdustVo)  {
        xjconstructdustVo.setScccode(scc1+"03"+xjconstructdustVo.getScc3()+xjconstructdustVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(xjconstructdustVo.getScccode());
        xjconstructdustVo.setSccDescribe(sccVo.getDescription());
        sourceService.insertOrUpdateCon(xjconstructdustVo,isCul);
        return ResultBean.success();
    }

    @OperationLog("扬尘源-堆场装卸扬尘源")
    @GetMapping("/dust/dustLoad")
    public String dustLoad(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/dustLoad/dustLoad-list";
    }
    @OperationLog("堆场装卸扬尘源-列表")
    @GetMapping("/dust/dustLoad/list")
    @ResponseBody
    public PageResultBean<YcDustLoadVo> dustLoadList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                     YcDustLoadVo xjcydustLoadVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (xjcydustLoadVo.getCityCode()==null&&xjcydustLoadVo.getCountyId()==null){
            xjcydustLoadVo.setCityCode(cityCode);
            xjcydustLoadVo.setCountyId(countyCode);
        }
        List<YcDustLoadVo> results= sourceService.getDustLoadsByExample(xjcydustLoadVo,page, limit);
        PageInfo<YcDustLoadVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("堆场装卸扬尘源-删除")
    @DeleteMapping("/dust/dustLoad/{id}")
    @ResponseBody
    public ResultBean dustLoadDelete(@PathVariable("id") Integer id) {
        sourceService.deleteDustLoadById(id);
        return ResultBean.success();
    }
    @OperationLog("堆场装卸扬尘源-编辑")
    @GetMapping("/dust/dustLoad/{id}")
    public String dustLoadEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="04";
        String scc3="001";
        YcDustLoadVo xjcydustLoadVo=sourceService.getDustLoadById(id);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(xjcydustLoadVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(xjcydustLoadVo.getCityCode()));
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3", scc3);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("xjcydustLoadVo", xjcydustLoadVo);
        return "source/dust/dustLoad/dustLoad-update";
    }
    @OperationLog("堆场装卸扬尘源-新增")
    @GetMapping("/dust/dustLoad/add")
    public String dustLoadAdd(Model model) {
        String scc2="04";
        String scc3="001";
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3", scc3);
        return "source/dust/dustLoad/dustLoad-add";
    }
    @OperationLog("堆场装卸扬尘源-编辑-保存")
    @PutMapping("/dust/dustLoad/edit")
    @ResponseBody
    public ResultBean dustLoadInsertOrUpdate(boolean isCul, YcDustLoadVo xjcydustLoadVo)  {
        xjcydustLoadVo.setScccode(scc1+"04"+xjcydustLoadVo.getScc3()+xjcydustLoadVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(xjcydustLoadVo.getScccode());
        xjcydustLoadVo.setSccDescribe(sccVo.getDescription());
        sourceService.insertOrUpdateDustLoad(xjcydustLoadVo,isCul);
        return ResultBean.success();
    }
    @OperationLog("扬尘源-堆场风蚀扬尘源")
    @GetMapping("/dust/dustStack")
    public String dustStack(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        countys=selectCommonService.getCountysByUser(user);
        citys=selectCommonService.getCitysByUser(user);
        Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
        cityCode=map.get("cityCode");
        countyCode=map.get("countyCode");
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/dust/dustStack/dustStack-list";
    }
    @OperationLog("堆场风蚀扬尘源-列表")
    @GetMapping("/dust/dustStack/list")
    @ResponseBody
    public PageResultBean<YcDustStackVo> dustStackList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "50")int limit,
                                                       YcDustStackVo xjcydustStackVo) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (xjcydustStackVo.getCityCode()==null&&xjcydustStackVo.getCountyId()==null){
            xjcydustStackVo.setCityCode(cityCode);
            xjcydustStackVo.setCountyId(countyCode);
        }
        List<YcDustStackVo> results= sourceService.getDustStacksByExample(xjcydustStackVo,page, limit);
        PageInfo<YcDustStackVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("堆场风蚀扬尘源-删除")
    @DeleteMapping("/dust/dustStack/{id}")
    @ResponseBody
    public ResultBean dustStackDelete(@PathVariable("id") Integer id) {
        sourceService.deleteDustStackById(id);
        return ResultBean.success();
    }
    @OperationLog("堆场风蚀扬尘源-编辑")
    @GetMapping("/dust/dustStack/{id}")
    public String dustStackEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="04";
        String scc3="002";
        YcDustStackVo xjcydustStackVo=sourceService.getDustStackById(id);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(xjcydustStackVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(xjcydustStackVo.getCityCode()));
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3", scc3);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("xjcydustStackVo", xjcydustStackVo);
        return "source/dust/dustStack/dustStack-update";
    }
    @OperationLog("堆场风蚀扬尘源-新增")
    @GetMapping("/dust/dustStack/add")
    public String dustStackAdd(Model model) {
        String scc2="04";
        String scc3="002";
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3", scc3);
        return "source/dust/dustStack/dustStack-add";
    }
    @OperationLog("堆场风蚀扬尘源-编辑-保存")
    @PutMapping("/dust/dustStack/edit")
    @ResponseBody
    public ResultBean dustStackInsertOrUpdate(boolean isCul, YcDustStackVo xjcydustStackVo)  {
        xjcydustStackVo.setScccode(scc1+"04"+xjcydustStackVo.getScc3()+xjcydustStackVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(xjcydustStackVo.getScccode());
        xjcydustStackVo.setSccDescribe(sccVo.getDescription());
        sourceService.insertOrUpdateDustStack(xjcydustStackVo,isCul);
        return ResultBean.success();
    }
}
