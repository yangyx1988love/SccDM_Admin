package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Collectbreeding;
import nankai.xl.business.model.vo.CollectbreedingVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectbreedingMapper {
    List<CollectbreedingVo> selectByExample(CollectbreedingVo collectbreedingVo);
    CollectbreedingVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(Collectbreeding collectbreeding);
    int insertOrUpdate(Collectbreeding collectbreeding);
    int insertSelective(Collectbreeding collectbreeding);
    int insertList(List<Collectbreeding> list);
}