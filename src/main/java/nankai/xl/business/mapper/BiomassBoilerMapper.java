package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.BiomassBoiler;
import nankai.xl.business.model.vo.BiomassBoilerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BiomassBoilerMapper {
    List<BiomassBoilerVo> selectByExample(BiomassBoilerVo biomassBoilerVo);
    BiomassBoilerVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(BiomassBoiler biomassBoiler);
    int insertOrUpdate(BiomassBoiler biomassBoiler);
}