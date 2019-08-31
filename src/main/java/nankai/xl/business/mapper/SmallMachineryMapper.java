package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.SmallMachinery;
import nankai.xl.business.model.vo.SmallMachineryVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmallMachineryMapper {
    List<SmallMachineryVo> selectByExample(SmallMachineryVo smallMachineryVo);
    SmallMachineryVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(SmallMachinery smallMachinery);
    int insertOrUpdate(SmallMachinery smallMachinery);
    int insertSelective(SmallMachinery smallMachinery);
}