package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Feiqi;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.FeiqiSumVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeiqiMapper {
    Feiqi selectById(Integer id);
    List<Feiqi> selectByFactoryId(Integer factoryId);
    List<FeiqiSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(Feiqi feiqi);
}