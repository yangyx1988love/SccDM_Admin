package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Fertilization;
import nankai.xl.business.model.vo.FertilizationVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface FertilizationMapper {
    List<FertilizationVo> selectByExample(FertilizationVo fertilizationVo);
    FertilizationVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Fertilization fertilization);
    int insertOrUpdate(Fertilization fertilization);
    int insertSelective(Fertilization fertilization);
    int insertList(List<Fertilization> list);
}