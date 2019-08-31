package nankai.xl.business.service;

import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.SccVo;

import java.util.List;


public interface SelectCommonService {
    //select下拉框加载项
    public List<County> getAllCountys();
    public List<County> getCountysByCityCode(String cityCode);
    public County getCountyById(String countyId);
    public List<City> getAllCitys();
    public City getCityByCode(String cityCode);
    City getCityByCountyId(String countyId);
    List<City> getCitysByProvinceCode(String provinceCode);
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
}
