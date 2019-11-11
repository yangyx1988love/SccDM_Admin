package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.DeviceProduct;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceProductMapper {
    DeviceProduct selectById(Integer id);
    List<DeviceProduct> selectByDeviceId(Integer deviceId);
    List<DeviceProduct> selectByFactoryId(Integer factoryId);
    int updateById(DeviceProduct deviceProduct);
}