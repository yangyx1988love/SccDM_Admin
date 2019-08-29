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


    @OperationLog("汽修店-编辑")
    @GetMapping("/solvent/car/{id}")
    public String carEdit(@PathVariable("id") Integer id, Model model) {
        carCleanerVo carCleanerVo=sourceService.getcarById(id);
        List<City> citys=selectCommonService.getAllCitys();
        List<County> countys=selectCommonService.getCountysByCityCode(carCleanerVo.getCityCode());
        model.addAttribute("citys", citys);
        model.addAttribute("countys", countys);
        model.addAttribute("carCleanerVo", carCleanerVo);
        return "source/solvent/car/car-update";
    }
    @OperationLog("汽修店-新增")
    @GetMapping("/solvent/car/add")
    public String carAdd(Model model) {
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("citys", citys);
        model.addAttribute("scc1", scc1);
        return "source/solvent/car/car-add";
    }
    @OperationLog("汽修店-编辑-保存")
    @PutMapping("/solvent/car/edit")
    @ResponseBody
    public ResultBean carInsertOrUpdate(boolean isCul,carCleanerVo carCleanerVo)  {
        carCleanerVo.setScccode(scc1+"30000"+carCleanerVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(carCleanerVo.getScccode());
        carCleanerVo.setSourceDescrip(sccVo.getDescription());
        sourceService.insertOrUpdatecar(carCleanerVo,isCul);
        return ResultBean.success();
    }

} 
