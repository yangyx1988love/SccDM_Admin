package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Scc3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Scc3Mapper {
    List<Scc3> selectByScc3(Scc3 scc3);
    List<Scc3> selectByScc1Ascc2(String sccCode12);
}