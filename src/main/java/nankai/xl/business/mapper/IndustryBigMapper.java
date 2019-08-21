package nankai.xl.business.mapper;

import nankai.xl.business.model.IndustryBig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndustryBigMapper {
    List<IndustryBig> selectAllIndustryBigs();
}