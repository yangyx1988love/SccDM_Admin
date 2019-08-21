package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Device;
import nankai.xl.business.model.vo.DeviceVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceMapper {
    Device selectById(Integer id);
    List<Device> selectByExfId(Integer exfId);
    List<DeviceVo> selectByFactoryId(Integer factoryId);
    int updateById(Device device);
    int insertOrUpdate(Device device);
}
