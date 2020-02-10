package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Scc1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Scc1Mapper {
    List<Scc1> selectAll();
}