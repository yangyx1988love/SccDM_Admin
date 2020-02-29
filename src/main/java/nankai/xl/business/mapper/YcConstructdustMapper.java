package nankai.xl.business.mapper;

import java.util.List;

import nankai.xl.business.model.YcConstructdust;
import nankai.xl.business.model.vo.ycConstructdustVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YcConstructdustMapper {
    List<ycConstructdustVo> selectByExample(ycConstructdustVo xjconstructdustVo);
    ycConstructdustVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(YcConstructdust ycConstructdust);
    int insertOrUpdate(YcConstructdust ycConstructdust);
    int insertSelective(YcConstructdust ycConstructdust);
    int insertList(List<YcConstructdust> list);
}