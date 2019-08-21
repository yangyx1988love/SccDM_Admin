package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Boiler;
import nankai.xl.business.model.vo.BoilerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BoilerMapper {
    Boiler selectById(Integer id);
    List<Boiler> selectByExhustId(Integer exhustId);
    List<BoilerVo> selectByFactoryId(Integer factoryId);
    int updateById(Boiler boiler);
    int insertOrUpdate(Boiler boiler);
}