package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;
import nankai.xl.business.service.SourceService;
import nankai.xl.common.util.ClassUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    private SccMapper sccMapper;
    @Resource
    private CompanyMapper companyMapper;

    @Override
    public int insertOrUpdateScatteredCoal(ScatteredCoalVo scatteredCoalVo,boolean isCul) {
        ScatteredCoal scatteredCoal=scatteredCoalVo;
        if (!isCul){
            Scc scc=sccMapper.selectByScc(scatteredCoal.getSccCode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            shGasemission.setFactoryId(company.getComId());
        }
        if (!isCul){
            Scc scc=sccMapper.selectByScc(shGasemission.getScccode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            shSealpoint.setFactoryId(company.getComId());
        }
        if (!isCul){
            Scc scc=sccMapper.selectByScc(shSealpoint.getScccode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            shEffluentemission.setFactoryId(company.getComId());
        }

        if (!isCul){
            Scc scc=sccMapper.selectByScc(shEffluentemission.getScccode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            shVocdeviceeffi.setFactoryId(company.getComId());
        }

        if (!isCul){
            Scc scc=sccMapper.selectByScc(shVocdeviceeffi.getScccode());
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
            Scc scc=sccMapper.selectByScc(buildingSmear.getScccode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            carRepair.setCompanyId(company.getComId());
        }

        if (!isCul){
            Scc scc=sccMapper.selectByScc(carRepair.getScccode());
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
            Scc scc=sccMapper.selectByScc(deoil.getScccode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            dryCleaner.setCompanyId(company.getComId());
        }

        if (!isCul){
            Scc scc=sccMapper.selectByScc(dryCleaner.getScccode());
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
            Scc scc=sccMapper.selectByScc(house.getScccode());
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
//            Scc scc=sccMapper.selectByScc(roadPave.getScccode());
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
    public int updateConById(Xjconstructdust xjconstructdust) {
        return xjconstructdustMapper.updateById(xjconstructdust);
    }

    @Override
    public int insertOrUpdateCon(Xjconstructdust xjconstructdust) {
        return xjconstructdustMapper.insertOrUpdate(xjconstructdust);
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
    public int updateDustLoadById(XjcydustLoad xjcydustLoad) {
        return xjcydustLoadMapper.updateById(xjcydustLoad);
    }

    @Override
    public int insertOrUpdateDustLoad(XjcydustLoad xjcydustLoad) {
        return xjcydustLoadMapper.insertOrUpdate(xjcydustLoad);
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
    public int updateDustStackById(XjcydustStack xjcydustStack) {
        return xjcydustStackMapper.updateById(xjcydustStack);
    }

    @Override
    public int insertOrUpdateDustStack(XjcydustStack xjcydustStack) {
        return xjcydustStackMapper.insertOrUpdate(xjcydustStack);
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
    public int updateRoadDustById(Xjroaddust xjroaddust) {
        return xjroaddustMapper.updateById(xjroaddust);
    }

    @Override
    public int insertOrUpdateRoadDust(Xjroaddust xjroaddust) {
        return xjroaddustMapper.insertOrUpdate(xjroaddust);
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
    public int updateSoilDustById(Xjsoildust xjsoildust) {
        return xjsoildustMapper.updateById(xjsoildust);
    }

    @Override
    public int insertOrUpdateSoilDust(Xjsoildust xjsoildust) {
        return xjsoildustMapper.insertOrUpdate(xjsoildust);
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            gasSource.setCompanyId(company.getComId());
        }

        if (!isCul){
            Scc scc=sccMapper.selectByScc(gasSource.getScccode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            oilSource.setCompanyId(company.getComId());
        }

        if (!isCul){
            Scc scc=sccMapper.selectByScc(oilSource.getScccode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            oilTransport.setCompanyId(company.getComId());
        }

        if (!isCul){
            Scc scc=sccMapper.selectByScc(oilTransport.getScccode());
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

        if(company.getComId()!=null){
            companyMapper.updateById(company);
        }else {
            companyMapper.insertSelective(company);
            tankSource.setCompanyId(company.getComId());
        }

        if (!isCul){
            Scc scc=sccMapper.selectByScc(tankSource.getScccode());
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
    public int updateBaseSoilById(BaseSoil baseSoil) {
        return baseSoilMapper.updateById(baseSoil);
    }

    @Override
    public int insertOrUpdateBaseSoil(BaseSoil baseSoil) {
        return baseSoilMapper.insertOrUpdate(baseSoil);
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
    public int updateCoBreedById(Collectbreeding collectbreeding) {
        return collectbreedingMapper.updateById(collectbreeding);
    }

    @Override
    public int insertOrUpdateCoBreed(Collectbreeding collectbreeding) {
        return collectbreedingMapper.insertOrUpdate(collectbreeding);
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
    public int updateFertilById(Fertilization fertilization) {
        return fertilizationMapper.updateById(fertilization);
    }

    @Override
    public int insertOrUpdateFertil(Fertilization fertilization) {
        return fertilizationMapper.insertOrUpdate(fertilization);
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
    public int updateFreeStockById(FreeStockbreeding freeStockbreeding) {
        return freeStockbreedingMapper.updateById(freeStockbreeding);
    }

    @Override
    public int insertOrUpdateFreeStock(FreeStockbreeding freeStockbreeding) {
        return freeStockbreedingMapper.insertOrUpdate(freeStockbreeding);
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
    public int updateNPlantById(NPlant nPlant) {
        return nPlantMapper.updateById(nPlant);
    }

    @Override
    public int insertOrUpdateNPlant(NPlant nPlant) {
        return nPlantMapper.insertOrUpdate(nPlant);
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
    public int updatePesticideById(Pesticide pesticide) {
        return pesticideMapper.updateById(pesticide);
    }

    @Override
    public int insertOrUpdatePesticide(Pesticide pesticide) {
        return pesticideMapper.insertOrUpdate(pesticide);
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
    public int updateStrawCompostById(StrawCompost strawCompost) {
        return strawCompostMapper.updateById(strawCompost);
    }

    @Override
    public int insertOrUpdateStrawCompost(StrawCompost strawCompost) {
        return strawCompostMapper.insertOrUpdate(strawCompost);
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
    public int updateBioBoilerById(BiomassBoiler biomassBoiler) {
        return biomassBoilerMapper.updateById(biomassBoiler);
    }

    @Override
    public int insertOrUpdateBioBoiler(BiomassBoiler biomassBoiler) {
        return biomassBoilerMapper.insertOrUpdate(biomassBoiler);
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
    public int updateBioForestById(BiomassForestGrassland biomassForestGrassland) {
        return biomassForestGrasslandMapper.updateById(biomassForestGrassland);
    }

    @Override
    public int insertOrUpdateBioForest(BiomassForestGrassland biomassForestGrassland) {
        return biomassForestGrasslandMapper.insertOrUpdate(biomassForestGrassland);
    }

    @Override
    public List<BiomassStoveVo> getStovesByExample(BiomassStoveVo biomassStoveVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return biomassStoveMapper.selectByExample(biomassStoveVo);
    }

    @Override
    public BiomassStoveVo getStoveById(Integer id) {
        return biomassStoveMapper.selectById(id);
    }

    @Override
    public int deleteStoveById(Integer id) {
        return biomassStoveMapper.deleteById(id);
    }

    @Override
    public int updateStoveById(BiomassStove biomassStove) {
        return biomassStoveMapper.updateById(biomassStove);
    }

    @Override
    public int insertOrUpdateStove(BiomassStove biomassStove) {
        return biomassStoveMapper.insertOrUpdate(biomassStove);
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
    public int updateBioStrawById(BiomassStraw biomassStraw) {
        return biomassStrawMapper.updateById(biomassStraw);
    }

    @Override
    public int insertOrUpdateBioStraw(BiomassStraw biomassStraw) {
        return biomassStrawMapper.insertOrUpdate(biomassStraw);
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
    public int updateRoadMoveById(RoadMove roadMove) {
        return roadMoveMapper.updateById(roadMove);
    }

    @Override
    public int insertOrUpdateRoadMove(RoadMove roadMove) {
        return roadMoveMapper.insertOrUpdate(roadMove);
    }
}
