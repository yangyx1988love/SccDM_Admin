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

    sd_id = #{sdId,jdbcType=INTEGER},
    scccode = #{scccode,jdbcType=CHAR},
    county_id = #{countyId,jdbcType=CHAR},
    sd_year = #{sdYear,jdbcType=CHAR},
    sd_takemeasures = #{sdTakemeasures,jdbcType=VARCHAR},
    sd_utype = #{sdUtype,jdbcType=VARCHAR},
    sd_soiltype = #{sdSoiltype,jdbcType=VARCHAR},
    sd_area = #{sdArea,jdbcType=DOUBLE},
    soilindexpm25 = #{soilindexpm25,jdbcType=DOUBLE},
    soilindexpm10 = #{soilindexpm10,jdbcType=DOUBLE},
    surindex = #{surindex,jdbcType=DOUBLE},
    noindex = #{noindex,jdbcType=DOUBLE},
    pindex = #{pindex,jdbcType=DOUBLE},
    pm25_emission = #{pm25Emission,jdbcType=DOUBLE},
    pm10_emission = #{pm10Emission,jdbcType=DOUBLE},
    voc_emission = #{vocEmission,jdbcType=DOUBLE},
    nh3_emission = #{nh3Emission,jdbcType=DOUBLE},
    so2_emission = #{so2Emission,jdbcType=DOUBLE},
    co_emission = #{coEmission,jdbcType=DOUBLE},
    oc_emission = #{ocEmission,jdbcType=DOUBLE},
    bc_emission = #{bcEmission,jdbcType=DOUBLE},
    nox_emission = #{noxEmission,jdbcType=DOUBLE},
    scc_describe = #{sccDescribe,jdbcType=VARCHAR},
    flag = #{flag,jdbcType=INTEGER}
    
}
} 
