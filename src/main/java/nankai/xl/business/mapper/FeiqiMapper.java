package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Feiqi;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeiqiMapper {
    Feiqi selectById(Integer id);
    List<Feiqi> selectByFactoryId(Integer factoryId);
    int updateById(Feiqi feiqi);
}