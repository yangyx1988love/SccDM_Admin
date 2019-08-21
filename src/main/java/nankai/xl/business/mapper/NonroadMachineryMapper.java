package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.NonroadMachinery;
import nankai.xl.business.model.vo.NonroadMachineryVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NonroadMachineryMapper {
    List<NonroadMachineryVo> selectByExample(NonroadMachineryVo nonroadMachineryVo);
    NonroadMachineryVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(NonroadMachinery nonroadMachinery);
    int insertOrUpdate(NonroadMachinery nonroadMachinery);
}