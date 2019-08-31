package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Xjsoildust;
import nankai.xl.business.model.vo.XjsoildustVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XjsoildustMapper {
    List<XjsoildustVo> selectByExample(XjsoildustVo xjsoildustVo);
    XjsoildustVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Xjsoildust xjsoildust);
    int insertOrUpdate(Xjsoildust xjsoildust);
    int insertSelective(Xjsoildust xjsoildust);
}