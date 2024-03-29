package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.model.vo.FactoryVo;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.business.service.FactoryService;
import nankai.xl.common.exception.DuplicateNameException;
import nankai.xl.system.mapper.AdminuserMapper;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Dept;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {

    @Resource
    private FactoryMapper factoryMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private AdminuserMapper adminuserMapper;
    @Resource
    private RoleAuditMapper roleAuditMapper;
    @Resource
    private StatusMapper statusMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private CountyMapper countyMapper;

    @Override
    public List<FactoryVo> getFactoryListByQuery(FactoryQuery factoryQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return factoryMapper.selectByFactoryQuery(factoryQuery);
    }

    @Override
    public List<FactoryVo> getAllFactorys(int page, int limit) {
        PageHelper.startPage(page, limit);
        return factoryMapper.selectAllFactorys();
    }

    @Override
    public List<FactoryVo> getAllFactorys() {
        return factoryMapper.selectAllFactorys();
    }

    @Override
    public List<FactoryVo> getFactorysByuser(Adminuser user,int page, int limit) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactoryQuery factoryQuery=new FactoryQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factoryQuery.setCityCode(city.getCityCode());

        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factoryQuery.setCountyId(county.getCountyId());
        }
        return getFactoryListByQuery(factoryQuery,page, limit);
    }

    @Override
    public List<FactoryVo> getFactorysByuser(Adminuser user) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactoryQuery factoryQuery=new FactoryQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factoryQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factoryQuery.setCountyId(county.getCountyId());
        }
        return factoryMapper.selectByFactoryQuery(factoryQuery);
    }

    @Override
    public List<SumVo> countNonAuthByuser(Adminuser user) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactoryQuery factoryQuery=new FactoryQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factoryQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factoryQuery.setCountyId(county.getCountyId());
        }
        return factoryMapper.countNonAthu(factoryQuery);
    }

    @Override
    public List<SumVo> countIndustryBigByuser(Adminuser user) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactoryQuery factoryQuery=new FactoryQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factoryQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factoryQuery.setCountyId(county.getCountyId());
        }
        return factoryMapper.countByIndustryBig(factoryQuery);
    }

    @Override
    public List<SumVo> countByCity(Adminuser user) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactoryQuery factoryQuery=new FactoryQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factoryQuery.setCityCode(city.getCityCode());
        }
        return factoryMapper.countByCity(factoryQuery);
    }

    @Override
    public List<SumVo> countByCounty(Adminuser user) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactoryQuery factoryQuery=new FactoryQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factoryQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factoryQuery.setCountyId(county.getCountyId());
        }
        return factoryMapper.countByCounty(factoryQuery);
    }

    @Override
    public FactoryVo getBackById(Integer factoryId) {
        return factoryMapper.selectBackById(factoryId);
    }

    @Override
    public FactoryVo getNextById(Integer factoryId) {
        return factoryMapper.selectNextById(factoryId);
    }

    @Override
    public FactoryVo getFactoryById(Integer factoryId) {
        return factoryMapper.selectById(factoryId);
    }

    @Override
    public void updateUserPassword(String factoryNo1, String password) {
        User user=new User();
        user.setFacNo(factoryNo1);
        user.setPassword(password);
        factoryMapper.updatePassByFactoryNO(user);
    }

    @Override
    @Transactional
    public String addFactoryUser(Factory factory, User user) {
        checkFactoryNoExistOnCreate(factory.getFactoryNo());
        factoryMapper.insertSelective(factory);
        userMapper.insertSelective(user);
        return factory.getFactoryNo();
    }

    @Override
    public boolean updateByFactoryId(Factory factory) {
        factoryMapper.updateByFactoryId(factory);
        return true;
    }

    @Override
    public int delFactroy(Integer factoryId) {
        return factoryMapper.delFactory(factoryId);
    }

    @Override
    public User getUserByFactoryId(Integer factoryId) {
        return userMapper.selectByFactoryId(factoryId);
    }

    @Override
    public boolean auditFactory(Integer[] factoryIds) {
        Adminuser user = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        for (int i = 0; i <factoryIds.length ; i++) {
            Integer[] roleIds=adminuserMapper.selectRoleIdsByUserId(user.getUserId());
            Factory factory=new Factory();
            factory.setFactoryId(factoryIds[i]);
            Status status=statusMapper.selectById(roleAuditMapper.selectByRodeId(roleIds[0]).getStatusId());
            factory.setStatus(status.getId());
            factoryMapper.updateByFactoryId(factory);
        }
        return true;
    }

    /**
     * 新增时校验企业名称是否重复
     * @param factoryNo1  企业组织机构代码
     */
    public void checkFactoryNoExistOnCreate(String factoryNo1) {
        if (factoryMapper.countByFactoryNo(factoryNo1) > 0) {
            throw new DuplicateNameException();
        }
    }
}
