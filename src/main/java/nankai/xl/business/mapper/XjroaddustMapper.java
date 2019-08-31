package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Xjroaddust;
import nankai.xl.business.model.vo.XjroaddustVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XjroaddustMapper {
    List<XjroaddustVo> selectByExample(XjroaddustVo xjroaddustVo);
    XjroaddustVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Xjroaddust xjroaddust);
    int insertOrUpdate(Xjroaddust xjroaddust);
    int insertSelective(Xjroaddust xjroaddust);
}