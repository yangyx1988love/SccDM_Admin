package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Boiler;
import nankai.xl.business.model.vo.BoilerSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.SumVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoilerMapper {
    Boiler selectById(Integer id);
    List<Boiler> selectByExhustId(Integer exhustId);
    List<Boiler> selectByFactoryId(Integer factoryId);
    List<BoilerSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(Boiler boiler);
    List<SumVo> countByCity();
    List<SumVo> countByCounty();
}