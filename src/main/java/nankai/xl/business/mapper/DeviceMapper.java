package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Device;
import nankai.xl.business.model.vo.DeviceSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceMapper {
    Device selectById(Integer id);
    List<Device> selectByFactoryId(Integer factoryId);
    List<DeviceSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(Device device);
}
