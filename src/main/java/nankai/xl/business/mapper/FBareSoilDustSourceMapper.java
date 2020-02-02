package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FBareSoilDustSource;
import nankai.xl.business.model.vo.FBareSoilDustSourceSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FBareSoilDustSourceMapper {
    List<Integer> selectIdsByFactoryId(Integer factoryId);
    List<FBareSoilDustSource> selectByFactoryId(Integer factoryId);
    FBareSoilDustSource selectById(Integer bareSoilid);
    List<FBareSoilDustSourceSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(FBareSoilDustSource fBareSoilDustSource);
}