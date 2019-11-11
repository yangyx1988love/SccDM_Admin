package nankai.xl.business.service;

import nankai.xl.business.model.Device;
import nankai.xl.business.model.DeviceProduct;
import nankai.xl.business.model.DeviceRaw;

import java.util.List;

public interface DeviceCommonService {
    //设备
    Device getDeviceById(Integer id);
    List<Device> getDevicesByExfId(Integer exfId);
    List<Device> getDevicesByFactoryId(Integer factoryId);
    int updateDeviceById(Device device);
    //设备原料
    DeviceRaw getDeviceRawById(Integer id);
    List<DeviceRaw> getDeviceRawsDeviceId(Integer deviceId);
    List<DeviceRaw> getDeviceRawsByFactoryId(Integer factoryId);
    int updateDeviceRawById(DeviceRaw deviceRaw);
    //设备产品
    DeviceProduct getDeviceProductById(Integer id);
    List<DeviceProduct> getDeviceProductsDeviceId(Integer deviceId);
    List<DeviceProduct> getDeviceProductsByFactoryId(Integer factoryId);
    int updateDeviceProductById(DeviceProduct deviceProduct);
}
