package nankai.xl.business.mapper;

import java.util.List;

import nankai.xl.business.model.Factory;
import nankai.xl.business.model.User;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.model.vo.FactoryVo;
import nankai.xl.business.model.vo.SumVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FactoryMapper {

    List<FactoryVo> selectAllFactorys();
    List<FactoryVo> selectByFactoryQuery(FactoryQuery factoryQuery);
    FactoryVo selectById(Integer factoryId);
    FactoryVo selectBackById(Integer factoryId);
    FactoryVo selectNextById(Integer factoryId);
    int updatePassByFactoryNO(User user);
    int insertSelective(Factory factory);
    int updateByFactoryId(Factory factory);
    /**
     * 统计已经有几个此用户名, 用来检测用户名是否重复.
     */
    int countByFactoryNo(String factoryNo);
    List<SumVo> countNonAthu(FactoryQuery factoryQuery);
    List<SumVo> countByIndustryBig(FactoryQuery factoryQuery);

    List<SumVo> countByCity();
    List<SumVo> countByCounty();

}