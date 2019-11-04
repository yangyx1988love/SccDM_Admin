package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Repast;
import nankai.xl.business.model.vo.RepastVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepastMapper {
    List<RepastVo> selectByExample(RepastVo repastVo);
    RepastVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Repast repast);
    int insertOrUpdate(Repast repast);
    int insertSelective(Repast repast);
    int insertList(List<Repast> list);
}