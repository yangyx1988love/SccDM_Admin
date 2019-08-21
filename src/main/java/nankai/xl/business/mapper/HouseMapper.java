package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.House;
import nankai.xl.business.model.vo.HouseVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface HouseMapper {
    List<HouseVo> selectByExample(HouseVo houseVo);
    HouseVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(House house);
    int insertOrUpdate(House house);
}