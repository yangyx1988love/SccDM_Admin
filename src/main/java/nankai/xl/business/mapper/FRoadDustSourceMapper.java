package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FRoadDustSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FRoadDustSourceMapper {
    List<Integer> selectIdsByFactoryId(Integer factoryId);
    List<FRoadDustSource> selectByFactoryId(Integer factoryId);
    FRoadDustSource selectById(Integer roadDustid);
    int updateById(FRoadDustSource fRoadDustSource);
}