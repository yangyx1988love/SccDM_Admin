package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RongjiProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RongjiProductMapper {
    RongjiProduct selectById(Integer id);
    List<RongjiProduct> selectByFactoryId(Integer factoryId);
    int updateById(RongjiProduct rongjiProduct);
}