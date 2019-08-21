package test.nankai.xl.system.service; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* DeptService Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2019</pre> 
* @version 1.0 
*/ 
public class DeptServiceTest { 

@Before
public void before() throws Exception {
    @OperationLog("其他源-烧烤")
    @GetMapping("/repast/barbecue")
    public String barbecue(Model model) {
        List<County> countys=selectCommonService.getAllCountys();
        List<City> citys=selectCommonService.getAllCitys();
        model.addAttribute("countys", countys);
        model.addAttribute("citys", citys);
        return "source/repast/barbecue-list";
    }
    @OperationLog("其他源-烧烤-列表")
    @GetMapping("/repast/barbecue/list")
    @ResponseBody
    public PageResultBean<Repastbarbecue> barbecueList(@RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50")int limit) {
        Repastbarbecue barbecue=new Repastbarbecue();
        List<Repastbarbecue> results= repastService.getByExample(barbecue,page, limit);
        PageInfo<Repastbarbecue> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("其他源-烧烤-重载")
    @GetMapping("/repast/barbecue/reload")
    @ResponseBody
    public PageResultBean<Repastbarbecue> barbecueReload(@RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50")int limit,
    Repastbarbecue barbecue) {
        List<Repastbarbecue> results= repastService.getByExample(barbecue,page, limit);
        PageInfo<Repastbarbecue> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    //    @OperationLog("散煤-编辑")
//    @GetMapping("/repast/repast/{id}")
//    public String update(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("scatteredCoal", repastService.getScatById(id));
//        return "source/fixed/list";
//    }
    @OperationLog("其他源-烧烤-删除")
    @DeleteMapping("/repast/barbecue/{id}")
    @ResponseBody
    public ResultBean barbecueDelete(@PathVariable("id") Integer id) {
        repastService.deletebarbecueById(id);
        return ResultBean.success();
    }
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: deleteByPrimaryKey(Integer deptId) 
* 
*/ 
@Test
public void testDeleteByPrimaryKey() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insert(Dept dept) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insertSelective(Dept dept) 
* 
*/ 
@Test
public void testInsertSelective() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectByPrimaryKey(Integer deptId) 
* 
*/ 
@Test
public void testSelectByPrimaryKey() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateByPrimaryKeySelective(Dept dept) 
* 
*/ 
@Test
public void testUpdateByPrimaryKeySelective() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateByPrimaryKey(Dept dept) 
* 
*/ 
@Test
public void testUpdateByPrimaryKey() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteByIDAndChildren(Integer deptId) 
* 
*/ 
@Test
public void testDeleteByIDAndChildren() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectByParentId(Integer parentId) 
* 
*/ 
@Test
public void testSelectByParentId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectAllDept() 
* 
*/ 
@Test
public void testSelectAllDept() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectAllDeptTree() 
* 
*/ 
@Test
public void testSelectAllDeptTree() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectAllDeptTreeAndRoot() 
* 
*/ 
@Test
public void testSelectAllDeptTreeAndRoot() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: swapSort(Integer currentId, Integer swapId) 
* 
*/ 
@Test
public void testSwapSort() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: toTree(List<Dept> depts) 
* 
*/ 
@Test
public void testToTree() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DeptService.getClass().getMethod("toTree", List<Dept>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
