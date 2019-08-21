package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.OilSource;
import nankai.xl.business.model.vo.OilSourceVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OilSourceMapper {
    List<OilSourceVo> selectByExample(OilSourceVo oilSourceVo);
    OilSourceVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(OilSource oilSource);
    int insertOrUpdate(OilSource oilSource);
}