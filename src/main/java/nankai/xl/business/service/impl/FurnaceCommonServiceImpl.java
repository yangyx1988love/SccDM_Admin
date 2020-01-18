package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.BoilerMapper;
import nankai.xl.business.mapper.CityMapper;
import nankai.xl.business.mapper.CountyMapper;
import nankai.xl.business.mapper.KilnMapper;
import nankai.xl.business.model.Boiler;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.Kiln;
import nankai.xl.business.model.vo.BoilerSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.KilnSumVo;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.business.service.FurnaceCommonService;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FurnaceCommonServiceImpl implements FurnaceCommonService {
    @Resource
    private BoilerMapper boilerMapper;
    @Resource
    private KilnMapper kilnMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private CountyMapper countyMapper;

    @Override
    public Boiler getBoilerById(Integer id) {
        return boilerMapper.selectById(id);
    }

    @Override
    public List<Boiler> getBoilersByExhustId(Integer exhustId) {
        return boilerMapper.selectByExhustId(exhustId);
    }

    @Override
    public List<Boiler> getBoilersByFactoryId(Integer factoryId) {
        return boilerMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateBoilerById(Boiler boiler) {
        return boilerMapper.updateById(boiler);
    }

    @Override
    public List<BoilerSumVo> getSumBoilers(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return boilerMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<BoilerSumVo> getSumBoilers(Adminuser user, int page, int limit) {
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
        return getSumBoilers(factorySumCommonQuery,page, limit);
    }

    @Override
    public Kiln getKilnById(Integer id) {
        return kilnMapper.selectById(id);
    }

    @Override
    public List<Kiln> getKilnsByExhustId(Integer exhustId) {
        return kilnMapper.selectByExhustId(exhustId);
    }

    @Override
    public List<Kiln> getKilnsByFactoryId(Integer factoryId) {
        return kilnMapper.selectByFactoryId(factoryId);
    }

    @Override
    public List<KilnSumVo> getSumKilns(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return kilnMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<KilnSumVo> getSumKilns(Adminuser user, int page, int limit) {
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
        return getSumKilns(factorySumCommonQuery,page, limit);
    }

    @Override
    public int updateKilnById(Kiln kiln) {
        return kilnMapper.updateById(kiln);
    }

    @Override
    public List<SumVo> countBoilerByCity() {
        return boilerMapper.countByCity();
    }

    @Override
    public List<SumVo> countBoilerByCounty() {
        return boilerMapper.countByCounty();
    }

    @Override
    public List<SumVo> countKilnByCity() {
        return kilnMapper.countByCity();
    }

    @Override
    public List<SumVo> countKilnByCounty() {
        return kilnMapper.countByCounty();
    }
}
