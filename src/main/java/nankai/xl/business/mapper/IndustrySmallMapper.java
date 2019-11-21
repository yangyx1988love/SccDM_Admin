package nankai.xl.business.mapper;

import nankai.xl.business.model.IndustrySmall;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface IndustrySmallMapper {
    List<IndustrySmall> selectByBigCode(String industryBig);
}