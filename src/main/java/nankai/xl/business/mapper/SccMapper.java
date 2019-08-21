package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Scc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SccMapper {
    Scc selectByScc(String scc);
}