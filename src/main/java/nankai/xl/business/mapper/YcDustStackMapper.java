package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.YcDustStack;
import nankai.xl.business.model.vo.YcDustStackVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YcDustStackMapper {
    List<YcDustStackVo> selectByExample(YcDustStackVo xjcydustStackVo);
    YcDustStackVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(YcDustStack ycDustStack);
    int insertOrUpdate(YcDustStack ycDustStack);
    int insertSelective(YcDustStack ycDustStack);
    int insertList(List<YcDustStack> list);
}