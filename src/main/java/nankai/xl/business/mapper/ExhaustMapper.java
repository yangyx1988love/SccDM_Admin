package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Exhaust;
import nankai.xl.business.model.vo.ExhaustSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExhaustMapper {
    List<Exhaust> selectByFactoryId(Integer factoryId);
    List<ExhaustSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    Exhaust selectByExfId(Integer exfId);
    int updateByExfId(Exhaust exhaust);
}