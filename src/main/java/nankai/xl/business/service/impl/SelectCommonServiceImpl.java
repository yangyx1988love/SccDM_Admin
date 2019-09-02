package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.SccVo;
import nankai.xl.business.service.SelectCommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectCommonServiceImpl implements SelectCommonService {
    @Resource
    private CountyMapper countyMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private StatusMapper statusMapper;
    @Resource
    private IndustryMapper industryMapper;
    @Resource
    private IndustryBigMapper industryBigMapper;
    @Resource
    private SourceMapper sourceMapper;
    @Resource
    private Scc2Mapper scc2Mapper;
    @Resource
    private  Scc3Mapper scc3Mapper;
    @Resource
    private  Scc4Mapper scc4Mapper;
    @Resource
    private DustremoveMapper dustremoveMapper;
    @Resource
    private NitreremoveMapper nitreremoveMapper;
    @Resource
    private SulphurremoveMapper sulphurremoveMapper;
    @Resource
    private CompanyMapper companyMapper;
    @Override
    public List<County> getAllCountys() {
        return countyMapper.selectAllCountys();
    }

    @Override
    public List<County> getCountysByCityCode(String cityCode) {
        return countyMapper.selectCountysByCityCode(cityCode);
    }

    @Override
    public County getCountyById(String countyId) {
        return countyMapper.selectCountyById(countyId);
    }

    @Override
    public List<City> getAllCitys() {
        return cityMapper.selectAllCitys();
    }

    @Override
    public City getCityByCode(String cityCode) {
        return cityMapper.selectCityByCode(cityCode);
    }

    @Override
    public City getCityByCountyId(String countyId) {
        return cityMapper.selectCityByCountyId(countyId);
    }

    @Override
    public List<City> getCitysByProvinceCode(String provinceCode) {
        return cityMapper.selectCitysByProvinceCode(provinceCode);
    }

    @Override
    public List<Status> getAllStatus() {
        return statusMapper.selectAllStatus();
    }

    @Override
    public Status getStatusById(Integer id) {
        return statusMapper.selectById(id);
    }

    @Override
    public List<Industry> getIndustrysByCode(String industryCode) {
        return industryMapper.selectIndustrysByCode(industryCode);
    }
    @Override
    public List<IndustryBig> getAllIndustryBigs() {
        return industryBigMapper.selectAllIndustryBigs();
    }

    @Override
    public List<Source> getAllSources() {
        return sourceMapper.selectAllSources();
    }

    @Override
    public List<Scc2> getScc2sByScc2(Scc2 scc2) {
        return scc2Mapper.selectByScc2(scc2);
    }

    @Override
    public List<Scc3> getScc3sByScc3(Scc3 scc3) {
        return scc3Mapper.selectByScc3(scc3);
    }

    @Override
    public List<Scc4> getScc3sByScc4(Scc4 scc4) {
        return scc4Mapper.selectByScc4(scc4);
    }

    @Override
    public SccVo selectBySccCode(String sccCode) {
        SccVo sccVo=scc4Mapper.selectBySccCode(sccCode);
        if (sccVo==null){
            throw new NullPointerException("未查到该SCC编码，请联系管理员！");
        }
        return sccVo;
    }

    @Override
    public List<Dustremove> getAllDustremoves() {
        return dustremoveMapper.selectAll();
    }

    @Override
    public List<Nitreremove> getAllNitreremoves() {
        return nitreremoveMapper.selectAll();
    }

    @Override
    public List<Sulphurremove> getAllSulphurremoves() {
        return sulphurremoveMapper.selectAll();
    }

    @Override
    public Company getCompanyByExample(String companyName) {
        return companyMapper.selectByFullName(companyName);
    }

    @Override
    public Company getCompanysByVagueName(String companyName) {
        return companyMapper.selectByVagueName(companyName);
    }

    @Override
    public List<Scc3> getScc3BySccCode12(String sccCode12) {
        return scc3Mapper.selectByScc1Ascc2(sccCode12);
    }

    @Override
    public List<Scc4> getScc4BySccCode123(String sccCode123) {
        return scc4Mapper.selectBySccCode123(sccCode123);
    }
}
