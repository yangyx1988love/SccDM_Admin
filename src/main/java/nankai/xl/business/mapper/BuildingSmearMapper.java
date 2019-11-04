package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.BuildingSmear;
import nankai.xl.business.model.vo.BuildingSmearVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BuildingSmearMapper {
    List<BuildingSmearVo> selectByExample(BuildingSmearVo buildingSmearVo);
    BuildingSmearVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(BuildingSmear buildingSmear);
    int insertOrUpdate(BuildingSmear buildingSmear);
    int insertSelective(BuildingSmear buildingSmear);
    int insertList(List<BuildingSmear> list);
}