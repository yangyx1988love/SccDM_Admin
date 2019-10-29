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
public class FactoryServiceImplTest extends {

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

    @OperationLog("堆场风蚀扬尘源-编辑")
    @GetMapping("/dust/dustStack/{id}")
    public String dustStackEdit(@PathVariable("id") Integer id, Model model) {
        String scc2="01";
        XjdustStackVo xjdustStackVo=sourceService.getdustStackById(id);
        Scc3 scc3=new Scc3();
        scc3.setScc1(scc1);
        scc3.setScc2(scc2);
        List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
        Scc4 scc4=new Scc4();
        scc4.setScc1(scc1);
        scc4.setScc2(scc2);
        scc4.setScc3(xjdustStackVo.getScc3());
        List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);

        model.addAttribute("citys", citys);
        model.addAttribute("countys", selectCommonService.getCountysByCityCode(xjdustStackVo.getCityCode()));
        model.addAttribute("scc3s", scc3s);
        model.addAttribute("scc4s", scc4s);
        model.addAttribute("xjdustStackVo", xjdustStackVo);
        return "source/dust/dustStack-update";
    }
    @OperationLog("堆场风蚀扬尘源-新增")
    @GetMapping("/dust/dustStack/add")
    public String dustStackAdd(Model model) {
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
        return "source/dust/dustStack-add";
    }
    @OperationLog("堆场风蚀扬尘源-编辑-保存")
    @PutMapping("/dust/dustStack/edit")
    @ResponseBody
    public ResultBean dustStackInsertOrUpdate(boolean isCul,XjdustStackVo xjdustStackVo)  {
        xjdustStackVo.setScccode(scc1+"01"+xjdustStackVo.getScc3()+xjdustStackVo.getScc4());
        SccVo sccVo=selectCommonService.selectBySccCode(xjdustStackVo.getScccode());
        xjdustStackVo.setSccDescribe(sccVo.getDescription());
        sourceService.insertOrUpdatedustStack(xjdustStackVo,isCul);
        return ResultBean.success();
    }

} 
