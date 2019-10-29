package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;
import nankai.xl.business.service.SourceService;
import nankai.xl.common.exception.DuplicateNameException;
import nankai.xl.common.util.ClassUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SourceServiceImpl implements SourceService {
    @Resource
    private ScatteredCoalMapper scatteredCoalMapper;
    @Resource
    private ShGasemissionMapper shGasemissionMapper;
    @Resource
    private ShSealpointMapper shSealpointMapper;
    @Resource
    private ShEffluentemissionMapper shEffluentemissionMapper;
    @Resource
    private ShVocdeviceeffiMapper shVocdeviceeffiMapper;
    @Resource
    private BuildingSmearMapper buildingSmearMapper;
    @Resource
    private CarRepairMapper carRepairMapper;
    @Resource
    private DeoilMapper deoilMapper;
    @Resource
    private DryCleanerMapper dryCleanerMapper;
    @Resource
    private HouseMapper houseMapper;
    @Resource
    private RoadPaveMapper roadPaveMapper;
    @Resource
    private XjconstructdustMapper xjconstructdustMapper;
    @Resource
    private XjcydustLoadMapper xjcydustLoadMapper;
    @Resource
    private XjroaddustMapper xjroaddustMapper;
    @Resource
    private XjsoildustMapper xjsoildustMapper;
    @Resource
    private XjcydustStackMapper xjcydustStackMapper;
    @Resource
    private GasSourceMapper gasSourceMapper;
    @Resource
    private OilSourceMapper oilSourceMapper;
    @Resource
    private OilTransportMapper oilTransportMapper;
    @Resource
    private TankSourceMapper tankSourceMapper;
    @Resource
    private BaseSoilMapper baseSoilMapper;
    @Resource
    private CollectbreedingMapper collectbreedingMapper;
    @Resource
    private FertilizationMapper fertilizationMapper;
    @Resource
    private FreeStockbreedingMapper freeStockbreedingMapper;
    @Resource
    private NPlantMapper nPlantMapper;
    @Resource
    private PesticideMapper pesticideMapper;
    @Resource
    private StrawCompostMapper strawCompostMapper;
    @Resource
    private BiomassBoilerMapper biomassBoilerMapper;
    @Resource
    private  BiomassForestGrasslandMapper biomassForestGrasslandMapper;
    @Resource
    private BiomassStoveMapper biomassStoveMapper;
    @Resource
    private BiomassStrawMapper biomassStrawMapper;
    @Resource
    private RoadMoveMapper roadMoveMapper;
    @Resource
    private RepastBarbecueMapper repastBarbecueMapper;
    @Resource
    private RepastFamilyMapper repastFamilyMapper;
    @Resource
    private RepastMapper repastMapper;
    @Resource
    private SccMapper sccMapper;
    @Resource
    private CompanyMapper companyMapper;

    @Override
    public int insertOrUpdateScatteredCoal(ScatteredCoalVo scatteredCoalVo,boolean isCul) {
        ScatteredCoal scatteredCoal=scatteredCoalVo;
        if (!isCul){
            Scc scc=getSccFactor(scatteredCoalVo.getSccCode());
            Double activity=scatteredCoal.getActivityLevelNum();
            scatteredCoal.setPm25Emission(activity*scc.getPm25());
            scatteredCoal.setPm10Emission(activity*scc.getPm10());
            scatteredCoal.setCoEmission(activity*scc.getCo());
            scatteredCoal.setVocEmission(activity*scc.getVocs());
            scatteredCoal.setSo2Emission(activity*scc.getSo2());
            scatteredCoal.setNoxEmission(activity*scc.getNox());
            scatteredCoal.setNh3Emission(activity*scc.getNh3());
            scatteredCoal.setOcEmission(activity*scc.getOc());
            scatteredCoal.setBcEmission(activity*scc.getBc());
        }
        if(scatteredCoal.getId()!=null){
            scatteredCoalMapper.updateById(scatteredCoal);
        }else {
            scatteredCoalMapper.insertSelective(scatteredCoal);
        }
        return 1;
    }
    @Override
    public List<ScatteredCoalVo> getByScatteredCoals(ScatteredCoalVo scatteredCoalVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return scatteredCoalMapper.selectByScatteredCoal(scatteredCoalVo);
    }

    @Override
    public ScatteredCoalVo getScatById(Integer id) {
        return scatteredCoalMapper.selectById(id);
    }

    @Override
    public int deleteScatById(Integer id) {
        return scatteredCoalMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateShGa(ShGasemissionVo shGasemissionVo,boolean isCul) {
        ShGasemission shGasemission=shGasemissionVo;
        Company company=shGasemission;
        int comId=insertOrUpdateCompany(company);
        shGasemission.setFactoryId(comId);
        if (!isCul){
            Scc scc=getSccFactor(shGasemission.getScccode());
            Double activity=shGasemission.getActivity();
            shGasemission.setPm25Emission(activity*scc.getPm25());
            shGasemission.setPm10Emission(activity*scc.getPm10());
            shGasemission.setCoEmission(activity*scc.getCo());
            shGasemission.setVocEmission(activity*scc.getVocs());
            shGasemission.setSo2Emission(activity*scc.getSo2());
            shGasemission.setNoxEmission(activity*scc.getNox());
            shGasemission.setNh3Emission(activity*scc.getNh3());
            shGasemission.setOcEmission(activity*scc.getOc());
            shGasemission.setBcEmission(activity*scc.getBc());
        }
        if(shGasemission.getId()!=null){
            shGasemissionMapper.updateById(shGasemission);
        }else {
            shGasemissionMapper.insertSelective(shGasemission);
        }
        return 1;
    }

    @Override
    public List<ShGasemissionVo> getShGasByShGas(ShGasemissionVo shGasemissionVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return shGasemissionMapper.selectByShGas(shGasemissionVo);
    }

    @Override
    public ShGasemissionVo getShGaById(Integer id) {
        return shGasemissionMapper.selectById(id);
    }

    @Override
    public int deleteShGaById(Integer id) {
        return shGasemissionMapper.deleteById(id);
    }

    @Override
    public List<ShSealpointVo> getShSealsByExample(ShSealpointVo shSealpointVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return shSealpointMapper.selectByExample(shSealpointVo);
    }

    @Override
    public ShSealpointVo getShSealById(Integer id) {
        return shSealpointMapper.selectById(id);
    }

    @Override
    public int deleteShSealById(Integer id) {
        return shSealpointMapper.deleteById(id);
    }


    @Override
    public int insertOrUpdateShSeal(ShSealpointVo shSealpointVo,boolean isCul) {
        ShSealpoint shSealpoint=shSealpointVo;
        Company company=shSealpoint;
        int comId=insertOrUpdateCompany(company);
        shSealpoint.setFactoryId(comId);
        if (!isCul){
            Scc scc=getSccFactor(shSealpoint.getScccode());
            Double activity=shSealpoint.getActivity();
            shSealpoint.setPm25Emission(activity*scc.getPm25());
            shSealpoint.setPm10Emission(activity*scc.getPm10());
            shSealpoint.setCoEmission(activity*scc.getCo());
            shSealpoint.setVocEmission(activity*scc.getVocs());
            shSealpoint.setSo2Emission(activity*scc.getSo2());
            shSealpoint.setNoxEmission(activity*scc.getNox());
            shSealpoint.setNh3Emission(activity*scc.getNh3());
            shSealpoint.setOcEmission(activity*scc.getOc());
            shSealpoint.setBcEmission(activity*scc.getBc());
        }
        if(shSealpoint.getId()!=null){
            shSealpointMapper.updateById(shSealpoint);
        }else {
            shSealpointMapper.insertSelective(shSealpoint);
        }
        return 1;
    }

    @Override
    public List<ShEffluentemissionVo> getShEffsByExample(ShEffluentemissionVo shEffluentemissionVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return shEffluentemissionMapper.selectByExample(shEffluentemissionVo);
    }

    @Override
    public ShEffluentemissionVo getShEffById(Integer id) {
        return shEffluentemissionMapper.selectById(id);
    }

    @Override
    public int deleteShEffById(Integer id) {
        return shEffluentemissionMapper.deleteById(id);
    }
    @Override
    public int insertOrUpdateShEff(ShEffluentemissionVo shEffluentemissionVo,boolean isCul){
        ShEffluentemission shEffluentemission=shEffluentemissionVo;
        Company company=shEffluentemission;
        int comId=insertOrUpdateCompany(company);
        shEffluentemission.setFactoryId(comId);
        if (!isCul){
            Scc scc=getSccFactor(shEffluentemission.getScccode());
            Double activity=shEffluentemission.getActivity();
            shEffluentemission.setPm25Emission(activity*scc.getPm25());
            shEffluentemission.setPm10Emission(activity*scc.getPm10());
            shEffluentemission.setCoEmission(activity*scc.getCo());
            shEffluentemission.setVocEmission(activity*scc.getVocs());
            shEffluentemission.setSo2Emission(activity*scc.getSo2());
            shEffluentemission.setNoxEmission(activity*scc.getNox());
            shEffluentemission.setNh3Emission(activity*scc.getNh3());
            shEffluentemission.setOcEmission(activity*scc.getOc());
            shEffluentemission.setBcEmission(activity*scc.getBc());
        }
        if(shEffluentemission.getId()!=null){
            shEffluentemissionMapper.updateById(shEffluentemission);
        }else {
            shEffluentemissionMapper.insertSelective(shEffluentemission);
        }
        return 1;
    }

    @Override
    public List<ShVocdeviceeffiVo> getShVocsByExample(ShVocdeviceeffiVo shVocdeviceeffiVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return shVocdeviceeffiMapper.selectByExample(shVocdeviceeffiVo);
    }

    @Override
    public ShVocdeviceeffiVo getShVocById(Integer id) {
        return shVocdeviceeffiMapper.selectById(id);
    }

    @Override
    public int deleteShVocById(Integer id) {
        return shVocdeviceeffiMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateShVoc(ShVocdeviceeffiVo shVocdeviceeffiVo,boolean isCul) {
        ShVocdeviceeffi shVocdeviceeffi=shVocdeviceeffiVo;
        Company company=shVocdeviceeffi;
        int comId=insertOrUpdateCompany(company);
        shVocdeviceeffi.setFactoryId(comId);
        if (!isCul){
            Scc scc=getSccFactor(shVocdeviceeffi.getScccode());
            Double activity=shVocdeviceeffi.getAnnualRuntime();
            shVocdeviceeffi.setPm25Emission(activity*scc.getPm25());
            shVocdeviceeffi.setPm10Emission(activity*scc.getPm10());
            shVocdeviceeffi.setCoEmission(activity*scc.getCo());
            shVocdeviceeffi.setVocEmission(activity*scc.getVocs());
            shVocdeviceeffi.setSo2Emission(activity*scc.getSo2());
            shVocdeviceeffi.setNoxEmission(activity*scc.getNox());
            shVocdeviceeffi.setNh3Emission(activity*scc.getNh3());
            shVocdeviceeffi.setOcEmission(activity*scc.getOc());
            shVocdeviceeffi.setBcEmission(activity*scc.getBc());
        }
        if(shVocdeviceeffi.getId()!=null){
            shVocdeviceeffiMapper.updateById(shVocdeviceeffi);
        }else {
            shVocdeviceeffiMapper.insertSelective(shVocdeviceeffi);
        }
        return 1;
    }

    @Override
    public List<BuildingSmearVo> getBuildsByExample(BuildingSmearVo buildingSmearVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return buildingSmearMapper.selectByExample(buildingSmearVo);
    }

    @Override
    public BuildingSmearVo getBuildById(Integer id) {
        return buildingSmearMapper.selectById(id);
    }

    @Override
    public int deleteBuildById(Integer id) {
        return buildingSmearMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateBuild(BuildingSmearVo buildingSmearVo,boolean isCul) {
        BuildingSmearVo buildingSmear=buildingSmearVo;
        if (!isCul){
            Scc scc=getSccFactor(buildingSmear.getScccode());
            Double activity=buildingSmear.getPaintAmount();
            buildingSmear.setPm25Emission(activity*scc.getPm25());
            buildingSmear.setPm10Emission(activity*scc.getPm10());
            buildingSmear.setCoEmission(activity*scc.getCo());
            buildingSmear.setVocEmission(activity*scc.getVocs());
            buildingSmear.setSo2Emission(activity*scc.getSo2());
            buildingSmear.setNoxEmission(activity*scc.getNox());
            buildingSmear.setNh3Emission(activity*scc.getNh3());
            buildingSmear.setOcEmission(activity*scc.getOc());
            buildingSmear.setBcEmission(activity*scc.getBc());
        }
        if(buildingSmear.getId()!=null){
            buildingSmearMapper.updateById(buildingSmear);
        }else {
            buildingSmearMapper.insertSelective(buildingSmear);
        }
        return 1;
    }

    @Override
    public List<CarRepairVo> getCarsByExample(CarRepairVo carRepairVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return carRepairMapper.selectByExample(carRepairVo);
    }

    @Override
    public CarRepairVo getCarById(Integer id) {
        return carRepairMapper.selectById(id);
    }

    @Override
    public int deleteCarById(Integer id) {
        return carRepairMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateCar(CarRepairVo carRepairVo,boolean isCul) {
        CarRepair carRepair=carRepairVo;
        Company company=carRepair;
        int comId=insertOrUpdateCompany(company);
        carRepair.setCompanyId(comId);
        if (!isCul){
            Scc scc=getSccFactor(carRepair.getScccode());
            Double activity=carRepair.getSolventAmount();
            carRepair.setPm25Emission(activity*scc.getPm25());
            carRepair.setPm10Emission(activity*scc.getPm10());
            carRepair.setCoEmission(activity*scc.getCo());
            carRepair.setVocEmission(activity*scc.getVocs());
            carRepair.setSo2Emission(activity*scc.getSo2());
            carRepair.setNoxEmission(activity*scc.getNox());
            carRepair.setNh3Emission(activity*scc.getNh3());
            carRepair.setOcEmission(activity*scc.getOc());
            carRepair.setBcEmission(activity*scc.getBc());
        }
        if(carRepair.getId()!=null){
            carRepairMapper.updateById(carRepair);
        }else {
            carRepairMapper.insertSelective(carRepair);
        }
        return 1;
    }

    @Override
    public List<DeoilVo> getDeoilsByExample(DeoilVo deoilVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return deoilMapper.selectByExample(deoilVo);
    }

    @Override
    public DeoilVo getDeoilById(Integer id) {
        return deoilMapper.selectById(id);
    }

    @Override
    public int deleteDeoilById(Integer id) {
        return deoilMapper.deleteById(id);
    }


    @Override
    public int insertOrUpdateDeoil(DeoilVo deoilVo,boolean isCul) {
        Deoil deoil=deoilVo;
        if (!isCul){
            Scc scc=getSccFactor(deoil.getScccode());
            Double activity=deoil.getPeoplenumber()+0.0;
            deoil.setPm25Emission(activity*scc.getPm25());
            deoil.setPm10Emission(activity*scc.getPm10());
            deoil.setCoEmission(activity*scc.getCo());
            deoil.setVocEmission(activity*scc.getVocs());
            deoil.setSo2Emission(activity*scc.getSo2());
            deoil.setNoxEmission(activity*scc.getNox());
            deoil.setNh3Emission(activity*scc.getNh3());
            deoil.setOcEmission(activity*scc.getOc());
            deoil.setBcEmission(activity*scc.getBc());
        }
        if(deoil.getId()!=null){
            deoilMapper.updateById(deoil);
        }else {
            deoilMapper.insertSelective(deoil);
        }
        return 1;
    }

    @Override
    public List<DryCleanerVo> getDrysByExample(DryCleanerVo dryCleanerVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return dryCleanerMapper.selectByExample(dryCleanerVo);
    }

    @Override
    public DryCleanerVo getDryById(Integer id) {
        return dryCleanerMapper.selectById(id);
    }

    @Override
    public int deleteDryById(Integer id) {
        return dryCleanerMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateDry(DryCleanerVo dryCleanerVo,boolean isCul) {
        DryCleaner dryCleaner=dryCleanerVo;
        Company company=dryCleaner;
        int comId=insertOrUpdateCompany(company);
        dryCleaner.setCompanyId(comId);
        if (!isCul){
            Scc scc=getSccFactor(dryCleaner.getScccode());
            Double activity=dryCleaner.getYearAmount();
            dryCleaner.setPm25Emission(activity*scc.getPm25());
            dryCleaner.setPm10Emission(activity*scc.getPm10());
            dryCleaner.setCoEmission(activity*scc.getCo());
            dryCleaner.setVocEmission(activity*scc.getVocs());
            dryCleaner.setSo2Emission(activity*scc.getSo2());
            dryCleaner.setNoxEmission(activity*scc.getNox());
            dryCleaner.setNh3Emission(activity*scc.getNh3());
            dryCleaner.setOcEmission(activity*scc.getOc());
            dryCleaner.setBcEmission(activity*scc.getBc());
        }
        if(dryCleaner.getId()!=null){
            dryCleanerMapper.updateById(dryCleaner);
        }else {
            dryCleanerMapper.insertSelective(dryCleaner);
        }
        return 1;
    }

    @Override
    public List<HouseVo> getHousesByExample(HouseVo houseVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return houseMapper.selectByExample(houseVo);
    }

    @Override
    public HouseVo getHouseById(Integer id) {
        return houseMapper.selectById(id);
    }

    @Override
    public int deleteHouseById(Integer id) {
        return houseMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateHouse(HouseVo houseVo,boolean isCul) {
        House house=houseVo;
        if (!isCul){
            Scc scc=getSccFactor(house.getScccode());
            Double activity=house.getSolventAmount();
            house.setPm25Emission(activity*scc.getPm25());
            house.setPm10Emission(activity*scc.getPm10());
            house.setCoEmission(activity*scc.getCo());
            house.setVocEmission(activity*scc.getVocs());
            house.setSo2Emission(activity*scc.getSo2());
            house.setNoxEmission(activity*scc.getNox());
            house.setNh3Emission(activity*scc.getNh3());
            house.setOcEmission(activity*scc.getOc());
            house.setBcEmission(activity*scc.getBc());
        }
        if(house.getId()!=null){
            houseMapper.updateById(house);
        }else {
            houseMapper.insertSelective(house);
        }
        return 1;
    }

    @Override
    public List<RoadPaveVo> getRoadPasByExample(RoadPaveVo roadPaveVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return roadPaveMapper.selectByExample(roadPaveVo);
    }

    @Override
    public RoadPaveVo getRoadPaById(Integer id) {
        return roadPaveMapper.selectById(id);
    }

    @Override
    public int deleteRoadPaById(Integer id) {
        return roadPaveMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateRoadPa(RoadPaveVo roadPaveVo,boolean isCul) {
        RoadPave roadPave=roadPaveVo;
        if (!isCul){
//            Scc scc=getSccFactor(roadPave.getScccode());
//            Double activity=roadPave.getAsphalt();
//            roadPave.setPm25Emission(activity*scc.getPm25());
//            roadPave.setPm10Emission(activity*scc.getPm10());
//            roadPave.setCoEmission(activity*scc.getCo());
//            roadPave.setVocEmission(activity*scc.getVocs());
//            roadPave.setSo2Emission(activity*scc.getSo2());
//            roadPave.setNoxEmission(activity*scc.getNox());
//            roadPave.setNh3Emission(activity*scc.getNh3());
//            roadPave.setOcEmission(activity*scc.getOc());
//            roadPave.setBcEmission(activity*scc.getBc());
        }
        if(roadPave.getId()!=null){
            roadPaveMapper.updateById(roadPave);
        }else {
            roadPaveMapper.insertSelective(roadPave);
        }
        return 1;
    }

    @Override
    public List<XjconstructdustVo> getConsByExample(XjconstructdustVo xjconstructdustVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return xjconstructdustMapper.selectByExample(xjconstructdustVo);
    }

    @Override
    public XjconstructdustVo getConById(Integer id) {
        return xjconstructdustMapper.selectById(id);
    }

    @Override
    public int deleteConById(Integer id) {
        return xjconstructdustMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateCon(XjconstructdustVo xjconstructdustVo,boolean isCul) {
        Xjconstructdust xjconstructdus=xjconstructdustVo;
        if (!isCul){
//            Scc scc=getSccFactor(roadPave.getScccode());
//            Double activity=roadPave.getAsphalt();
//            roadPave.setPm25Emission(activity*scc.getPm25());
//            roadPave.setPm10Emission(activity*scc.getPm10());
//            roadPave.setCoEmission(activity*scc.getCo());
//            roadPave.setVocEmission(activity*scc.getVocs());
//            roadPave.setSo2Emission(activity*scc.getSo2());
//            roadPave.setNoxEmission(activity*scc.getNox());
//            roadPave.setNh3Emission(activity*scc.getNh3());
//            roadPave.setOcEmission(activity*scc.getOc());
//            roadPave.setBcEmission(activity*scc.getBc());
        }
        if(xjconstructdus.getId()!=null){
            xjconstructdustMapper.updateById(xjconstructdus);
        }else {
            xjconstructdustMapper.insertSelective(xjconstructdus);
        }
        return 1;
    }

    @Override
    public List<XjcydustLoadVo> getDustLoadsByExample(XjcydustLoadVo xjcydustLoadVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return xjcydustLoadMapper.selectByExample(xjcydustLoadVo);
    }

    @Override
    public XjcydustLoadVo getDustLoadById(Integer id) {
        return xjcydustLoadMapper.selectById(id);
    }

    @Override
    public int deleteDustLoadById(Integer id) {
        return xjcydustLoadMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateDustLoad(XjcydustLoadVo xjcydustLoadVo,boolean isCul) {
        XjcydustLoad xjcydustLoad=xjcydustLoadVo;
        if (!isCul){
//            Scc scc=getSccFactor(roadPave.getScccode());
//            Double activity=roadPave.getAsphalt();
//            roadPave.setPm25Emission(activity*scc.getPm25());
//            roadPave.setPm10Emission(activity*scc.getPm10());
//            roadPave.setCoEmission(activity*scc.getCo());
//            roadPave.setVocEmission(activity*scc.getVocs());
//            roadPave.setSo2Emission(activity*scc.getSo2());
//            roadPave.setNoxEmission(activity*scc.getNox());
//            roadPave.setNh3Emission(activity*scc.getNh3());
//            roadPave.setOcEmission(activity*scc.getOc());
//            roadPave.setBcEmission(activity*scc.getBc());
        }
        if(xjcydustLoad.getId()!=null){
            xjcydustLoadMapper.updateById(xjcydustLoad);
        }else {
            xjcydustLoadMapper.insertSelective(xjcydustLoad);
        }
        return 1;
    }

    @Override
    public List<XjcydustStackVo> getDustStacksByExample(XjcydustStackVo xjcydustStackVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return xjcydustStackMapper.selectByExample(xjcydustStackVo);
    }

    @Override
    public XjcydustStackVo getDustStackById(Integer id) {
        return xjcydustStackMapper.selectById(id);
    }

    @Override
    public int deleteDustStackById(Integer id) {
        return xjcydustStackMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateDustStack(XjcydustStackVo xjcydustStackVo,boolean isCul) {
        XjcydustStack xjcydustStack=xjcydustStackVo;
        if (!isCul){
//            Scc scc=getSccFactor(roadPave.getScccode());
//            Double activity=roadPave.getAsphalt();
//            roadPave.setPm25Emission(activity*scc.getPm25());
//            roadPave.setPm10Emission(activity*scc.getPm10());
//            roadPave.setCoEmission(activity*scc.getCo());
//            roadPave.setVocEmission(activity*scc.getVocs());
//            roadPave.setSo2Emission(activity*scc.getSo2());
//            roadPave.setNoxEmission(activity*scc.getNox());
//            roadPave.setNh3Emission(activity*scc.getNh3());
//            roadPave.setOcEmission(activity*scc.getOc());
//            roadPave.setBcEmission(activity*scc.getBc());
        }
        if(xjcydustStack.getId()!=null){
            xjcydustStackMapper.updateById(xjcydustStack);
        }else {
            xjcydustStackMapper.insertSelective(xjcydustStack);
        }
        return 1;
    }

    @Override
    public List<XjroaddustVo> getRoadDustsByExample(XjroaddustVo xjroaddustVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return xjroaddustMapper.selectByExample(xjroaddustVo);
    }

    @Override
    public XjroaddustVo getRoadDustById(Integer id) {
        return xjroaddustMapper.selectById(id);
    }

    @Override
    public int deleteRoadDustById(Integer id) {
        return xjroaddustMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateRoadDust(XjroaddustVo xjroaddustVo,boolean isCul) {
        Xjroaddust xjroaddust=xjroaddustVo;
        if (!isCul){
//            Scc scc=getSccFactor(roadPave.getScccode());
//            Double activity=roadPave.getAsphalt();
//            roadPave.setPm25Emission(activity*scc.getPm25());
//            roadPave.setPm10Emission(activity*scc.getPm10());
//            roadPave.setCoEmission(activity*scc.getCo());
//            roadPave.setVocEmission(activity*scc.getVocs());
//            roadPave.setSo2Emission(activity*scc.getSo2());
//            roadPave.setNoxEmission(activity*scc.getNox());
//            roadPave.setNh3Emission(activity*scc.getNh3());
//            roadPave.setOcEmission(activity*scc.getOc());
//            roadPave.setBcEmission(activity*scc.getBc());
        }
        if(xjroaddust.getRdId()!=null){
            xjroaddustMapper.updateById(xjroaddust);
        }else {
            xjroaddustMapper.insertSelective(xjroaddust);
        }
        return 1;
    }

    @Override
    public List<XjsoildustVo> getSoilDustsByExample(XjsoildustVo xjsoildustVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return xjsoildustMapper.selectByExample(xjsoildustVo);
    }

    @Override
    public XjsoildustVo getSoilDustById(Integer id) {
        return xjsoildustMapper.selectById(id);
    }

    @Override
    public int deleteSoilDustById(Integer id) {
        return xjsoildustMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateSoilDust(XjsoildustVo xjsoildustVo,boolean isCul) {
        Xjsoildust xjsoildust=xjsoildustVo;
        if (!isCul){
//            Scc scc=getSccFactor(roadPave.getScccode());
//            Double activity=roadPave.getAsphalt();
//            roadPave.setPm25Emission(activity*scc.getPm25());
//            roadPave.setPm10Emission(activity*scc.getPm10());
//            roadPave.setCoEmission(activity*scc.getCo());
//            roadPave.setVocEmission(activity*scc.getVocs());
//            roadPave.setSo2Emission(activity*scc.getSo2());
//            roadPave.setNoxEmission(activity*scc.getNox());
//            roadPave.setNh3Emission(activity*scc.getNh3());
//            roadPave.setOcEmission(activity*scc.getOc());
//            roadPave.setBcEmission(activity*scc.getBc());
        }
        if(xjsoildust.getSdId()!=null){
            xjsoildustMapper.updateById(xjsoildust);
        }else {
            xjsoildustMapper.insertSelective(xjsoildust);
        }
        return 1;
    }

    @Override
    public List<GasSourceVo> getGassByExample(GasSourceVo gasSourceVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return gasSourceMapper.selectByExample(gasSourceVo);
    }

    @Override
    public GasSourceVo getGasById(Integer id) {
        return gasSourceMapper.selectById(id);
    }

    @Override
    public int deleteGasById(Integer id) {
        return gasSourceMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateGas(GasSourceVo gasSourceVo,boolean isCul) {
        GasSource gasSource=gasSourceVo;
        Company company=gasSource;
        int comId=insertOrUpdateCompany(company);
        gasSource.setCompanyId(comId);
        if (!isCul){
            Scc scc=getSccFactor(gasSource.getScccode());
            Double activity=gasSource.getSalesVolume();
//            gasSource.set(activity*scc.getPm25());
//            gasSource.setPm10Emission(activity*scc.getPm10());
//            gasSource.setCoEmission(activity*scc.getCo());
//            gasSource.setVocEmission(activity*scc.getVocs());
//            gasSource.setSo2Emission(activity*scc.getSo2());
//            gasSource.setNoxEmission(activity*scc.getNox());
//            gasSource.setNh3Emission(activity*scc.getNh3());
//            gasSource.setOcEmission(activity*scc.getOc());
//            gasSource.setBcEmission(activity*scc.getBc());
        }
        if(gasSource.getId()!=null){
            gasSourceMapper.updateById(gasSource);
        }else {
            gasSourceMapper.insertSelective(gasSource);
        }
        return 1;
    }

    @Override
    public List<OilSourceVo> getOilsByExample(OilSourceVo oilSourceVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return oilSourceMapper.selectByExample(oilSourceVo);
    }

    @Override
    public OilSourceVo getOilById(Integer id) {
        return oilSourceMapper.selectById(id);
    }

    @Override
    public int deleteOilById(Integer id) {
        return oilSourceMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateOil(OilSourceVo oilSourceVo,boolean isCul) {
        OilSource oilSource=oilSourceVo;
        Company company=oilSource;
        int comId=insertOrUpdateCompany(company);
        oilSource.setCompanyId(comId);
        if (!isCul){
            Scc scc=getSccFactor(oilSource.getScccode());
            Double activity=oilSource.getSalesVolume();
//            gasSource.set(activity*scc.getPm25());
//            gasSource.setPm10Emission(activity*scc.getPm10());
//            gasSource.setCoEmission(activity*scc.getCo());
//            gasSource.setVocEmission(activity*scc.getVocs());
//            gasSource.setSo2Emission(activity*scc.getSo2());
//            gasSource.setNoxEmission(activity*scc.getNox());
//            gasSource.setNh3Emission(activity*scc.getNh3());
//            gasSource.setOcEmission(activity*scc.getOc());
//            gasSource.setBcEmission(activity*scc.getBc());
        }
        if(oilSource.getId()!=null){
            oilSourceMapper.updateById(oilSource);
        }else {
            oilSourceMapper.insertSelective(oilSource);
        }
        return 1;
    }

    @Override
    public List<OilTransportVo> getOilTransByExample(OilTransportVo oilTransportVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return oilTransportMapper.selectByExample(oilTransportVo);
    }

    @Override
    public OilTransportVo getOilTranById(Integer id) {
        return oilTransportMapper.selectById(id);
    }

    @Override
    public int deleteOilTranById(Integer id) {
        return oilTransportMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateOilTran(OilTransportVo oilTransportVo,boolean isCul) {
        OilTransport oilTransport=oilTransportVo;
        Company company=oilTransport;
        int comId=insertOrUpdateCompany(company);
        oilTransport.setCompanyId(comId);
        if (!isCul){
            Scc scc=getSccFactor(oilTransport.getScccode());
            Double activity=oilTransport.getYearVolume();
//            gasSource.set(activity*scc.getPm25());
//            gasSource.setPm10Emission(activity*scc.getPm10());
//            gasSource.setCoEmission(activity*scc.getCo());
//            gasSource.setVocEmission(activity*scc.getVocs());
//            gasSource.setSo2Emission(activity*scc.getSo2());
//            gasSource.setNoxEmission(activity*scc.getNox());
//            gasSource.setNh3Emission(activity*scc.getNh3());
//            gasSource.setOcEmission(activity*scc.getOc());
//            gasSource.setBcEmission(activity*scc.getBc());
        }
        if(oilTransport.getId()!=null){
            oilTransportMapper.updateById(oilTransport);
        }else {
            oilTransportMapper.insertSelective(oilTransport);
        }
        return 1;
    }

    @Override
    public List<TankSourceVo> getTanksByExample(TankSourceVo tankSourceVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return tankSourceMapper.selectByExample(tankSourceVo);
    }

    @Override
    public TankSourceVo getTankById(Integer id) {
        return tankSourceMapper.selectById(id);
    }

    @Override
    public int deleteTankById(Integer id) {
        return tankSourceMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateTank(TankSourceVo tankSourceVo,boolean isCul) {
        TankSource tankSource=tankSourceVo;
        Company company=tankSource;
        int comId=insertOrUpdateCompany(company);
        tankSource.setCompanyId(comId);
        if (!isCul){
            Scc scc=getSccFactor(tankSource.getScccode());
//            Double activity=tankSource.get();
//            gasSource.set(activity*scc.getPm25());
//            gasSource.setPm10Emission(activity*scc.getPm10());
//            gasSource.setCoEmission(activity*scc.getCo());
//            gasSource.setVocEmission(activity*scc.getVocs());
//            gasSource.setSo2Emission(activity*scc.getSo2());
//            gasSource.setNoxEmission(activity*scc.getNox());
//            gasSource.setNh3Emission(activity*scc.getNh3());
//            gasSource.setOcEmission(activity*scc.getOc());
//            gasSource.setBcEmission(activity*scc.getBc());
        }
        if(tankSource.getId()!=null){
            tankSourceMapper.updateById(tankSource);
        }else {
            tankSourceMapper.insertSelective(tankSource);
        }
        return 1;
    }

    @Override
    public List<BaseSoilVo> getBaseSoilsByExample(BaseSoilVo baseSoilVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return baseSoilMapper.selectByExample(baseSoilVo);
    }

    @Override
    public BaseSoilVo getBaseSoilById(Integer id) {
        return baseSoilMapper.selectById(id);
    }

    @Override
    public int deleteBaseSoilById(Integer id) {
        return baseSoilMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateBaseSoil(BaseSoilVo baseSoilVo,boolean isCul) {
        BaseSoil baseSoil=baseSoilVo;
        if (!isCul){
            Scc scc=getSccFactor(baseSoil.getScccode());
            Double activity=baseSoil.getCultivateArea();
            baseSoil.setPm25Emission(activity*scc.getPm25());
            baseSoil.setPm10Emission(activity*scc.getPm10());
            baseSoil.setCoEmission(activity*scc.getCo());
            baseSoil.setVocEmission(activity*scc.getVocs());
            baseSoil.setSo2Emission(activity*scc.getSo2());
            baseSoil.setNoxEmission(activity*scc.getNox());
            baseSoil.setNh3Emission(activity*scc.getNh3());
            baseSoil.setOcEmission(activity*scc.getOc());
            baseSoil.setBcEmission(activity*scc.getBc());
        }
        if(baseSoil.getId()!=null){
            baseSoilMapper.updateById(baseSoil);
        }else {
            baseSoilMapper.insertSelective(baseSoil);
        }
        return 1;
    }

    @Override
    public List<CollectbreedingVo> getCoBreedsByExample(CollectbreedingVo collectbreedingVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return collectbreedingMapper.selectByExample(collectbreedingVo);
    }

    @Override
    public CollectbreedingVo getCoBreedById(Integer id) {
        return collectbreedingMapper.selectById(id);
    }

    @Override
    public int deleteCoBreedById(Integer id) {
        return collectbreedingMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateCoBreed(CollectbreedingVo collectbreedingVo,boolean isCul) {
        Collectbreeding collectbreeding=collectbreedingVo;
        Company company=collectbreeding;
        int comId=insertOrUpdateCompany(company);
        collectbreeding.setCompanyId(comId);
        if (!isCul){
            Scc scc=getSccFactor(collectbreeding.getScccode());
            Double activity=collectbreeding.getActivityLevel();
            collectbreeding.setPm25Emission(activity*scc.getPm25());
            collectbreeding.setPm10Emission(activity*scc.getPm10());
            collectbreeding.setCoEmission(activity*scc.getCo());
            collectbreeding.setVocEmission(activity*scc.getVocs());
            collectbreeding.setSo2Emission(activity*scc.getSo2());
            collectbreeding.setNoxEmission(activity*scc.getNox());
            collectbreeding.setNh3Emission(activity*scc.getNh3());
            collectbreeding.setOcEmission(activity*scc.getOc());
            collectbreeding.setBcEmission(activity*scc.getBc());
        }
        if(collectbreeding.getId()!=null){
            collectbreedingMapper.updateById(collectbreeding);
        }else {
            collectbreedingMapper.insertSelective(collectbreeding);
        }
        return 1;
    }

    @Override
    public List<FertilizationVo> getFertilsByExample(FertilizationVo fertilizationVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return fertilizationMapper.selectByExample(fertilizationVo);
    }

    @Override
    public FertilizationVo getFertilById(Integer id) {
        return fertilizationMapper.selectById(id);
    }

    @Override
    public int deleteFertilById(Integer id) {
        return fertilizationMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateFertil(FertilizationVo fertilizationVo,boolean isCul) {
        Fertilization fertilization=fertilizationVo;
        if (!isCul){
            Scc scc=getSccFactor(fertilization.getScccode());
            Double activity=fertilization.getActivityLevel();
            fertilization.setPm25Emission(activity*scc.getPm25());
            fertilization.setPm10Emission(activity*scc.getPm10());
            fertilization.setCoEmission(activity*scc.getCo());
            fertilization.setVocEmission(activity*scc.getVocs());
            fertilization.setSo2Emission(activity*scc.getSo2());
            fertilization.setNoxEmission(activity*scc.getNox());
            fertilization.setNh3Emission(activity*scc.getNh3());
            fertilization.setOcEmission(activity*scc.getOc());
            fertilization.setBcEmission(activity*scc.getBc());
        }
        if(fertilization.getId()!=null){
            fertilizationMapper.updateById(fertilization);
        }else {
            fertilizationMapper.insertSelective(fertilization);
        }
        return 1;
    }

    @Override
    public List<FreeStockbreedingVo> getFreeStocksByExample(FreeStockbreedingVo freeStockbreedingVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return freeStockbreedingMapper.selectByExample(freeStockbreedingVo);
    }

    @Override
    public FreeStockbreedingVo getFreeStockById(Integer id) {
        return freeStockbreedingMapper.selectById(id);
    }

    @Override
    public int deleteFreeStockById(Integer id) {
        return freeStockbreedingMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateFreeStock(FreeStockbreedingVo freeStockbreedingVo,boolean isCul) {
        FreeStockbreeding fertilizationVo=freeStockbreedingVo;
        if (!isCul){
            Scc scc=getSccFactor(fertilizationVo.getScccode());
            Double activity=fertilizationVo.getActivityLevel();
            fertilizationVo.setPm25Emission(activity*scc.getPm25());
            fertilizationVo.setPm10Emission(activity*scc.getPm10());
            fertilizationVo.setCoEmission(activity*scc.getCo());
            fertilizationVo.setVocEmission(activity*scc.getVocs());
            fertilizationVo.setSo2Emission(activity*scc.getSo2());
            fertilizationVo.setNoxEmission(activity*scc.getNox());
            fertilizationVo.setNh3Emission(activity*scc.getNh3());
            fertilizationVo.setOcEmission(activity*scc.getOc());
            fertilizationVo.setBcEmission(activity*scc.getBc());
        }
        if(fertilizationVo.getId()!=null){
            freeStockbreedingMapper.updateById(fertilizationVo);
        }else {
            freeStockbreedingMapper.insertSelective(fertilizationVo);
        }
        return 1;
    }

    @Override
    public List<NPlantVo> getNPlantsByExample(NPlantVo nPlantVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return nPlantMapper.selectByExample(nPlantVo);
    }

    @Override
    public NPlantVo getNPlantById(Integer id) {
        return nPlantMapper.selectById(id);
    }

    @Override
    public int deleteNPlantById(Integer id) {
        return nPlantMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateNPlant(NPlantVo nPlantVo,boolean isCul) {
        NPlant nPlant=nPlantVo;
        if (!isCul){
            Scc scc=getSccFactor(nPlant.getScccode());
            Double activity=nPlant.getPlantArea();
            nPlant.setPm25Emission(activity*scc.getPm25());
            nPlant.setPm10Emission(activity*scc.getPm10());
            nPlant.setCoEmission(activity*scc.getCo());
            nPlant.setVocEmission(activity*scc.getVocs());
            nPlant.setSo2Emission(activity*scc.getSo2());
            nPlant.setNoxEmission(activity*scc.getNox());
            nPlant.setNh3Emission(activity*scc.getNh3());
            nPlant.setOcEmission(activity*scc.getOc());
            nPlant.setBcEmission(activity*scc.getBc());
        }
        if(nPlant.getId()!=null){
            nPlantMapper.updateById(nPlant);
        }else {
            nPlantMapper.insertSelective(nPlant);
        }
        return 1;
    }

    @Override
    public List<PesticideVo> getPesticidesByExample(PesticideVo pesticideVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return pesticideMapper.selectByExample(pesticideVo);
    }

    @Override
    public PesticideVo getPesticideById(Integer id) {
        return pesticideMapper.selectById(id);
    }

    @Override
    public int deletePesticideById(Integer id) {
        return pesticideMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdatePesticide(PesticideVo pesticideVo,boolean isCul) {
        Pesticide pesticide=pesticideVo;
        if (!isCul){
            Scc scc=getSccFactor(pesticide.getScccode());
            Double activity=pesticide.getPesticideamount();
            pesticide.setPm25Emission(activity*scc.getPm25());
            pesticide.setPm10Emission(activity*scc.getPm10());
            pesticide.setCoEmission(activity*scc.getCo());
            pesticide.setVocEmission(activity*scc.getVocs());
            pesticide.setSo2Emission(activity*scc.getSo2());
            pesticide.setNoxEmission(activity*scc.getNox());
            pesticide.setNh3Emission(activity*scc.getNh3());
            pesticide.setOcEmission(activity*scc.getOc());
            pesticide.setBcEmission(activity*scc.getBc());
        }
        if(pesticide.getId()!=null){
            pesticideMapper.updateById(pesticide);
        }else {
            pesticideMapper.insertSelective(pesticide);
        }
        return 1;
    }

    @Override
    public List<StrawCompostVo> getStrawCompostsByExample(StrawCompostVo strawCompostVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return strawCompostMapper.selectByExample(strawCompostVo);
    }

    @Override
    public StrawCompostVo getStrawCompostById(Integer id) {
        return strawCompostMapper.selectById(id);
    }

    @Override
    public int deleteStrawCompostById(Integer id) {
        return strawCompostMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateStrawCompost(StrawCompostVo strawCompostVo,boolean isCul) {
        StrawCompost strawCompost=strawCompostVo;
        if (!isCul){
            Scc scc=getSccFactor(strawCompost.getScccode());
            Double activity=strawCompost.getActivityLevel();
            strawCompost.setPm25Emission(activity*scc.getPm25());
            strawCompost.setPm10Emission(activity*scc.getPm10());
            strawCompost.setCoEmission(activity*scc.getCo());
            strawCompost.setVocEmission(activity*scc.getVocs());
            strawCompost.setSo2Emission(activity*scc.getSo2());
            strawCompost.setNoxEmission(activity*scc.getNox());
            strawCompost.setNh3Emission(activity*scc.getNh3());
            strawCompost.setOcEmission(activity*scc.getOc());
            strawCompost.setBcEmission(activity*scc.getBc());
        }
        if(strawCompost.getId()!=null){
            strawCompostMapper.updateById(strawCompost);
        }else {
            strawCompostMapper.insertSelective(strawCompost);
        }
        return 1;
    }

    @Override
    public List<BiomassBoilerVo> getBioBoilersByExample(BiomassBoilerVo biomassBoilerVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return biomassBoilerMapper.selectByExample(biomassBoilerVo);
    }

    @Override
    public BiomassBoilerVo getBioBoilerById(Integer id) {
        return biomassBoilerMapper.selectById(id);
    }

    @Override
    public int deleteBioBoilerById(Integer id) {
        return biomassBoilerMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateBioBoiler(BiomassBoilerVo biomassBoilerVo,boolean isCul) {
        BiomassBoiler biomassBoiler=biomassBoilerVo;
        Company company=biomassBoiler;
        int comId=insertOrUpdateCompany(company);
        biomassBoiler.setComId(comId);
        if (!isCul){
            Scc scc=getSccFactor(biomassBoiler.getSccCode());
            Double activity=biomassBoiler.getFuelConsumption();
            biomassBoiler.setPm25Emission(activity*scc.getPm25());
            biomassBoiler.setPm10Emission(activity*scc.getPm10());
            biomassBoiler.setCoEmission(activity*scc.getCo());
            biomassBoiler.setVocEmission(activity*scc.getVocs());
            biomassBoiler.setSo2Emission(activity*scc.getSo2());
            biomassBoiler.setNoxEmission(activity*scc.getNox());
            biomassBoiler.setNh3Emission(activity*scc.getNh3());
            biomassBoiler.setOcEmission(activity*scc.getOc());
            biomassBoiler.setBcEmission(activity*scc.getBc());
        }
        if(biomassBoiler.getId()!=null){
            biomassBoilerMapper.updateById(biomassBoiler);
        }else {
            biomassBoilerMapper.insertSelective(biomassBoiler);
        }
        return 1;
    }

    @Override
    public List<BiomassForestGrasslandVo> getBioForestsByExample(BiomassForestGrasslandVo biomassForestGrasslandVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return biomassForestGrasslandMapper.selectByExample(biomassForestGrasslandVo);
    }

    @Override
    public BiomassForestGrasslandVo getBioForestById(Integer id) {
        return biomassForestGrasslandMapper.selectById(id);
    }

    @Override
    public int deleteBioForestById(Integer id) {
        return biomassForestGrasslandMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateBioForest(BiomassForestGrasslandVo biomassForestGrasslandVo,boolean isCul) {
        BiomassForestGrassland biomassForestGrassland=biomassForestGrasslandVo;
        if (!isCul){
            Scc scc=getSccFactor(biomassForestGrassland.getSccCode());
            Double activity=biomassForestGrassland.getFireArea();
            biomassForestGrassland.setPm25Emission(activity*scc.getPm25());
            biomassForestGrassland.setPm10Emission(activity*scc.getPm10());
            biomassForestGrassland.setCoEmission(activity*scc.getCo());
            biomassForestGrassland.setVocEmission(activity*scc.getVocs());
            biomassForestGrassland.setSo2Emission(activity*scc.getSo2());
            biomassForestGrassland.setNoxEmission(activity*scc.getNox());
            biomassForestGrassland.setNh3Emission(activity*scc.getNh3());
            biomassForestGrassland.setOcEmission(activity*scc.getOc());
            biomassForestGrassland.setBcEmission(activity*scc.getBc());
        }
        if(biomassForestGrassland.getId()!=null){
            biomassForestGrasslandMapper.updateById(biomassForestGrassland);
        }else {
            biomassForestGrasslandMapper.insertSelective(biomassForestGrassland);
        }
        return 1;
    }

    @Override
    public List<BiomassStoveVo> getBioStovesByExample(BiomassStoveVo biomassStoveVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return biomassStoveMapper.selectByExample(biomassStoveVo);
    }

    @Override
    public BiomassStoveVo getBioStoveById(Integer id) {
        return biomassStoveMapper.selectById(id);
    }

    @Override
    public int deleteBioStoveById(Integer id) {
        return biomassStoveMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateBioStove(BiomassStoveVo biomassStoveVo,boolean isCul) {
        BiomassStove biomassStove=biomassStoveVo;
        if (!isCul){
            Scc scc=getSccFactor(biomassStove.getSccCode());
            Double activity=biomassStove.getCropYield();
            biomassStove.setPm25Emission(activity*scc.getPm25());
            biomassStove.setPm10Emission(activity*scc.getPm10());
            biomassStove.setCoEmission(activity*scc.getCo());
            biomassStove.setVocEmission(activity*scc.getVocs());
            biomassStove.setSo2Emission(activity*scc.getSo2());
            biomassStove.setNoxEmission(activity*scc.getNox());
            biomassStove.setNh3Emission(activity*scc.getNh3());
            biomassStove.setOcEmission(activity*scc.getOc());
            biomassStove.setBcEmission(activity*scc.getBc());
        }
        if(biomassStove.getId()!=null){
            biomassStoveMapper.updateById(biomassStove);
        }else {
            biomassStoveMapper.insertSelective(biomassStove);
        }
        return 1;
    }

    @Override
    public List<BiomassStrawVo> getBioStrawsByExample(BiomassStrawVo biomassStrawVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return biomassStrawMapper.selectByExample(biomassStrawVo);
    }

    @Override
    public BiomassStrawVo getBioStrawById(Integer id) {
        return biomassStrawMapper.selectById(id);
    }

    @Override
    public int deleteBioStrawById(Integer id) {
        return biomassStrawMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateBioStraw(BiomassStrawVo biomassStrawVo,boolean isCul) {
        BiomassStraw biomassStraw=biomassStrawVo;
        if (!isCul){
            Scc scc=getSccFactor(biomassStraw.getSccCode());
            Double activity=biomassStraw.getCropsOutput();
            biomassStraw.setPm25Emission(activity*scc.getPm25());
            biomassStraw.setPm10Emission(activity*scc.getPm10());
            biomassStraw.setCoEmission(activity*scc.getCo());
            biomassStraw.setVocEmission(activity*scc.getVocs());
            biomassStraw.setSo2Emission(activity*scc.getSo2());
            biomassStraw.setNoxEmission(activity*scc.getNox());
            biomassStraw.setNh3Emission(activity*scc.getNh3());
            biomassStraw.setOcEmission(activity*scc.getOc());
            biomassStraw.setBcEmission(activity*scc.getBc());
        }
        if(biomassStraw.getId()!=null){
            biomassStrawMapper.updateById(biomassStraw);
        }else {
            biomassStrawMapper.insertSelective(biomassStraw);
        }
        return 1;
    }

    @Override
    public List<RoadMoveVo> getRoadMovesByExample(RoadMoveVo roadMoveVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return roadMoveMapper.selectByExample(roadMoveVo);
    }

    @Override
    public RoadMoveVo getRoadMoveById(Integer id) {
        return roadMoveMapper.selectById(id);
    }

    @Override
    public int deleteRoadMoveById(Integer id) {
        return roadMoveMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateRoadMove(RoadMoveVo roadMoveVo,boolean isCul) {
        RoadMove roadMove=roadMoveVo;
        if (!isCul){
//            Scc scc=getSccFactor(roadMove.getScccode());
//            Double activity=roadMove.get();
//            roadMove.setPm25Emission(activity*scc.getPm25());
//            roadMove.setPm10Emission(activity*scc.getPm10());
//            roadMove.setCoEmission(activity*scc.getCo());
//            roadMove.setVocEmission(activity*scc.getVocs());
//            roadMove.setSo2Emission(activity*scc.getSo2());
//            roadMove.setNoxEmission(activity*scc.getNox());
//            roadMove.setNh3Emission(activity*scc.getNh3());
//            roadMove.setOcEmission(activity*scc.getOc());
//            roadMove.setBcEmission(activity*scc.getBc());
        }
        if(roadMove.getId()!=null){
            roadMoveMapper.updateById(roadMove);
        }else {
            roadMoveMapper.insertSelective(roadMove);
        }
        return 1;
    }
    @Override
    public List<RepastBarbecueVo> getRepastsBarbecuesByExample(RepastBarbecueVo repastBarbecueVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return repastBarbecueMapper.selectByExample(repastBarbecueVo);
    }

    @Override
    public RepastBarbecueVo getRepastBarbecueById(Integer id) {
        return repastBarbecueMapper.selectById(id);
    }

    @Override
    public int deleteRepastBarbecueById(Integer id) {
        return repastBarbecueMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateRepastBarbecue(RepastBarbecueVo repastBarbecueVo,boolean isCul) {
        RepastBarbecue repastBarbecue=repastBarbecueVo;
        Company company=repastBarbecue;
        int comId=insertOrUpdateCompany(company);
        repastBarbecue.setComId(comId);
        if (!isCul){
            Scc scc=getSccFactor(repastBarbecue.getScccode());
            Double activity=repastBarbecue.getCoalConsumption();
            repastBarbecue.setPm25Emission(activity*scc.getPm25());
            repastBarbecue.setPm10Emission(activity*scc.getPm10());
            repastBarbecue.setCoEmission(activity*scc.getCo());
            repastBarbecue.setVocEmission(activity*scc.getVocs());
            repastBarbecue.setSo2Emission(activity*scc.getSo2());
            repastBarbecue.setNoxEmission(activity*scc.getNox());
            repastBarbecue.setNh3Emission(activity*scc.getNh3());
            repastBarbecue.setOcEmission(activity*scc.getOc());
            repastBarbecue.setBcEmission(activity*scc.getBc());
        }
        if(repastBarbecue.getId()!=null){
            repastBarbecueMapper.updateById(repastBarbecue);
        }else {
            repastBarbecueMapper.insertSelective(repastBarbecue);
        }
        return 1;
    }

    @Override
    public List<RepastFamilyVo> getRepastFamilysByExample(RepastFamilyVo repastFamilyVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return repastFamilyMapper.selectByExample(repastFamilyVo);
    }

    @Override
    public RepastFamilyVo getRepastFamilyById(Integer id) {
        return repastFamilyMapper.selectById(id);
    }

    @Override
    public int deleteRepastFamilyById(Integer id) {
        return repastFamilyMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateRepastFamily(RepastFamilyVo repastFamilyVo,boolean isCul) {
        RepastFamily repastFamily=repastFamilyVo;
        if (!isCul){
            Scc scc=getSccFactor(repastFamily.getScccode());
            Double activity=repastFamily.getGasConsumption();
            repastFamily.setPm25Emission(activity*scc.getPm25());
            repastFamily.setPm10Emission(activity*scc.getPm10());
            repastFamily.setCoEmission(activity*scc.getCo());
            repastFamily.setVocEmission(activity*scc.getVocs());
            repastFamily.setSo2Emission(activity*scc.getSo2());
            repastFamily.setNoxEmission(activity*scc.getNox());
            repastFamily.setNh3Emission(activity*scc.getNh3());
            repastFamily.setOcEmission(activity*scc.getOc());
            repastFamily.setBcEmission(activity*scc.getBc());
        }
        if(repastFamily.getId()!=null){
            repastFamilyMapper.updateById(repastFamily);
        }else {
            repastFamilyMapper.insertSelective(repastFamily);
        }
        return 1;
    }

    @Override
    public List<RepastVo> getRepastsByExample(RepastVo repastVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return repastMapper.selectByExample(repastVo);
    }

    @Override
    public RepastVo getRepastById(Integer id) {
        return repastMapper.selectById(id);
    }

    @Override
    public int deleteRepastById(Integer id) {
        return repastMapper.deleteById(id);
    }

    @Override
    public int insertOrUpdateRepast(RepastVo repastVo,boolean isCul) {
        Repast repast=repastVo;
        Company company=repast;
        int comId=insertOrUpdateCompany(company);
        repast.setComId(comId);
        if (!isCul){
            Scc scc=getSccFactor(repast.getScccode());
            Double activity=repast.getCoalConsumption();
            repast.setPm25Emission(activity*scc.getPm25());
            repast.setPm10Emission(activity*scc.getPm10());
            repast.setCoEmission(activity*scc.getCo());
            repast.setVocEmission(activity*scc.getVocs());
            repast.setSo2Emission(activity*scc.getSo2());
            repast.setNoxEmission(activity*scc.getNox());
            repast.setNh3Emission(activity*scc.getNh3());
            repast.setOcEmission(activity*scc.getOc());
            repast.setBcEmission(activity*scc.getBc());
        }
        if(repast.getId()!=null){
            repastMapper.updateById(repast);
        }else {
            repastMapper.insertSelective(repast);
        }
        return 1;
    }

    public int insertOrUpdateCompany(Company company){
        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            Company co=companyMapper.selectByFullName(company.getCompanyName());
            if (co!=null){
                throw new DuplicateNameException("企业已存在！");
            }else{
                companyMapper.insertSelective(company);
            }
        }
        return company.getComId();
    }
    public Scc getSccFactor(String sccCode){
        Scc scc=sccMapper.selectByScc(sccCode);
        if (scc==null){
            throw new NullPointerException("无对应SCC因子表，请自己填写污染物排放量！");
        }
        return scc;
    }
}
