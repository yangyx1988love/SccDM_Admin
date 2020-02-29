package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.YcDustLoad;
import nankai.xl.business.model.vo.YcDustLoadVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YcDustLoadMapper {
    List<YcDustLoadVo> selectByExample(YcDustLoadVo xjcydustLoadVo);
    YcDustLoadVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(YcDustLoad ycDustLoad);
    int insertOrUpdate(YcDustLoad ycDustLoad);
    int insertSelective(YcDustLoad ycDustLoad);
    int insertList(List<YcDustLoad> list);
}