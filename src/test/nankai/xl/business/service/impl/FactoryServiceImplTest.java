package test.nankai.xl.business.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* FactoryServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2029</pre> 
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

    @OperationLog("小型通用机械-新增")
    @GetMapping("/nonRoad/smallMachinery/add")
    public String smallMachineryAdd(Model model) {
        String scc2="02";
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);

        model.addAttribute("scc1", scc1);
        model.addAttribute("scc2", scc2);
        model.addAttribute("scc3s", scc3s);
        return "source/nonRoad/smallMachinery/smallMachinery-add";
    }
    @OperationLog("小型通用机械-编辑")
    @GetMapping("/nonRoad/smallMachinery/{id}")
    public String smallMachineryEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="02";
        smallMachinerysmallMachineryVo smallMachinerysmallMachineryVo=nonRoadService.getsmallMachineryById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(smallMachinerysmallMachineryVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(smallMachinerysmallMachineryVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("smallMachinerysmallMachineryVo", smallMachinerysmallMachineryVo);
        return "source/nonRoad/smallMachinery/smallMachinery-update";
    }
    @OperationLog("小型通用机械-编辑-保存")
    @PutMapping("/nonRoad/smallMachinery/edit")
    @ResponseBody
    public ResultBean smallMachineryInsertOrUpdate(boolean isCul,smallMachinerysmallMachineryVo smallMachinerysmallMachineryVo) {
        smallMachinerysmallMachineryVo.setSccCode(scc1+"02"+smallMachinerysmallMachineryVo.getScc3()+smallMachinerysmallMachineryVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(smallMachinerysmallMachineryVo.getSccCode());
        smallMachinerysmallMachineryVo.setSourceDescrip(sccVo.getDescription());
        nonRoadService.insertOrUpdate(smallMachinerysmallMachineryVo,isCul);
        return ResultBean.success();
    }

} 
