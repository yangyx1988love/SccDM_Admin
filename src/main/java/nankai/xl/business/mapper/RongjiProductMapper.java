package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RongjiProduct;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.RongjiProductSumVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RongjiProductMapper {
    RongjiProduct selectById(Integer id);
    List<RongjiProduct> selectByFactoryId(Integer factoryId);
    List<RongjiProductSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(RongjiProduct rongjiProduct);
}