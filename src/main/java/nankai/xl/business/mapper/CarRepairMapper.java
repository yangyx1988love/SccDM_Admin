package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.CarRepair;
import nankai.xl.business.model.vo.CarRepairVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface CarRepairMapper {
    List<CarRepairVo> selectByExample(CarRepairVo carRepairVo);
    CarRepairVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(CarRepair carRepair);
    int insertOrUpdate(CarRepair carRepair);
    int insertSelective(CarRepair carRepair);
}