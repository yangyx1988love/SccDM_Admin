package nankai.xl.business.mapper;

import java.util.List;

import nankai.xl.business.model.Kiln;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.KilnSumVo;
import nankai.xl.business.model.vo.SumVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KilnMapper {
    Kiln selectById(Integer id);
    List<Kiln> selectByFactoryId(Integer factoryId);
    List<Kiln> selectByExhustId(Integer exhustId);
    List<KilnSumVo> selectSum(FactorySumCommonQuery factorySumCommonQuery);
    int updateById(Kiln kiln);
    int insertOrUpdate(Kiln kiln);

    List<SumVo> countByCity();
    List<SumVo> countByCounty();
}