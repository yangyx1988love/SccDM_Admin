package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.XjcydustStack;
import nankai.xl.business.model.vo.XjcydustStackVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XjcydustStackMapper {
    List<XjcydustStackVo> selectByExample(XjcydustStackVo xjcydustStackVo);
    XjcydustStackVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(XjcydustStack xjcydustStack);
    int insertOrUpdate(XjcydustStack xjcydustStack);
    int insertSelective(XjcydustStack xjcydustStack);
    int insertList(List<XjcydustStack> list);
}