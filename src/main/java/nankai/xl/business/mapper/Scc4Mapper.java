package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Scc4;
import nankai.xl.business.model.vo.SccVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Scc4Mapper {
    List<Scc4> selectByScc4(Scc4 scc4);
    SccVo selectBySccCode(String sccCode);
    List<Scc4> selectBySccCode123(String sccCode123);
}