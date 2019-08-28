package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.ScatteredCoal;
import nankai.xl.business.model.vo.ScatteredCoalVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ScatteredCoalMapper {
    int insertOrUpdate(ScatteredCoal scatteredCoal);
    int insertSelective(ScatteredCoal scatteredCoal);
    List<ScatteredCoalVo> selectByScatteredCoal(ScatteredCoalVo scatteredCoalVo);
    ScatteredCoalVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(ScatteredCoal scatteredCoal);
}