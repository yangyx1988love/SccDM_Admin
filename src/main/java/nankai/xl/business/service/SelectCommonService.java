package nankai.xl.business.service;

import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.SccVo;
import nankai.xl.system.model.Adminuser;

import java.util.List;
import java.util.Map;


public interface SelectCommonService {
    //select下拉框加载项
    public List<County> getAllCountys();
    public List<County> getCountysByCityCode(String cityCode);
    public County getCountyById(String countyId);
    public List<City> getAllCitys();
    public City getCityByCode(String cityCode);
    City getCityByCountyId(String countyId);
    List<City> getCitysByProvinceCode(String provinceCode);
    //根据用于级别和所在部门，选择下拉框中展示的城市、区县信息
    List<City> getCitysByUser(Adminuser user);
    List<County> getCountysByUser(Adminuser user);
    //根据用户选择源管理中该城市或者区县的源
    Map<String,String> getCityAndCountyCodeByuser(Adminuser user);
    public List<Status> getAllStatus();
    Status getStatusById(Integer id);
    public List<Industry> getIndustrysByCode(String industryCode);
    public List<IndustryBig> getAllIndustryBigs();
    public List<Source> getAllSources();
    public List<Scc2> getScc2sByScc2(Scc2 scc2);
    public List<Scc3> getScc3sByScc3(Scc3 scc3);
    public List<Scc4> getScc3sByScc4(Scc4 scc4);
    SccVo selectBySccCode(String sccCode);
    public List<Dustremove> getAllDustremoves();
    public List<Nitreremove> getAllNitreremoves();
    public List<Sulphurremove> getAllSulphurremoves();
    Company getCompanyByExample(String companyName);
    Company getCompanysByVagueName(String companyName);
    List<Scc3> getScc3BySccCode12(String sccCode12);
    List<Scc4> getScc4BySccCode123(String sccCode123);
}
