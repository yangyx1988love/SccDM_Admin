package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FreeStockbreeding;
import nankai.xl.business.model.vo.FreeStockbreedingVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface FreeStockbreedingMapper {
    List<FreeStockbreedingVo> selectByExample(FreeStockbreedingVo freeStockbreedingVo);
    FreeStockbreedingVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(FreeStockbreeding freeStockbreeding);
    int insertOrUpdate(FreeStockbreeding freeStockbreeding);
}