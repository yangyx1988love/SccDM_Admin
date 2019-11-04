package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.StrawCompost;
import nankai.xl.business.model.vo.StrawCompostVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface StrawCompostMapper {
    List<StrawCompostVo> selectByExample(StrawCompostVo strawCompostVo);
    StrawCompostVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(StrawCompost strawCompost);
    int insertOrUpdate(StrawCompost strawCompost);
    int insertSelective(StrawCompost strawCompost);
    int insertList(List<StrawCompost> list);
}