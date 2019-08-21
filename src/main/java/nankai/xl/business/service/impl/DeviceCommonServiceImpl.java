package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.DeviceMapper;
import nankai.xl.business.mapper.DeviceProductMapper;
import nankai.xl.business.mapper.DeviceRawMapper;
import nankai.xl.business.model.Device;
import nankai.xl.business.model.DeviceProduct;
import nankai.xl.business.model.DeviceRaw;
import nankai.xl.business.model.vo.DeviceProductVo;
import nankai.xl.business.model.vo.DeviceRawVo;
import nankai.xl.business.model.vo.DeviceVo;
import nankai.xl.business.service.DeviceCommonService;
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
    @Override
    public Device getDeviceById(Integer id) {
        return deviceMapper.selectById(id);
    }

    @Override
    public List<Device> getDevicesByExfId(Integer exfId) {
        return deviceMapper.selectByExfId(exfId);
    }

    @Override
    public List<DeviceVo> getDevicesByFactoryId(Integer factoryId) {
        return deviceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateDeviceById(Device device) {
        return deviceMapper.updateById(device);
    }

    @Override
    public int insertOrUpdateDevice(Device device) {
        return deviceMapper.insertOrUpdate(device);
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
    public List<DeviceRawVo> getDeviceRawsByFactoryId(Integer factoryId) {
        return deviceRawMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateDeviceRawById(DeviceRaw deviceRaw) {
        return deviceRawMapper.updateById(deviceRaw);
    }

    @Override
    public int insertOrUpdateDeviceRaw(DeviceRaw deviceRaw) {
        return deviceRawMapper.insertOrUpdate(deviceRaw);
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
    public List<DeviceProductVo> getDeviceProductsByFactoryId(Integer factoryId) {
        return deviceProductMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateDeviceProductById(DeviceProduct deviceProduct) {
        return deviceProductMapper.updateById(deviceProduct);
    }

    @Override
    public int insertOrUpdateDeviceProduct(DeviceProduct deviceProduct) {
        return deviceProductMapper.insertOrUpdate(deviceProduct);
    }
}
