package nankai.xl.business.service;

import nankai.xl.business.model.Factory;
import nankai.xl.business.model.User;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.system.model.Adminuser;

import java.util.List;
public interface FactoryService {
    public List<Factory> getFactoryListByQuery(FactoryQuery factoryQuery,int page, int limit);
    public List<Factory> getAllFactorys(int page, int limit);
    public List<Factory> getAllFactorys();
    public List<Factory> getFactorysByuser(Adminuser user,int page, int limit);
    public List<Factory> getFactorysByuser(Adminuser user);
    Factory getBackById(Integer factoryId);
    Factory getNextById(Integer factoryId);
    Factory getFactoryById(Integer factoryId);
    public void updateUserPassword(String factoryNo1, String password);
    public String addFactoryUser(Factory factory, User user);
    public boolean updateByFactoryId(Factory factory);
    //企业用户
    User getUserByFactoryId(Integer factoryId);

    public boolean auditFactory(Integer[] factoryIds);

    //用于统计
    //统计未审核企业
    public List<SumVo> countNonAuthByuser(Adminuser user);
    //按行业大分类统计
    public List<SumVo> countIndustryBigByuser(Adminuser user);
    //按城市统计企业数量
    public List<SumVo> countByCity();

    public List<SumVo> countByCounty();
}
