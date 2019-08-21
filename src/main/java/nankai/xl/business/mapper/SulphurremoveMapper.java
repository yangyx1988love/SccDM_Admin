package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Sulphurremove;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SulphurremoveMapper {
    List<Sulphurremove> selectAll();
    Sulphurremove selectById(Integer id);
}