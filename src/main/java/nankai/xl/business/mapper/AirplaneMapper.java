package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Airplane;
import nankai.xl.business.model.vo.AirplaneVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AirplaneMapper {
    List<AirplaneVo> selectByExample(AirplaneVo airplaneVo);
    AirplaneVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Airplane airplane);
    int insertOrUpdate(Airplane airplane);
}