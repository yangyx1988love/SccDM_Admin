package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Exhaust;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExhaustMapper {
    List<Exhaust> selectByFactoryId(Integer factoryId);
    Exhaust selectByExfId(Integer exfId);
    int updateByExfId(Exhaust exhaust);
    int insertOrUpdate(Exhaust exhaust);
}