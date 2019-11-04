package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RepastBarbecue;
import nankai.xl.business.model.vo.RepastBarbecueVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepastBarbecueMapper {
    List<RepastBarbecueVo> selectByExample(RepastBarbecueVo repastBarbecueVo);
    RepastBarbecueVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(RepastBarbecue repastBarbecue);
    int insertOrUpdate(RepastBarbecue repastBarbecue);
    int insertSelective(RepastBarbecue repastBarbecue);
    int insertList(List<RepastBarbecue> list);
}