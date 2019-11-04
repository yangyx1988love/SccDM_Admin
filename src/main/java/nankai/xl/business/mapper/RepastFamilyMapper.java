package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RepastFamily;
import nankai.xl.business.model.vo.RepastFamilyVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepastFamilyMapper {
    List<RepastFamilyVo> selectByExample(RepastFamilyVo repastFamilyVo);
    RepastFamilyVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(RepastFamily repastFamily);
    int insertOrUpdate(RepastFamily repastFamily);
    int insertSelective(RepastFamily repastFamily);
    int insertList(List<RepastFamily> list);
}