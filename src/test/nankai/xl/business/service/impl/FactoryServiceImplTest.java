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

    @OperationLog("储罐存储-编辑")
    @GetMapping("/transport/tank/{id}")
    public String tankEdit(@PathVariable("id") Integer id, Model model) {
        tanksportVo tanksportVo=sourceService.gettankById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(tanksportVo.getScc2());
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);

        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2("23");
        scc4.setScc3(tanksportVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(tanksportVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("tanksportVo", tanksportVo);
        return "source/transport/tank/tank-update";
    }
    @OperationLog("储罐存储-新增")
    @GetMapping("/transport/tank/add")
    public String tankAdd(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/transport/tank/tank-add";
    }
    @OperationLog("储罐存储-编辑-保存")
    @PutMapping("/transport/tank/edit")
    @ResponseBody
    public ResultBean tankInsertOrUpdate(boolean isCul,tanksportVo tanksportVo)  {
        tanksportVo.setScccode(scc1+tanksportVo.getScc2()+tanksportVo.getScc3()+tanksportVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(tanksportVo.getScccode());
        tanksportVo.setSourceDiscrip(sccVo.getDescription());
        sourceService.insertOrUpdatetank(tanksportVo,isCul);
        return ResultBean.success();
    }

} 
