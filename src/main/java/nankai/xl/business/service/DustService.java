package nankai.xl.business.service;

import nankai.xl.business.model.*;

import java.util.List;

public interface DustService {
    //裸土
    List<Integer> getFBareIdsByFactoryId(Integer factoryId);
    FBareSoilDustSource getFBareById(Integer bareSoilid);
    int updateFBareById(FBareSoilDustSource fBareSoilDustSource);
    //施工
    List<Integer> getFConIdsByFactoryId(Integer factoryId);
    FConstructionDustSource getFConById(Integer constructDustid);
    int updateFConById(FConstructionDustSource fConstructionDustSource);
    //道路
    List<Integer> getFRoadIdsByFactoryId(Integer factoryId);
    FRoadDustSource getFRoadById(Integer roadDustid);
    int updateFRoadById(FRoadDustSource fRoadDustSource);
    //堆场
    List<Integer> getFYardIdsByFactoryId(Integer factoryId);
    FYardDustSource getFYardById(Integer windDustid);
    int updateFYardById(FYardDustSource fYardDustSource);
    //无组织车间排放
    List<FNoOrganizationWorkshopDischarge> getFnoOrgByFactoryId(Integer factoryId);
    FNoOrganizationWorkshopDischarge getFnoOrgsById(Integer wsid);
    int updateFnoOrgById(FNoOrganizationWorkshopDischarge fNoOrganizationWorkshopDischarge);
}
