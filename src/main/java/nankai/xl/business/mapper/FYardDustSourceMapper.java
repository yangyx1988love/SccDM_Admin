package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FYardDustSource;
import nankai.xl.business.model.vo.FYardDustSourceSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FYardDustSourceMapper {
    List<Integer> selectIdsByFactoryId(Integer factoryId);
    List<FYardDustSource> selectByFactoryId(Integer factoryId);
    FYardDustSource selectById(Integer windDustid);
    List<FYardDustSourceSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(FYardDustSource fYardDustSource);
}