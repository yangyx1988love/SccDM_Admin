package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CompanyMapper {
    Company selectByFullName(String companyName);
    List<Company> selectByExample(String companyName);
    Company selectByVagueName(String companyName);
    Company selectById(Integer comId);
    int insertSelective(Company company);
    int deleteByPrimaryKey(Integer comId);
    int updateById(Company company);
}