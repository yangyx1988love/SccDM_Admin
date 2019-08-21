package nankai.xl.business.service;

import nankai.xl.business.model.Device;
import nankai.xl.business.model.DeviceProduct;
import nankai.xl.business.model.DeviceRaw;
import nankai.xl.business.model.vo.DeviceProductVo;
import nankai.xl.business.model.vo.DeviceRawVo;
import nankai.xl.business.model.vo.DeviceVo;

import java.util.List;

public interface DeviceCommonService {
    //设备
    Device getDeviceById(Integer id);
    List<Device> getDevicesByExfId(Integer exfId);
    List<DeviceVo> getDevicesByFactoryId(Integer factoryId);
    int updateDeviceById(Device device);
    int insertOrUpdateDevice(Device device);
    //设备原料
    DeviceRaw getDeviceRawById(Integer id);
    List<DeviceRaw> getDeviceRawsDeviceId(Integer deviceId);
    List<DeviceRawVo> getDeviceRawsByFactoryId(Integer factoryId);
    int updateDeviceRawById(DeviceRaw deviceRaw);
    int insertOrUpdateDeviceRaw(DeviceRaw deviceRaw);
    //设备产品
    DeviceProduct getDeviceProductById(Integer id);
    List<DeviceProduct> getDeviceProductsDeviceId(Integer deviceId);
    List<DeviceProductVo> getDeviceProductsByFactoryId(Integer factoryId);
    int updateDeviceProductById(DeviceProduct deviceProduct);
    int insertOrUpdateDeviceProduct(DeviceProduct deviceProduct);
}
