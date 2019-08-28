package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.ShVocdeviceeffi;
import nankai.xl.business.model.vo.ShVocdeviceeffiVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShVocdeviceeffiMapper {
    List<ShVocdeviceeffiVo> selectByExample(ShVocdeviceeffiVo shVocdeviceeffiVo);
    ShVocdeviceeffiVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(ShVocdeviceeffi shVocdeviceeffi);
    int insertOrUpdate(ShVocdeviceeffi shVocdeviceeffi);
    int insertSelective(ShVocdeviceeffi shVocdeviceeffi);
}