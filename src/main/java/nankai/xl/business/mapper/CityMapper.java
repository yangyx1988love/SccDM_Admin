package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.City;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper {

    List<City> selectAllCitys();
    City selectCityByCode(String cityCode);
    City selectCityByCountyId(String countyId);
    List<City> selectCitysByProvinceCode(String provinceCode);
}