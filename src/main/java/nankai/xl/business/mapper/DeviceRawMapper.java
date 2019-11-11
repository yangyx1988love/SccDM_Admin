package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.DeviceRaw;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceRawMapper {
    DeviceRaw selectById(Integer id);
    List<DeviceRaw> selectByDeviceId(Integer deviceId);
    List<DeviceRaw> selectByFactoryId(Integer factoryId);
    int updateById(DeviceRaw deviceRaw);
}