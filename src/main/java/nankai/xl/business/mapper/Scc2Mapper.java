package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Scc2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Scc2Mapper {
    List<Scc2> selectByScc1(String scc1);
    List<Scc2> selectByScc2(Scc2 scc2);
}