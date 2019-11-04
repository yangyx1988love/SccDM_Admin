package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.BaseSoil;
import nankai.xl.business.model.vo.BaseSoilVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BaseSoilMapper {
    List<BaseSoilVo> selectByExample(BaseSoilVo baseSoilVo);
    BaseSoilVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(BaseSoil baseSoil);
    int insertOrUpdate(BaseSoil baseSoil);
    int insertSelective(BaseSoil baseSoil);
    int insertList(List<BaseSoil> list);
}