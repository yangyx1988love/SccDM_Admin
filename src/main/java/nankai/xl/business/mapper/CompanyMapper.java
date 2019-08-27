package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CompanyMapper {
    int insertSelective(Company company);
    int deleteByPrimaryKey(Integer comId);
    int updateById(Company company);
}