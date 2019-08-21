package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Feiqi;
import nankai.xl.business.model.vo.FeiqiVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FeiqiMapper {
    Feiqi selectById(Integer id);
    List<FeiqiVo> selectByFactoryId(Integer factoryId);
    int updateById(Feiqi feiqi);
}