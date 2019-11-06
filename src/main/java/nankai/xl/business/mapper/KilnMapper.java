package nankai.xl.business.mapper;

import java.util.List;

import nankai.xl.business.model.Kiln;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.business.model.vo.KilnVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KilnMapper {
    Kiln selectById(Integer id);
    List<KilnVo> selectByFactoryId(Integer factoryId);
    List<Kiln> selectByExhustId(Integer exhustId);
    int updateById(Kiln kiln);
    int insertOrUpdate(Kiln kiln);

    List<SumVo> countByCity();
    List<SumVo> countByCounty();
}