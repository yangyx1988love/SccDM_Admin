package nankai.xl.business.service;

import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;
import nankai.xl.system.model.Adminuser;

import java.util.List;

public interface DustService {
    //裸土
    List<Integer> getFBareIdsByFactoryId(Integer factoryId);
    List<FBareSoilDustSource> getFBaresByFactoryId(Integer factoryId);
    FBareSoilDustSource getFBareById(Integer bareSoilid);
    List<FBareSoilDustSourceSumVo> getSumFBareSoilDustSources(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<FBareSoilDustSourceSumVo> getSumFBareSoilDustSources(Adminuser user, int page, int limit);
    int updateFBareById(FBareSoilDustSource fBareSoilDustSource);

    //施工
    List<Integer> getFConIdsByFactoryId(Integer factoryId);
    List<FConstructionDustSource> getFConsByFactoryId(Integer factoryId);
    FConstructionDustSource getFConById(Integer constructDustid);
    List<FConstructionDustSourceSumVo> getSumFConstructionDustSources(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<FConstructionDustSourceSumVo> getSumFConstructionDustSources(Adminuser user, int page, int limit);
    int updateFConById(FConstructionDustSource fConstructionDustSource);
    //道路
    List<Integer> getFRoadIdsByFactoryId(Integer factoryId);
    List<FRoadDustSource> getFRoadsByFactoryId(Integer factoryId);
    FRoadDustSource getFRoadById(Integer roadDustid);
    List<FRoadDustSourceSumVo> getSumFRoadDustSources(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<FRoadDustSourceSumVo> getSumFRoadDustSources(Adminuser user, int page, int limit);
    int updateFRoadById(FRoadDustSource fRoadDustSource);
    //堆场
    List<Integer> getFYardIdsByFactoryId(Integer factoryId);
    List<FYardDustSource> getFYardsByFactoryId(Integer factoryId);
    FYardDustSource getFYardById(Integer windDustid);
    List<FYardDustSourceSumVo> getSumFYardDustSources(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<FYardDustSourceSumVo> getSumFYardDustSources(Adminuser user, int page, int limit);
    int updateFYardById(FYardDustSource fYardDustSource);
    //无组织车间排放
    List<FNoOrganizationWorkshopDischarge> getFnoOrgByFactoryId(Integer factoryId);
    FNoOrganizationWorkshopDischarge getFnoOrgsById(Integer wsid);
    List<FNoOrganizationWorkshopDischargeSumVo> getSumFNoOrganizations(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<FNoOrganizationWorkshopDischargeSumVo> getSumFNoOrganizations(Adminuser user, int page, int limit);
    int updateFnoOrgById(FNoOrganizationWorkshopDischarge fNoOrganizationWorkshopDischarge);
}
