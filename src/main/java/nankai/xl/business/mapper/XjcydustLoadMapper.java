package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.XjcydustLoad;
import nankai.xl.business.model.vo.XjcydustLoadVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XjcydustLoadMapper {
    List<XjcydustLoadVo> selectByExample(XjcydustLoadVo xjcydustLoadVo);
    XjcydustLoadVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(XjcydustLoad xjcydustLoad);
    int insertOrUpdate(XjcydustLoad xjcydustLoad);
    int insertSelective(XjcydustLoad xjcydustLoad);
}