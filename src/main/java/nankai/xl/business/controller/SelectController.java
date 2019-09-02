package nankai.xl.business.controller;

import nankai.xl.business.model.*;
import nankai.xl.business.service.*;
import nankai.xl.common.annotation.OperationLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/factoryAuth")
public class SelectController {
    @Resource
    private SelectCommonService selectCommonService;

    @OperationLog("企业审核界面-重加载行业小分类")
    @PostMapping("/seleIndustry/{industryCode}")
    @ResponseBody
    public List<Industry> seleIndustry(@PathVariable("industryCode") String industryCode) {
        List<Industry> industrys=selectCommonService.getIndustrysByCode(industryCode);
        return industrys;
    }
    @OperationLog("企业审核界面-加载城市信息")
    @PostMapping("/seleCity")
    @ResponseBody
    public List<City> seleCity(String provinceCode) {
        List<City> citys=selectCommonService.getCitysByProvinceCode(provinceCode);
        return citys;
    }
    @OperationLog("企业审核界面-重加载区县信息")
    @PostMapping("/seleCountry/{cityCode}")
    @ResponseBody
    public List<County> seleCountry(@PathVariable("cityCode") String cityCode) {
        List<County> countys=selectCommonService.getCountysByCityCode(cityCode);
        return countys;
    }
    @OperationLog("企业审核界面-scc2下拉框")
    @PostMapping("/seleScc2/{scc2}")
    @ResponseBody
    public List<Scc3> seleScc3(String scc1,String scc2, Model model) {
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        return scc3s;
    }
    @OperationLog("企业审核界面-scc3下拉框")
    @PostMapping("/seleScc3/{scc2}/{scc3}")
    @ResponseBody
    public List<Scc4> seleScc4(String scc1,String scc2,String scc3) {
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        //String scc2= (String) session.getAttribute("scc2");
        scc4.setScc2(scc2);
        scc4.setScc3(scc3);
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);
        return scc4s;
    }
    @OperationLog("企业审核界面-重加载区县信息")
    @PostMapping("/seleCompany")
    @ResponseBody
    public Company seleCompany( String companyName) {
        Company company=selectCommonService.getCompanysByVagueName(companyName);
        return company;
    }
}
