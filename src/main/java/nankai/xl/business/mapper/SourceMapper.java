package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Source;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SourceMapper {
    List<Source> selectAllSources();
}