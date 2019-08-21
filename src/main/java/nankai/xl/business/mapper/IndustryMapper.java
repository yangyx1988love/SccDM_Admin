package nankai.xl.business.mapper;

import nankai.xl.business.model.Industry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndustryMapper {
    //根据Industry_Big中industry_Code查询
    List<Industry> selectIndustrysByCode(String industryCode);
}