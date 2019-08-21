package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.DeviceProduct;
import nankai.xl.business.model.vo.DeviceProductVo;
import nankai.xl.business.model.vo.DeviceRawVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceProductMapper {
    DeviceProduct selectById(Integer id);
    List<DeviceProduct> selectByDeviceId(Integer deviceId);
    List<DeviceProductVo> selectByFactoryId(Integer factoryId);
    int updateById(DeviceProduct deviceProduct);
    int insertOrUpdate(DeviceProduct deviceProduct);
}