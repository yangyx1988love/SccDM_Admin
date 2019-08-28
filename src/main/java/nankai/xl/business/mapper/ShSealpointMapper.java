package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.ShSealpoint;
import nankai.xl.business.model.vo.ShSealpointVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShSealpointMapper {
    List<ShSealpointVo> selectByExample(ShSealpointVo shSealpointVo);
    ShSealpointVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(ShSealpoint shSealpoint);
    int insertOrUpdate(ShSealpoint shSealpoint);
    int insertSelective(ShSealpoint shSealpoint);
}