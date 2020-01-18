package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.CityMapper;
import nankai.xl.business.mapper.CountyMapper;
import nankai.xl.business.mapper.ExhaustMapper;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.Exhaust;
import nankai.xl.business.model.vo.ExhaustSumVo;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.service.ExhaustService;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExhaustServiceImpl implements ExhaustService {
    @Resource
    private ExhaustMapper exhaustMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private CountyMapper countyMapper;
    @Override
    public List<Exhaust> getByFactoryId(Integer factoryId) {
        return exhaustMapper.selectByFactoryId(factoryId);
    }

    @Override
    public Exhaust getByExfId(Integer exfId) {
        return exhaustMapper.selectByExfId(exfId);
    }

    @Override
    public int updateExhaustByExfId(Exhaust exhaust) {
        return exhaustMapper.updateByExfId(exhaust);
    }

    @Override
    public List<ExhaustSumVo> getSumExhausts(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return exhaustMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<ExhaustSumVo> getSumExhausts(Adminuser user, int page, int limit) {
        PageHelper.startPage(page, limit);
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
        return getSumExhausts(factorySumCommonQuery,page,limit);
    }
}
