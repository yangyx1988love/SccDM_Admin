package nankai.xl.business.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import nankai.xl.business.model.Factory;
import nankai.xl.business.model.vo.FactoryVo;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.business.service.FactoryService;
import nankai.xl.business.service.FurnaceCommonService;
import nankai.xl.business.service.SourceSumService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.system.model.Adminuser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/data")
public class DataAnalysisController {

    @Resource
    private FactoryService factoryService;
    @Resource
    private FurnaceCommonService furnaceCommonService;
    @Resource
    private SourceSumService sourceSumService;
    /*
        所有用户，根据自己的部门，展示所管辖的企业数据
     */
    @OperationLog("地图展示")
    @GetMapping("/map")
    public String showMap(Model model) {
        return "dataAnalysis/map/map";
    }
    @OperationLog("地图展示")
    @GetMapping("/map/factory/list")
    @ResponseBody
    public JSONObject factoryMap(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<FactoryVo> factoryResults=factoryService.getFactorysByuser(user);
            JSONArray valueData = new JSONArray();
            JSONArray geoCoordMap = new JSONArray();
            Map<String,Double[]> map=new HashMap<>();
            for (Factory factory:factoryResults) {
                if (factory.getFactoryLatitude()!=null&&factory.getFactoryLongitude()!=null&&factory.getFactoryName()!=null){
                    if (factory.getFactoryLatitude()>40&&factory.getFactoryLongitude()>80){
                        JSONObject jsonObject = new JSONObject();
                        Double totoalOutput=0.0;
                        if(factory.getTotalOutput()!=null){
                            totoalOutput+=factory.getTotalOutput();
                        }
                        jsonObject.put("value", totoalOutput);
                        jsonObject.put("name",factory.getFactoryName());
                        valueData.add(jsonObject);
                        Double[] lonlat=new Double[2];
                        lonlat[0]=factory.getFactoryLongitude();
                        lonlat[1]=factory.getFactoryLatitude();
                        map.put(factory.getFactoryName(),lonlat);
                    }
                }
            }
            for (Map.Entry<String,Double[]> mm:map.entrySet()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(mm.getKey(),mm.getValue());
                geoCoordMap.add(jsonObject);
            }
            JSONObject res = new JSONObject();
            res.put("valueData", valueData);
            res.put("geoCoordMap", map);
            return res;
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("加载饼图-统计scc1源数量")
    @GetMapping("/pie/factory/industryBig")
    @ResponseBody
    public JSONObject pieGrapFactory() {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<SumVo> results=factoryService.countIndustryBigByuser(user);
            JSONArray legendData = new JSONArray();
            JSONArray seriesData = new JSONArray();
            for (SumVo factorySumVo:results) {
                JSONObject jsonObject = new JSONObject();
                if (Integer.parseInt(factorySumVo.getValue())>0){
                    jsonObject.put("name",factorySumVo.getName());
                    jsonObject.put("value", factorySumVo.getValue());
                    legendData.add(factorySumVo.getName());
                    seriesData.add(jsonObject);
                }
            }
            JSONObject res = new JSONObject();
            res.put("legendData", legendData);
            res.put("seriesData", seriesData);
            return res;
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("加载柱状图-按行业大分类")
    @GetMapping("/barGrap/factory/industryBig")
    @ResponseBody
    public JSONObject barGrapFactory() {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<SumVo> results=factoryService.countIndustryBigByuser(user);
            List<String> xAxisData=new ArrayList<>();
            List<Integer> seriesData=new ArrayList<>();
            for (SumVo factorySumVo:results) {
                xAxisData.add(factorySumVo.getName());
                seriesData.add(Integer.parseInt(factorySumVo.getValue()));
            }
            JSONObject res = new JSONObject();
            res.put("xAxisData", xAxisData);
            res.put("seriesData", seriesData);
            return res;
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
/*
    管理员权限，各市、区县， 填报企业、源信息统计
 */
    @OperationLog("根据市展示")
    @GetMapping("/factory/index")
    public String factoryCity() {
        return "dataAnalysis/factory/data_factory";
    }
    @OperationLog("加载饼图-按行业大分类")
    @GetMapping("/factory/city/num/pie")
    @ResponseBody
    public JSONObject pieFactoryByCity() {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<SumVo> results=factoryService.countByCity(user);
            JSONArray legendData = new JSONArray();
            JSONArray seriesData = new JSONArray();
            for (SumVo factorySumVo:results) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name",factorySumVo.getName());
                jsonObject.put("value", factorySumVo.getValue());
                legendData.add(factorySumVo.getName());
                seriesData.add(jsonObject);
            }
            JSONObject res = new JSONObject();
            res.put("legendData", legendData);
            res.put("seriesData", seriesData);
            return res;
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("加载柱状图-按行业大分类")
    @GetMapping("/factory/county/num/bar")
    @ResponseBody
    public JSONObject barFactoryByCounty() {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<SumVo> results=factoryService.countByCounty(user);
            List<String> xAxisData=new ArrayList<>();
            List<Integer> seriesData=new ArrayList<>();
            for (SumVo factorySumVo:results) {
                xAxisData.add(factorySumVo.getName());
                seriesData.add(Integer.parseInt(factorySumVo.getValue()));
            }
            JSONObject res = new JSONObject();
            res.put("xAxisData", xAxisData);
            res.put("seriesData", seriesData);
            return res;
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("加载锅炉、窑炉数据")
    @GetMapping("/boilerAKiln/num/barPie")
    @ResponseBody
    public JSONObject pieBar(String upStr,String downStr) {
        List<SumVo> upSums=furnaceCommonService.countBoilerByCity();
        List<SumVo> downSums=furnaceCommonService.countKilnByCity();
        Map<String,Integer> upMap=new HashMap<>();
        Map<String,Integer> downMap=new HashMap<>();
        int upSum=0;
        int downSum=0;
        for (SumVo sumVo:upSums) {
            upMap.put(sumVo.getName(),Integer.parseInt(sumVo.getValue()));
            upSum+=Integer.parseInt(sumVo.getValue());
        }
        for (SumVo sumVo:downSums) {
            downMap.put(sumVo.getName(),Integer.parseInt(sumVo.getValue()));
            upSum+=Integer.parseInt(sumVo.getValue());
        }
        JSONObject barJson = new JSONObject();

        barJson.put("all",upSum+downSum);
        barJson.put("upBars",upMap);
        barJson.put("downBars",downMap);

        JSONObject res = new JSONObject();
        res.put("upPieJson",upMap);
        res.put("downPieJson",downMap);
        res.put("barJson",barJson);
        return res;
    }
    @OperationLog("加载柱状图-加载锅炉、窑炉信息")
    @GetMapping("/boilerAKiln/num/bar")
    @ResponseBody
    public JSONObject barGrapBAK() {
        List<SumVo> boilerList=furnaceCommonService.countBoilerByCounty();
        List<SumVo> klinList=furnaceCommonService.countKilnByCounty();
        List<String> xAxisData=new ArrayList<>();
        List<Integer> boilerData=new ArrayList<>();
        List<Integer> klinData=new ArrayList<>();
        for (int i = 0; i <boilerList.size() ; i++) {
            if (Integer.parseInt(boilerList.get(i).getValue())>0||Integer.parseInt(klinList.get(i).getValue())>0){
                xAxisData.add(boilerList.get(i).getName());
                boilerData.add(Integer.parseInt(boilerList.get(i).getValue()));
                klinData.add(Integer.parseInt(klinList.get(i).getValue()));
            }
        }
        JSONArray seriesData = new JSONArray();
        seriesData.add(boilerData);
        seriesData.add(klinData);
        JSONObject res = new JSONObject();
        res.put("xAxisData", xAxisData);
        res.put("seriesData", seriesData);
        return res;
    }
    @OperationLog("根据市展示")
    @GetMapping("/source/index")
    public String source() {
        return "dataAnalysis/source/data_source";
    }
    @OperationLog("根据市展示")
    @GetMapping("/source/fixed")
    @ResponseBody
    public JSONArray fixed() {
        List<SumVo> results=sourceSumService.sumScatByFuleTypeACity();
        Map<String,List<String>> map=new HashMap<>();
        List<String> product=new ArrayList<>();
        product.add("product");
        for (SumVo sumVo:results) {
            if (map.get(sumVo.getName())==null){
                List<String> list=new ArrayList<>();
                list.add(sumVo.getName());
                list.add(sumVo.getValue());
                map.put(sumVo.getName(),list);
            }else {
                List<String> list=map.get(sumVo.getName());
                list.add(sumVo.getValue());
                map.get(list);
            }
            if(!product.contains(sumVo.getTheme())){
                product.add(sumVo.getTheme());
            }
        }
        JSONArray res = new JSONArray();
        res.add(product);
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
