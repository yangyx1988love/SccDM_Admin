package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.BiomassStraw;
import nankai.xl.business.model.vo.BiomassStrawVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BiomassStrawMapper {
    List<BiomassStrawVo> selectByExample(BiomassStrawVo biomassStrawVo);
    BiomassStrawVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(BiomassStraw biomassStraw);
    int insertOrUpdate(BiomassStraw biomassStraw);
}