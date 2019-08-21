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
//TODO: Test goes here...
    @OperationLog("企业审核界面-更新工厂信息")
    @PostMapping("/kiln/edit/{id}")
    @ResponseBody
    public ResultBean updatekiln(kiln kiln,String id) {
        //12个月的填报用量之和
        Double fuelAusageAll=kiln.getJanUseamount()+kiln.getFebUseamount()+kiln.getMarUseamount()+kiln.getAprUseamount()
                +kiln.getMayUseamount()+kiln.getJuneUseamount()+kiln.getJulyUseamount()+kiln.getAugUseamount()
                +kiln.getSeptUseamount()+kiln.getOctUseAmount()+kiln.getNovUseamount()+kiln.getDecUseamount();
        if (fuelAusageAll>kiln.getFuelAusage()){
            return ResultBean.error("12个月的燃料使用量之和大于燃料年使用量，请重新填写！");
        }else{
            String sccCode="10"+kiln.getFunctio()+kiln.getFueltype()+kiln.getModel();
            kiln.setScc(sccCode);
            Scc2 scc2=new Scc2();
            scc2.setScc1("10");
            scc2.setScc2(kiln.getFunctio());
            List<Scc2> scc2s=selectCommonService.getScc2sByScc2(scc2);
            kiln.setFunctionDec(scc2s.get(0).getDescription());

            Scc3 scc3=new Scc3();
            scc3.setScc1("10");
            scc3.setScc2(kiln.getFunctio());
            scc3.setScc3(kiln.getFueltype());
            List<Scc3> scc3s=selectCommonService.getScc3sByScc3(scc3);
            kiln.setFueltypeDec(scc3s.get(0).getDescription());

            Scc4 scc4=new Scc4();
            scc4.setScc1("10");
            scc4.setScc2(kiln.getFunctio());
            scc4.setScc3(kiln.getFueltype());
            scc4.setScc4(kiln.getModel());
            List<Scc4> scc4s=selectCommonService.getScc3sByScc4(scc4);
            kiln.setModelDec(scc4s.get(0).getDescription());

            Dustremove dustremove=removeCommonService.getDustremoveById(kiln.getDustremoveId());
            kiln.setDustremoveDec(dustremove.getDustRemoveName());
            Nitreremove nitreremove=removeCommonService.getNitrremoveById(kiln.getNitreremoveId());
            kiln.setNitreremoveDec(nitreremove.getNitreMethod());
            Sulphurremove sulphurremove=removeCommonService.getSulphurremoveById(kiln.getSulphurremoveId());
            kiln.setSulphurremoveDec(sulphurremove.getSulphurMethod());
            //通过scc重新计算
            Scc scc=sccService.getSccByScc(sccCode);
            kiln.setPm(kiln.getPm()*scc.getPm());
            kiln.setPm10(kiln.getPm10()*scc.getPm10());
            kiln.setPm25(kiln.getPm25()*scc.getPm25());
            kiln.setCo(kiln.getCo()*scc.getCo());
            kiln.setVoc(kiln.getVoc()*scc.getVocs());
            kiln.setSo2(kiln.getSo2()*scc.getSo2());
            kiln.setBc(kiln.getBc()*scc.getBc());
            kiln.setOc(kiln.getOc()*scc.getOc());
            //除尘、脱销等计算还待商榷，

            kilnService.updateTempById(kiln);
            return ResultBean.success();
        }

    }

} 
