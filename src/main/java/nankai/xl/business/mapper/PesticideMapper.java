package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Pesticide;
import nankai.xl.business.model.vo.PesticideVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PesticideMapper {
    List<PesticideVo> selectByExample(PesticideVo pesticideVo);
    PesticideVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Pesticide pesticide);
    int insertOrUpdate(Pesticide pesticide);
}