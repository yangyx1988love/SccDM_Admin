package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RongjiRaw;
import nankai.xl.business.model.vo.RongjiRawVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RongjiRawMapper {
    RongjiRaw selectById(Integer id);
    List<RongjiRawVo> selectByFactoryId(Integer factoryId);
    int updateById(RongjiRaw rongjiRaw);
}