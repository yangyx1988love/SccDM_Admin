package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RepastFamily;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepastFamilyMapper {
    List<RepastFamily> selectByExample(RepastFamily repastFamily);
    RepastFamily selectById(Integer id);
    int deleteById(Integer id);
    int updateById(RepastFamily repastFamily);
    int insertOrUpdate(RepastFamily repastFamily);
}