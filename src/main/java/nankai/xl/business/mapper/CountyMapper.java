package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.County;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountyMapper {
    List<County> selectAllCountys();
    List<County> selectCountysByCityCode(String cityCode);
    County selectCountyById(String countyId);
}