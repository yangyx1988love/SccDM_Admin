package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.BiomassForestGrassland;
import nankai.xl.business.model.vo.BiomassForestGrasslandVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BiomassForestGrasslandMapper {
    List<BiomassForestGrasslandVo> selectByExample(BiomassForestGrasslandVo biomassForestGrasslandVo);
    BiomassForestGrasslandVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(BiomassForestGrassland biomassForestGrassland);
    int insertOrUpdate(BiomassForestGrassland biomassForestGrassland);
}