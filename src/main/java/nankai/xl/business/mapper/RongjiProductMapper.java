package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RongjiProduct;
import nankai.xl.business.model.vo.RongjiProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RongjiProductMapper {
    RongjiProduct selectById(Integer id);
    List<RongjiProductVo> selectByFactoryId(Integer factoryId);
    int updateById(RongjiProduct rongjiProduct);
}