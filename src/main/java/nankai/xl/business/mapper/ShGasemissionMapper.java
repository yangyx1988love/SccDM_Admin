package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.ShGasemission;
import nankai.xl.business.model.vo.ShGasemissionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShGasemissionMapper {
    int insertOrUpdate(ShGasemission shGasemission);
    int insertSelective(ShGasemission shGasemission);
    int insertList(List<ShGasemission> list);
    List<ShGasemissionVo> selectByShGas(ShGasemissionVo shGasemissionVo);
    ShGasemissionVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(ShGasemission shGasemission);
}