package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.NPlant;
import nankai.xl.business.model.vo.NPlantVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface NPlantMapper {
    List<NPlantVo> selectByExample(NPlantVo nPlantVo);
    NPlantVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(NPlant nPlant);
    int insertOrUpdate(NPlant nPlant);
    int insertSelective(NPlant nPlant);
    int insertList(List<NPlant> list);
}

