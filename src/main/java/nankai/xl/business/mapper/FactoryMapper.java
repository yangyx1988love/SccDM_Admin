package nankai.xl.business.mapper;

import java.util.List;

import nankai.xl.business.model.Factory;
import nankai.xl.business.model.User;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.model.vo.SumVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FactoryMapper {

    List<Factory> selectAllFactorys();
    List<Factory> selectByFactoryQuery(FactoryQuery factoryQuery);
    Factory selectById(Integer factoryId);
    Factory selectBackById(Integer factoryId);
    Factory selectNextById(Integer factoryId);
    int updatePassByFactoryNO(User user);
    int insertSelective(Factory factory);
    int updateByFactoryId(Factory factory);
    /**
     * 统计已经有几个此用户名, 用来检测用户名是否重复.
     */
    int countByFactoryNo1(@Param("factoryNo1") String factoryNo1);
    List<SumVo> countNonAthu(FactoryQuery factoryQuery);
    List<SumVo> countByIndustryBig(FactoryQuery factoryQuery);

    List<SumVo> countByCity();
    List<SumVo> countByCounty();

}