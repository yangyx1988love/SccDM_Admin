package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.DeviceRaw;
import nankai.xl.business.model.vo.DeviceProductVo;
import nankai.xl.business.model.vo.DeviceRawVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceRawMapper {
    DeviceRaw selectById(Integer id);
    List<DeviceRaw> selectByDeviceId(Integer deviceId);
    List<DeviceRawVo> selectByFactoryId(Integer factoryId);
    int updateById(DeviceRaw deviceRaw);
    int insertOrUpdate(DeviceRaw deviceRaw);
}