package nankai.xl.business.service;

import nankai.xl.business.model.Device;
import nankai.xl.business.model.DeviceProduct;
import nankai.xl.business.model.DeviceRaw;
import nankai.xl.business.model.vo.DeviceProductSumVo;
import nankai.xl.business.model.vo.DeviceRawSumVo;
import nankai.xl.business.model.vo.DeviceSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.system.model.Adminuser;

import java.util.List;

public interface DeviceCommonService {
    //设备
    Device getDeviceById(Integer id);
    List<Device> getDevicesByFactoryId(Integer factoryId);
    int updateDeviceById(Device device);
    List<DeviceSumVo> getSumDevices(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<DeviceSumVo> getSumDevices(Adminuser user, int page, int limit);
    //设备原料
    DeviceRaw getDeviceRawById(Integer id);
    List<DeviceRaw> getDeviceRawsDeviceId(Integer deviceId);
    List<DeviceRaw> getDeviceRawsByFactoryId(Integer factoryId);
    List<DeviceRawSumVo> getSumDeviceRaws(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<DeviceRawSumVo> getSumDeviceRaws(Adminuser user, int page, int limit);
    int updateDeviceRawById(DeviceRaw deviceRaw);
    //设备产品
    DeviceProduct getDeviceProductById(Integer id);
    List<DeviceProduct> getDeviceProductsDeviceId(Integer deviceId);
    List<DeviceProduct> getDeviceProductsByFactoryId(Integer factoryId);
    int updateDeviceProductById(DeviceProduct deviceProduct);
    List<DeviceProductSumVo> getSumDeviceProducts(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<DeviceProductSumVo> getSumDeviceProducts(Adminuser user, int page, int limit);
}
