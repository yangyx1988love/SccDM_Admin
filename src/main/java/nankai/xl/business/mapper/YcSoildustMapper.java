package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.YcSoildust;
import nankai.xl.business.model.vo.YcSoildustVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YcSoildustMapper {
    List<YcSoildustVo> selectByExample(YcSoildustVo xjsoildustVo);
    YcSoildustVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(YcSoildust ycSoildust);
    int insertOrUpdate(YcSoildust ycSoildust);
    int insertSelective(YcSoildust ycSoildust);
    int insertList(List<YcSoildust> list);
}