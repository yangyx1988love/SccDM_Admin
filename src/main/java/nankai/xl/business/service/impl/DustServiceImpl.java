package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.service.DustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DustServiceImpl implements DustService {
    @Resource
    private FNoOrganizationWorkshopDischargeMapper fNoOrganizationWorkshopDischargeMapper;
    @Resource
    private FBareSoilDustSourceMapper fBareSoilDustSourceMapper;
    @Resource
    private FConstructionDustSourceMapper fConstructionDustSourceMapper;
    @Resource
    private FRoadDustSourceMapper fRoadDustSourceMapper;
    @Resource
    private FYardDustSourceMapper fYardDustSourceMapper;

    @Override
    public List<Integer> getFBareIdsByFactoryId(Integer factoryId) {
        return fBareSoilDustSourceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FBareSoilDustSource getFBareById(Integer bareSoilid) {
        return fBareSoilDustSourceMapper.selectById(bareSoilid);
    }

    @Override
    public int updateFBareById(FBareSoilDustSource fBareSoilDustSource) {
        return fBareSoilDustSourceMapper.updateById(fBareSoilDustSource);
    }

    @Override
    public List<Integer> getFConIdsByFactoryId(Integer factoryId) {
        return fConstructionDustSourceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FConstructionDustSource getFConById(Integer constructDustid) {
        return fConstructionDustSourceMapper.selectById(constructDustid);
    }

    @Override
    public int updateFConById(FConstructionDustSource fConstructionDustSource) {
        return fConstructionDustSourceMapper.updateById(fConstructionDustSource);
    }

    @Override
    public List<Integer> getFRoadIdsByFactoryId(Integer factoryId) {
        return fRoadDustSourceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FRoadDustSource getFRoadById(Integer roadDustid) {
        return fRoadDustSourceMapper.selectById(roadDustid);
    }

    @Override
    public int updateFRoadById(FRoadDustSource fRoadDustSource) {
        return fRoadDustSourceMapper.updateById(fRoadDustSource);
    }

    @Override
    public List<Integer> getFYardIdsByFactoryId(Integer factoryId) {
        return fYardDustSourceMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FYardDustSource getFYardById(Integer windDustid) {
        return fYardDustSourceMapper.selectById(windDustid);
    }

    @Override
    public int updateFYardById(FYardDustSource fYardDustSource) {
        return fYardDustSourceMapper.updateById(fYardDustSource);
    }

    @Override
    public List<FNoOrganizationWorkshopDischarge> getFnoOrgByFactoryId(Integer factoryId) {
        return fNoOrganizationWorkshopDischargeMapper.selectByFactoryId(factoryId);
    }

    @Override
    public FNoOrganizationWorkshopDischarge getFnoOrgsById(Integer wsid) {
        return fNoOrganizationWorkshopDischargeMapper.selectById(wsid);
    }

    @Override
    public int updateFnoOrgById(FNoOrganizationWorkshopDischarge fNoOrganizationWorkshopDischarge) {
        return fNoOrganizationWorkshopDischargeMapper.updateById(fNoOrganizationWorkshopDischarge);
    }
}
