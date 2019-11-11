package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RongjiRaw;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RongjiRawMapper {
    RongjiRaw selectById(Integer id);
    List<RongjiRaw> selectByFactoryId(Integer factoryId);
    int updateById(RongjiRaw rongjiRaw);
}