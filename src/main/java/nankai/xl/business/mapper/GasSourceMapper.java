package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.GasSource;
import nankai.xl.business.model.vo.GasSourceVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GasSourceMapper {
    List<GasSourceVo> selectByExample(GasSourceVo gasSourceVo);
    GasSourceVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(GasSource gasSource);
    int insertOrUpdate(GasSource gasSource);
    int insertSelective(GasSource gasSource);
}