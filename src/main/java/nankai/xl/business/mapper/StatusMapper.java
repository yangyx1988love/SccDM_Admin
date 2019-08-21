package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Status;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatusMapper {
    List<Status> selectAllStatus();
    Status selectById(Integer id);
}