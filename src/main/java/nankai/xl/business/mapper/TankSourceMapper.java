package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.TankSource;
import nankai.xl.business.model.vo.TankSourceVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface TankSourceMapper {
    List<TankSourceVo> selectByExample(TankSourceVo tankSourceVo);
    TankSourceVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(TankSource tankSource);
    int insertOrUpdate(TankSource tankSource);
}