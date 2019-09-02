package test.nankai.xl.business.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* FactoryServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2019</pre> 
* @version 1.0 
*/ 
public class FactoryServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getFactoryListByQuery(FactoryQuery factoryQuery) 
* 
*/ 
@Test
public void testGetFactoryListByQuery() throws Exception {

    @OperationLog("秸秆露天焚烧-编辑")
    @GetMapping("/biomass/bioStraw/{id}")
    public String bioStrawEdit(@PathVariable("id") Integer id, Model model) {
        BiomassForestGrasslandVo biomassForestGrasslandVo=sourceService.getbioStrawById(id);
        biomassForestGrasslandVo.setScc1(scc1);
        biomassForestGrasslandVo.setScc2("04");
        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(biomassForestGrasslandVo.getCityCode());
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"04");
        List<Scc4> scc4s=selectCommonService.getScc4BySccCode123(scc1+"04"+biomassForestGrasslandVo.getScc3());
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("biomassForestGrasslandVo", biomassForestGrasslandVo);
        return "source/biomass/bioStraw/bioStraw-update";
    }
    @OperationLog("秸秆露天焚烧-新增")
    @GetMapping("/biomass/bioStraw/add")
    public String bioStrawAdd(Model model) {
        List<Scc3> scc3s=selectCommonService.getScc3BySccCode12(scc1+"04");
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", "04");
        return "source/biomass/bioStraw/bioStraw-add";
    }
    @OperationLog("秸秆露天焚烧-编辑-保存")
    @PutMapping("/biomass/bioStraw/edit")
    @ResponseBody
    public ResultBean bioStrawInsertOrUpdate(boolean isCul,BiomassForestGrasslandVo biomassForestGrasslandVo)  {
        biomassForestGrasslandVo.setSccCode("1804"+biomassForestGrasslandVo.getScc3()+biomassForestGrasslandVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(biomassForestGrasslandVo.getSccCode());
        biomassForestGrasslandVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdatebioStraw(biomassForestGrasslandVo,isCul);
        return ResultBean.success();
    }

} 
