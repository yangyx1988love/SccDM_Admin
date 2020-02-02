package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.CityMapper;
import nankai.xl.business.mapper.CountyMapper;
import nankai.xl.business.mapper.RongjiProductMapper;
import nankai.xl.business.mapper.RongjiRawMapper;
import nankai.xl.business.model.City;
import nankai.xl.business.model.County;
import nankai.xl.business.model.RongjiProduct;
import nankai.xl.business.model.RongjiRaw;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.RongjiProductSumVo;
import nankai.xl.business.model.vo.RongjiRawSumVo;
import nankai.xl.business.service.SolventService;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SolventServiceImpl implements SolventService {
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private CountyMapper countyMapper;
    @Resource
    private RongjiRawMapper rongjiRawMapper;
    @Resource
    private RongjiProductMapper rongjiProductMapper;
    @Override
    public RongjiRaw getRawById(Integer id) {
        return rongjiRawMapper.selectById(id);
    }

    @Override
    public List<RongjiRaw> getRawsByFactoryId(Integer factoryId) {
        return rongjiRawMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateRawById(RongjiRaw rongjiRaw) {
        return rongjiRawMapper.updateById(rongjiRaw);
    }

    @Override
    public List<RongjiRawSumVo> getSumRongjiRaws(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return rongjiRawMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<RongjiRawSumVo> getSumRongjiRaws(Adminuser user, int page, int limit) {
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
        return getSumRongjiRaws(factorySumCommonQuery,page, limit);
    }

    @Override
    public RongjiProduct getProductById(Integer id) {
        return rongjiProductMapper.selectById(id);
    }

    @Override
    public List<RongjiProduct> getProductsByFactoryId(Integer factoryId) {
        return rongjiProductMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateProductById(RongjiProduct rongjiProduct) {
        return rongjiProductMapper.updateById(rongjiProduct);
    }

    @Override
    public List<RongjiProductSumVo> getSumRongjiProducts(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return rongjiProductMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<RongjiProductSumVo> getSumRongjiProducts(Adminuser user, int page, int limit) {
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
        return getSumRongjiProducts(factorySumCommonQuery,page, limit);
    }
}
