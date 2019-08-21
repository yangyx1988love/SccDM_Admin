package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Deoil;
import nankai.xl.business.model.vo.DeoilVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeoilMapper {
    List<DeoilVo> selectByExample(DeoilVo deoilVo);
    DeoilVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Deoil deoil);
    int insertOrUpdate(Deoil deoil);
}