package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.BiomassStove;
import nankai.xl.business.model.vo.BiomassStoveVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BiomassStoveMapper {
    List<BiomassStoveVo> selectByExample(BiomassStoveVo biomassStoveVo);
    BiomassStoveVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(BiomassStove biomassStove);
    int insertOrUpdate(BiomassStove biomassStove);
    int insertSelective(BiomassStove biomassStove);
    int insertList(List<BiomassStove> list);
}