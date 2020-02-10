package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Scc;
import nankai.xl.business.model.vo.SccActivity;
import nankai.xl.business.model.vo.SccQueryVo;
import nankai.xl.business.model.vo.SccResultVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SccMapper {
    SccActivity selectSccActivityByScc(String scc);
    Scc selectById(String scc);
    List<Scc> selectByLikeScc(String scc);
    List<SccResultVo> selectBySccQuery(SccQueryVo sccQueryVo);
    int insertSelective(Scc scc);
    int updateById(Scc scc);
}