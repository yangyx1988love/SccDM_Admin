package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.OilTransport;
import nankai.xl.business.model.vo.OilTransportVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OilTransportMapper {
    List<OilTransportVo> selectByExample(OilTransportVo oilTransportVo);
    OilTransportVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(OilTransport oilTransport);
    int insertOrUpdate(OilTransport oilTransport);
    int insertSelective(OilTransport oilTransport);
}