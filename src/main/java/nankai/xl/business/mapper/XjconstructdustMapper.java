package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Xjconstructdust;
import nankai.xl.business.model.vo.XjconstructdustVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XjconstructdustMapper {
    List<XjconstructdustVo> selectByExample(XjconstructdustVo xjconstructdustVo);
    XjconstructdustVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Xjconstructdust xjconstructdust);
    int insertOrUpdate(Xjconstructdust xjconstructdust);
    int insertSelective(Xjconstructdust xjconstructdust);
    int insertList(List<Xjconstructdust> list);
}