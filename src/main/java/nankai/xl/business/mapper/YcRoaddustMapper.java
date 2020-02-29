package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.YcRoaddust;
import nankai.xl.business.model.vo.YcRoaddustVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YcRoaddustMapper {
    List<YcRoaddustVo> selectByExample(YcRoaddustVo xjroaddustVo);
    YcRoaddustVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(YcRoaddust ycRoaddust);
    int insertOrUpdate(YcRoaddust ycRoaddust);
    int insertSelective(YcRoaddust ycRoaddust);
    int insertList(List<YcRoaddust> list);
}