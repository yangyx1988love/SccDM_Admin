package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RoadMove;
import nankai.xl.business.model.vo.RoadMoveVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoadMoveMapper {
    List<RoadMoveVo> selectByExample(RoadMoveVo roadMoveVo);
    RoadMoveVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(RoadMove roadMove);
    int insertOrUpdate(RoadMove roadMove);
    int insertSelective(RoadMove roadMove);
}