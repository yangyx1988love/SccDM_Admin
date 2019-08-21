package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FConstructionDustSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FConstructionDustSourceMapper {
    List<Integer> selectByFactoryId(Integer factoryId);
    FConstructionDustSource selectById(Integer constructDustid);
    int updateById(FConstructionDustSource fConstructionDustSource);
}