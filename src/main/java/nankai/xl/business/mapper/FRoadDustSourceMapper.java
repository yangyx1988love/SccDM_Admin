package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FRoadDustSource;
import nankai.xl.business.model.vo.FRoadDustSourceSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FRoadDustSourceMapper {
    List<Integer> selectIdsByFactoryId(Integer factoryId);
    List<FRoadDustSource> selectByFactoryId(Integer factoryId);
    FRoadDustSource selectById(Integer roadDustid);
    List<FRoadDustSourceSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(FRoadDustSource fRoadDustSource);
}