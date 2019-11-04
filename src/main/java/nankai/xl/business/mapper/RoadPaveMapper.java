package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RoadPave;
import nankai.xl.business.model.vo.RoadPaveVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RoadPaveMapper {
    List<RoadPaveVo> selectByExample(RoadPaveVo roadPaveVo);
    RoadPaveVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(RoadPave roadPave);
    int insertOrUpdate(RoadPave roadPave);
    int insertSelective(RoadPave roadPave);
    int insertList(List<RoadPave> list);
}