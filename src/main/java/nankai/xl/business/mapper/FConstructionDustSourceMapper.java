package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FConstructionDustSource;
import nankai.xl.business.model.vo.FConstructionDustSourceSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FConstructionDustSourceMapper {
    List<Integer> selectIdsByFactoryId(Integer factoryId);
    List<FConstructionDustSource> selectByFactoryId(Integer factoryId);
    FConstructionDustSource selectById(Integer constructDustid);
    List<FConstructionDustSourceSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(FConstructionDustSource fConstructionDustSource);
}