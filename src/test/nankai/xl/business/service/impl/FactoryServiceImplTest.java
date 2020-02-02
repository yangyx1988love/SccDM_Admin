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

    @GetMapping("/FNoOrganization")
    public String FNoOrganizationSum(Model model) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            List<Status> Statuss=selectCommonService.getAllStatus();
            model.addAttribute("countys", selectCommonService.getCountysByUser(user));
            model.addAttribute("citys", selectCommonService.getCitysByUser(user));
            model.addAttribute("Statuss", Statuss);
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
        return "factoryAuth/sum/FNoOrganization-list";
    }
    @OperationLog("查看无组织车间列表")
    @GetMapping("/FNoOrganization/list")
    @ResponseBody
    public PageResultBean<FNoOrganizationSourceSumVo> FNoOrganizationList(@RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            PageInfo<FNoOrganizationSourceSumVo> pageInfo = new PageInfo<>(dustService.getSumFNoOrganizationSources(user,page,limit));
            return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
    }
    @OperationLog("无组织车间列表-重载")
    @GetMapping("/FNoOrganization/reload")
    @ResponseBody
    public PageResultBean<FNoOrganizationSourceSumVo> FNoOrganizationListByParam(@RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50")int limit,
    @Validated(Create.class) FactorySumCommonQuery factorySumCommonQuery) {

        List<FNoOrganizationSourceSumVo> results=dustService.getSumFNoOrganizationSources(factorySumCommonQuery,page, limit);
        PageInfo<FNoOrganizationSourceSumVo> pageInfo = new PageInfo<>(results);
        return new PageResultBean<>(pageInfo.getTotal(), pageInfo.getList());
    }
    
}
} 
