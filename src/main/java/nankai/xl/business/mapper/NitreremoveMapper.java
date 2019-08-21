package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Nitreremove;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface NitreremoveMapper {
    List<Nitreremove> selectAll();
    Nitreremove selectById(Integer id);
}