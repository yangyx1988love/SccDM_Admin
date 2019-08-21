package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FYardDustSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FYardDustSourceMapper {
    List<Integer> selectByFactoryId(Integer factoryId);
    FYardDustSource selectById(Integer windDustid);
    int updateById(FYardDustSource fYardDustSource);
}