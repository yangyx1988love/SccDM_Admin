package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.DryCleaner;
import nankai.xl.business.model.vo.DryCleanerVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DryCleanerMapper {
    List<DryCleanerVo> selectByExample(DryCleanerVo dryCleanerVo);
    DryCleanerVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(DryCleaner dryCleaner);
    int insertOrUpdate(DryCleaner dryCleaner);
    int insertSelective(DryCleaner dryCleaner);
    int insertList(List<DryCleaner> list);
}