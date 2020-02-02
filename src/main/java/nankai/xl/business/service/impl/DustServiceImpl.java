package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;
import nankai.xl.business.service.DustService;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DustServiceImpl implements DustService {
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private CountyMapper countyMapper;
    @Resource
    private FNoOrganizationWorkshopDischargeMapper fNoOrganizationWorkshopDischargeMapper;
    @Resource
    private FBareSoilDustSourceMapper fBareSoilDustSourceMapper;
    @Resource
    private FConstructionDustSourceMapper fConstructionDustSourceMapper;
    @Resource
    private FRoadDustSourceMapper fRoadDustSourceMapper;
    @Resource
    private FYardDustSourceMapper fYardDustSourceMapper;

    @Override
    public List<Integer> getFBareIdsByFactoryId(Integer factoryId) {
        return fBareSoilDustSourceMapper.selectIdsByFactoryId(factoryId);
    }

    @Override
    public List<FBareSoilDustSource> getFBaresByFactoryId(Integer factoryId) {
        return fBareSoilDustSourceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FBareSoilDustSource getFBareById(Integer bareSoilid) {
        return fBareSoilDustSourceMapper.selectById(bareSoilid);
    }

    @Override
    public List<FBareSoilDustSourceSumVo> getSumFBareSoilDustSources(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return fBareSoilDustSourceMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<FBareSoilDustSourceSumVo> getSumFBareSoilDustSources(Adminuser user, int page, int limit) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactorySumCommonQuery factorySumCommonQuery=new FactorySumCommonQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factorySumCommonQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factorySumCommonQuery.setCountyId(county.getCountyId());
        }
        return getSumFBareSoilDustSources(factorySumCommonQuery,page, limit);
    }

    @Override
    public int updateFBareById(FBareSoilDustSource fBareSoilDustSource) {
        return fBareSoilDustSourceMapper.updateById(fBareSoilDustSource);
    }

    @Override
    public List<Integer> getFConIdsByFactoryId(Integer factoryId) {
        return fConstructionDustSourceMapper.selectIdsByFactoryId(factoryId);
    }

    @Override
    public List<FConstructionDustSource> getFConsByFactoryId(Integer factoryId) {
        return fConstructionDustSourceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FConstructionDustSource getFConById(Integer constructDustid) {
        return fConstructionDustSourceMapper.selectById(constructDustid);
    }

    @Override
    public List<FConstructionDustSourceSumVo> getSumFConstructionDustSources(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return fConstructionDustSourceMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<FConstructionDustSourceSumVo> getSumFConstructionDustSources(Adminuser user, int page, int limit) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactorySumCommonQuery factorySumCommonQuery=new FactorySumCommonQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factorySumCommonQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factorySumCommonQuery.setCountyId(county.getCountyId());
        }
        return getSumFConstructionDustSources(factorySumCommonQuery,page, limit);
    }

    @Override
    public int updateFConById(FConstructionDustSource fConstructionDustSource) {
        return fConstructionDustSourceMapper.updateById(fConstructionDustSource);
    }

    @Override
    public List<Integer> getFRoadIdsByFactoryId(Integer factoryId) {
        return fRoadDustSourceMapper.selectIdsByFactoryId(factoryId);
    }

    @Override
    public List<FRoadDustSource> getFRoadsByFactoryId(Integer factoryId) {
        return fRoadDustSourceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FRoadDustSource getFRoadById(Integer roadDustid) {
        return fRoadDustSourceMapper.selectById(roadDustid);
    }

    @Override
    public List<FRoadDustSourceSumVo> getSumFRoadDustSources(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return fRoadDustSourceMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<FRoadDustSourceSumVo> getSumFRoadDustSources(Adminuser user, int page, int limit) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactorySumCommonQuery factorySumCommonQuery=new FactorySumCommonQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factorySumCommonQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factorySumCommonQuery.setCountyId(county.getCountyId());
        }
        return getSumFRoadDustSources(factorySumCommonQuery,page, limit);
    }

    @Override
    public int updateFRoadById(FRoadDustSource fRoadDustSource) {
        return fRoadDustSourceMapper.updateById(fRoadDustSource);
    }

    @Override
    public List<Integer> getFYardIdsByFactoryId(Integer factoryId) {
        return fYardDustSourceMapper.selectIdsByFactoryId(factoryId);
    }

    @Override
    public List<FYardDustSource> getFYardsByFactoryId(Integer factoryId) {
        return fYardDustSourceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FYardDustSource getFYardById(Integer windDustid) {
        return fYardDustSourceMapper.selectById(windDustid);
    }

    @Override
    public List<FYardDustSourceSumVo> getSumFYardDustSources(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return fYardDustSourceMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<FYardDustSourceSumVo> getSumFYardDustSources(Adminuser user, int page, int limit) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactorySumCommonQuery factorySumCommonQuery=new FactorySumCommonQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factorySumCommonQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factorySumCommonQuery.setCountyId(county.getCountyId());
        }
        return getSumFYardDustSources(factorySumCommonQuery,page, limit);
    }

    @Override
    public int updateFYardById(FYardDustSource fYardDustSource) {
        return fYardDustSourceMapper.updateById(fYardDustSource);
    }

    @Override
    public List<FNoOrganizationWorkshopDischarge> getFnoOrgByFactoryId(Integer factoryId) {
        return fNoOrganizationWorkshopDischargeMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FNoOrganizationWorkshopDischarge getFnoOrgsById(Integer wsid) {
        return fNoOrganizationWorkshopDischargeMapper.selectById(wsid);
    }

    @Override
    public List<FNoOrganizationWorkshopDischargeSumVo> getSumFNoOrganizations(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return fNoOrganizationWorkshopDischargeMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<FNoOrganizationWorkshopDischargeSumVo> getSumFNoOrganizations(Adminuser user, int page, int limit) {
        Dept dept=deptMapper.selectByPrimaryKey(user.getDeptId());
        FactorySumCommonQuery factorySumCommonQuery=new FactorySumCommonQuery();
        if (dept.getDeptLevel()==2){
            City city=cityMapper.selectCityByCode(dept.getDeptId());
            factorySumCommonQuery.setCityCode(city.getCityCode());
        }
        if (dept.getDeptLevel()==3){
            County county=countyMapper.selectCountyById(dept.getDeptId());
            factorySumCommonQuery.setCountyId(county.getCountyId());
        }
        return getSumFNoOrganizations(factorySumCommonQuery,page, limit);
    }

    @Override
    public int updateFnoOrgById(FNoOrganizationWorkshopDischarge fNoOrganizationWorkshopDischarge) {
        return fNoOrganizationWorkshopDischargeMapper.updateById(fNoOrganizationWorkshopDischarge);
    }
}
