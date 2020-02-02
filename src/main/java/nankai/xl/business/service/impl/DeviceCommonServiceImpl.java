package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.DeviceProductSumVo;
import nankai.xl.business.model.vo.DeviceRawSumVo;
import nankai.xl.business.model.vo.DeviceSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.service.DeviceCommonService;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DeviceCommonServiceImpl implements DeviceCommonService {
    @Resource
    private DeviceMapper deviceMapper;
    @Resource
    private DeviceRawMapper deviceRawMapper;
    @Resource
    private DeviceProductMapper deviceProductMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private CountyMapper countyMapper;
    @Override
    public Device getDeviceById(Integer id) {
        return deviceMapper.selectById(id);
    }

    @Override
    public List<Device> getDevicesByFactoryId(Integer factoryId) {
        return deviceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateDeviceById(Device device) {
        return deviceMapper.updateById(device);
    }

    @Override
    public List<DeviceSumVo> getSumDevices(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return deviceMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<DeviceSumVo> getSumDevices(Adminuser user, int page, int limit) {
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
        return getSumDevices(factorySumCommonQuery,page,limit);
    }

    @Override
    public DeviceRaw getDeviceRawById(Integer id) {
        return deviceRawMapper.selectById(id);
    }

    @Override
    public List<DeviceRaw> getDeviceRawsDeviceId(Integer deviceId) {
        return deviceRawMapper.selectByDeviceId(deviceId);
    }

    @Override
    public List<DeviceRaw> getDeviceRawsByFactoryId(Integer factoryId) {
        return deviceRawMapper.selectByFactoryId(factoryId);
    }

    @Override
    public List<DeviceRawSumVo> getSumDeviceRaws(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return deviceRawMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<DeviceRawSumVo> getSumDeviceRaws(Adminuser user, int page, int limit) {
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
        return getSumDeviceRaws(factorySumCommonQuery,page,limit);
    }

    @Override
    public int updateDeviceRawById(DeviceRaw deviceRaw) {
        return deviceRawMapper.updateById(deviceRaw);
    }

    @Override
    public DeviceProduct getDeviceProductById(Integer id) {
        return deviceProductMapper.selectById(id);
    }

    @Override
    public List<DeviceProduct> getDeviceProductsDeviceId(Integer deviceId) {
        return deviceProductMapper.selectByDeviceId(deviceId);
    }

    @Override
    public List<DeviceProduct> getDeviceProductsByFactoryId(Integer factoryId) {
        return deviceProductMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateDeviceProductById(DeviceProduct deviceProduct) {
        return deviceProductMapper.updateById(deviceProduct);
    }

    @Override
    public List<DeviceProductSumVo> getSumDeviceProducts(FactorySumCommonQuery factorySumCommonQuery, int page, int limit) {
        PageHelper.startPage(page, limit);
        return deviceProductMapper.selectSum(factorySumCommonQuery);
    }

    @Override
    public List<DeviceProductSumVo> getSumDeviceProducts(Adminuser user, int page, int limit) {
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
        return getSumDeviceProducts(factorySumCommonQuery,page,limit);
    }

}
