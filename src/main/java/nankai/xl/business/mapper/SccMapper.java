package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Scc;
import nankai.xl.business.model.vo.SccActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SccMapper {
    SccActivity selectByScc(String scc);
}