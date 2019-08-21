package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.ShEffluentemission;
import nankai.xl.business.model.vo.ShEffluentemissionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShEffluentemissionMapper {
    List<ShEffluentemissionVo> selectByExample(ShEffluentemissionVo shEffluentemissionVo);
    ShEffluentemissionVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(ShEffluentemission shEffluentemission);
    int insertOrUpdate(ShEffluentemission shEffluentemission);
}