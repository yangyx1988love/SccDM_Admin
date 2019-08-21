package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Dustremove;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DustremoveMapper {
    List<Dustremove> selectAll();
    Dustremove selectById(Integer id);
}