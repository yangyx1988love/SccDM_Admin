package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.DeviceRaw;
import nankai.xl.business.model.vo.DeviceRawSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceRawMapper {
    DeviceRaw selectById(Integer id);
    List<DeviceRaw> selectByDeviceId(Integer deviceId);
    List<DeviceRaw> selectByFactoryId(Integer factoryId);
    List<DeviceRawSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(DeviceRaw deviceRaw);
}