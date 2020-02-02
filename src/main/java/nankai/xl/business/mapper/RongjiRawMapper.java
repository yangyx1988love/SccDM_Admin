package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RongjiRaw;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.RongjiRawSumVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RongjiRawMapper {
    RongjiRaw selectById(Integer id);
    List<RongjiRaw> selectByFactoryId(Integer factoryId);
    List<RongjiRawSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(RongjiRaw rongjiRaw);
}