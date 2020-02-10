package nankai.xl.business.service;

import nankai.xl.business.model.Factory;
import nankai.xl.business.model.User;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.model.vo.FactoryVo;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.system.model.Adminuser;

import java.util.List;
public interface FactoryService {
    public List<FactoryVo> getFactoryListByQuery(FactoryQuery factoryQuery, int page, int limit);
    public List<FactoryVo> getAllFactorys(int page, int limit);
    public List<FactoryVo> getAllFactorys();
    public List<FactoryVo> getFactorysByuser(Adminuser user,int page, int limit);
    public List<FactoryVo> getFactorysByuser(Adminuser user);
    FactoryVo getBackById(Integer factoryId);
    FactoryVo getNextById(Integer factoryId);
    FactoryVo getFactoryById(Integer factoryId);
    public void updateUserPassword(String factoryNo1, String password);
    public String addFactoryUser(Factory factory, User user);
    public boolean updateByFactoryId(Factory factory);
    public int delFactroy(Integer factoryId);
    //企业用户
    User getUserByFactoryId(Integer factoryId);
    public boolean auditFactory(Integer[] factoryIds);

    //用于统计
    //统计未审核企业
    public List<SumVo> countNonAuthByuser(Adminuser user);
    //按行业大分类统计
    public List<SumVo> countIndustryBigByuser(Adminuser user);
    //按城市统计企业数量
    public List<SumVo> countByCity(Adminuser user);

    public List<SumVo> countByCounty(Adminuser user);
}
