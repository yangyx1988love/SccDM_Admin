package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.AgricultureMachinery;
import nankai.xl.business.model.vo.AgricultureMachineryVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AgricultureMachineryMapper {
    List<AgricultureMachineryVo> selectByExample(AgricultureMachineryVo agricultureMachineryVo);
    AgricultureMachineryVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(AgricultureMachinery agricultureMachinery);
    int insertOrUpdate(AgricultureMachinery agricultureMachinery);
    int insertSelective(AgricultureMachinery agricultureMachinery);
    int insertList(List<AgricultureMachinery> list);
}