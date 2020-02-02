package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.CityMapper;
import nankai.xl.business.mapper.CountyMapper;
import nankai.xl.business.mapper.FeiqiMapper;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.Feiqi;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.FeiqiSumVo;
import nankai.xl.business.service.DisuseService;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DisuseServiceImpl implements DisuseService {
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private CountyMapper countyMapper;
    @Resource
    private FeiqiMapper feiqiMapper;
    @Override
    public Feiqi getFeiqiById(Integer id) {
        return feiqiMapper.selectById(id);
    }

    @Override
    public List<Feiqi> getFeiqisByFactoryId(Integer factoryId) {
        return feiqiMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateFeiqiById(Feiqi feiqi) {
        return feiqiMapper.updateById(feiqi);
    }

    @Override
    public List<FeiqiSumVo> getSumFeiqis(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return feiqiMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<FeiqiSumVo> getSumFeiqis(Adminuser user, int page, int limit) {
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
        return getSumFeiqis(factorySumCommonQuery,page, limit);
    }
}
