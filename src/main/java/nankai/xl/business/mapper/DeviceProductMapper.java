package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.DeviceProduct;
import nankai.xl.business.model.vo.DeviceProductSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceProductMapper {
    DeviceProduct selectById(Integer id);
    List<DeviceProduct> selectByDeviceId(Integer deviceId);
    List<DeviceProduct> selectByFactoryId(Integer factoryId);
    List<DeviceProductSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(DeviceProduct deviceProduct);
}