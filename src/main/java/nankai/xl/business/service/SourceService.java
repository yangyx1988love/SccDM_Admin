package nankai.xl.business.service;

import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;

import java.util.List;

public interface SourceService {
    //散煤
    int insertOrUpdateScatteredCoal(ScatteredCoal scatteredCoal);
    List<ScatteredCoalVo> getByScatteredCoals(ScatteredCoal scatteredCoal,int page, int limit);
    List<ScatteredCoalVo> getAllScatteredCoals(int page, int limit);
    ScatteredCoalVo getScatById(Integer id);
    int deleteScatById(Integer id);
    //石化有组织废气排放
    int insertOrUpdateShGa(ShGasemission shGasemission);
    List<ShGasemissionVo> getShGasByShGas(ShGasemissionVo shGasemissionVo,int page, int limit);
    List<ShGasemissionVo> getAllShGas(int page, int limit);
    ShGasemissionVo getShGaById(Integer id);
    int deleteShGaById(Integer id);
    int updateShGaById(ShGasemission shGasemission);
    //装置密封点
    List<ShSealpointVo> getShSealsByExample(ShSealpointVo shSealpointVo,int page, int limit);
    ShSealpointVo getShSealById(Integer id);
    int deleteShSealById(Integer id);
    int updateShSealById(ShSealpoint shSealpoint);
    int insertOrUpdateShSeal(ShSealpoint shSealpoint);
    //废水无组织排放
    List<ShEffluentemissionVo> getShEffsByExample(ShEffluentemissionVo shEffluentemissionVo,int page, int limit);
    ShEffluentemissionVo getShEffById(Integer id);
    int deleteShEffById(Integer id);
    int updateShEffById(ShEffluentemission shEffluentemission);
    int insertOrUpdateShEff(ShEffluentemission shEffluentemission);
    //VOC处理装置
    List<ShVocdeviceeffiVo> getShVocsByExample(ShVocdeviceeffiVo shVocdeviceeffiVo,int page, int limit);
    ShVocdeviceeffiVo getShVocById(Integer id);
    int deleteShVocById(Integer id);
    int updateShVocById(ShVocdeviceeffi shVocdeviceeffi);
    int insertOrUpdateShVoc(ShVocdeviceeffi shVocdeviceeffi);
    //建筑涂装二手房
    List<BuildingSmearVo> getBuildsByExample(BuildingSmearVo buildingSmearVo,int page, int limit);
    BuildingSmearVo getBuildById(Integer id);
    int deleteBuildById(Integer id);
    int updateBuildById(BuildingSmear buildingSmear);
    int insertOrUpdateBuild(BuildingSmear buildingSmear);
    //汽修厂
    List<CarRepairVo> getCarsByExample(CarRepairVo carRepairVo,int page, int limit);
    CarRepairVo getCarById(Integer id);
    int deleteCarById(Integer id);
    int updateCarById(CarRepair carRepair);
    int insertOrUpdateCar(CarRepair carRepair);
    //去污油脂
    List<DeoilVo> getDeoilsByExample(DeoilVo deoilVo,int page, int limit);
    DeoilVo getDeoilById(Integer id);
    int deleteDeoilById(Integer id);
    int updateDeoilById(Deoil deoil);
    int insertOrUpdateDeoil(Deoil deoil);
    //干洗店
    List<DryCleanerVo> getDrysByExample(DryCleanerVo dryCleanerVo,int page, int limit);
    DryCleanerVo getDryById(Integer id);
    int deleteDryById(Integer id);
    int updateDryById(DryCleaner dryCleaner);
    int insertOrUpdateDry(DryCleaner dryCleaner);
    //家居家装
    List<HouseVo> getHousesByExample(HouseVo houseVo,int page, int limit);
    HouseVo getHouseById(Integer id);
    int deleteHouseById(Integer id);
    int updateHouseById(House house);
    int insertOrUpdateHouse(House house);
    //道路铺装
    List<RoadPaveVo> getRoadPasByExample(RoadPaveVo roadPaveVo,int page, int limit);
    RoadPaveVo getRoadPaById(Integer id);
    int deleteRoadPaById(Integer id);
    int updateRoadPaById(RoadPave roadPave);
    int insertOrUpdateRoadPa(RoadPave roadPave);
    //施工扬尘源
    List<XjconstructdustVo> getConsByExample(XjconstructdustVo xjconstructdustVo,int page, int limit);
    XjconstructdustVo getConById(Integer id);
    int deleteConById(Integer id);
    int updateConById(Xjconstructdust xjconstructdust);
    int insertOrUpdateCon(Xjconstructdust xjconstructdust);
    //堆场装卸扬尘源
    List<XjcydustLoadVo> getDustLoadsByExample(XjcydustLoadVo xjcydustLoadVo,int page, int limit);
    XjcydustLoadVo getDustLoadById(Integer id);
    int deleteDustLoadById(Integer id);
    int updateDustLoadById(XjcydustLoad xjcydustLoad);
    int insertOrUpdateDustLoad(XjcydustLoad xjcydustLoad);
    //堆场风蚀扬尘源
    List<XjcydustStackVo> getDustStacksByExample(XjcydustStackVo xjcydustStackVo,int page, int limit);
    XjcydustStackVo getDustStackById(Integer id);
    int deleteDustStackById(Integer id);
    int updateDustStackById(XjcydustStack xjcydustStack);
    int insertOrUpdateDustStack(XjcydustStack xjcydustStack);
    //道路扬尘源
    List<XjroaddustVo> getRoadDustsByExample(XjroaddustVo xjroaddustVo,int page, int limit);
    XjroaddustVo getRoadDustById(Integer id);
    int deleteRoadDustById(Integer id);
    int updateRoadDustById(Xjroaddust xjroaddust);
    int insertOrUpdateRoadDust(Xjroaddust xjroaddust);
    //土壤扬尘源
    List<XjsoildustVo> getSoilDustsByExample(XjsoildustVo xjsoildustVo,int page, int limit);
    XjsoildustVo getSoilDustById(Integer id);
    int deleteSoilDustById(Integer id);
    int updateSoilDustById(Xjsoildust xjsoildust);
    int insertOrUpdateSoilDust(Xjsoildust xjsoildust);
    //加气站
    List<GasSourceVo> getGassByExample(GasSourceVo gasSourceVo,int page, int limit);
    GasSourceVo getGasById(Integer id);
    int deleteGasById(Integer id);
    int updateGasById(GasSource gasSource);
    int insertOrUpdateGas(GasSource gasSource);
    //加油站
    List<OilSourceVo> getOilsByExample(OilSourceVo oilSourceVo,int page, int limit);
    OilSourceVo getOilById(Integer id);
    int deleteOilById(Integer id);
    int updateOilById(OilSource oilSource);
    int insertOrUpdateOil(OilSource oilSource);
    //装载过程排放
    List<OilTransportVo> getOilTransByExample(OilTransportVo oilTransportVo,int page, int limit);
    OilTransportVo getOilTranById(Integer id);
    int deleteOilTranById(Integer id);
    int updateOilTranById(OilTransport oilTransport);
    int insertOrUpdateOilTran(OilTransport oilTransport);
    //储罐存储
    List<TankSourceVo> getTanksByExample(TankSourceVo tankSourceVo,int page, int limit);
    TankSourceVo getTankById(Integer id);
    int deleteTankById(Integer id);
    int updateTankById(TankSource tankSource);
    int insertOrUpdateTank(TankSource tankSource);
    //土壤本底
    List<BaseSoilVo> getBaseSoilsByExample(BaseSoilVo baseSoilVo,int page, int limit);
    BaseSoilVo getBaseSoilById(Integer id);
    int deleteBaseSoilById(Integer id);
    int updateBaseSoilById(BaseSoil baseSoil);
    int insertOrUpdateBaseSoil(BaseSoil baseSoil);
    //畜禽集约化养殖
    List<CollectbreedingVo> getCoBreedsByExample(CollectbreedingVo collectbreedingVo,int page, int limit);
    CollectbreedingVo getCoBreedById(Integer id);
    int deleteCoBreedById(Integer id);
    int updateCoBreedById(Collectbreeding collectbreeding);
    int insertOrUpdateCoBreed(Collectbreeding collectbreeding);
    //农肥施用源
    List<FertilizationVo> getFertilsByExample(FertilizationVo fertilizationVo,int page, int limit);
    FertilizationVo getFertilById(Integer id);
    int deleteFertilById(Integer id);
    int updateFertilById(Fertilization fertilization);
    int insertOrUpdateFertil(Fertilization fertilization);
    //畜牧散养源
    List<FreeStockbreedingVo> getFreeStocksByExample(FreeStockbreedingVo freeStockbreedingVo,int page, int limit);
    FreeStockbreedingVo getFreeStockById(Integer id);
    int deleteFreeStockById(Integer id);
    int updateFreeStockById(FreeStockbreeding freeStockbreeding);
    int insertOrUpdateFreeStock(FreeStockbreeding freeStockbreeding);
    //固氮植物源
    List<NPlantVo> getNPlantsByExample(NPlantVo nPlantVo,int page, int limit);
    NPlantVo getNPlantById(Integer id);
    int deleteNPlantById(Integer id);
    int updateNPlantById(NPlant nPlant);
    int insertOrUpdateNPlant(NPlant nPlant);
    //农药施用
    List<PesticideVo> getPesticidesByExample(PesticideVo pesticideVo,int page, int limit);
    PesticideVo getPesticideById(Integer id);
    int deletePesticideById(Integer id);
    int updatePesticideById(Pesticide pesticide);
    int insertOrUpdatePesticide(Pesticide pesticide);
    //秸秆堆肥源
    List<StrawCompostVo> getStrawCompostsByExample(StrawCompostVo strawCompostVo,int page, int limit);
    StrawCompostVo getStrawCompostById(Integer id);
    int deleteStrawCompostById(Integer id);
    int updateStrawCompostById(StrawCompost strawCompost);
    int insertOrUpdateStrawCompost(StrawCompost strawCompost);
    //生物质锅炉燃烧源
    List<BiomassBoilerVo> getBioBoilersByExample(BiomassBoilerVo biomassBoilerVo,int page, int limit);
    BiomassBoilerVo getBioBoilerById(Integer id);
    int deleteBioBoilerById(Integer id);
    int updateBioBoilerById(BiomassBoiler biomassBoiler);
    int insertOrUpdateBioBoiler(BiomassBoiler biomassBoiler);
    //森林火灾与草原火灾
    List<BiomassForestGrasslandVo> getBioForestsByExample(BiomassForestGrasslandVo biomassForestGrasslandVo,int page, int limit);
    BiomassForestGrasslandVo getBioForestById(Integer id);
    int deleteBioForestById(Integer id);
    int updateBioForestById(BiomassForestGrassland biomassForestGrassland);
    int insertOrUpdateBioForest(BiomassForestGrassland biomassForestGrassland);
    //生物质户用生物质炉具
    List<BiomassStoveVo> getStovesByExample(BiomassStoveVo biomassStoveVo,int page, int limit);
    BiomassStoveVo getStoveById(Integer id);
    int deleteStoveById(Integer id);
    int updateStoveById(BiomassStove biomassStove);
    int insertOrUpdateStove(BiomassStove biomassStove);
    //秸秆露天焚烧
    List<BiomassStrawVo> getBioStrawsByExample(BiomassStrawVo biomassStrawVo,int page, int limit);
    BiomassStrawVo getBioStrawById(Integer id);
    int deleteBioStrawById(Integer id);
    int updateBioStrawById(BiomassStraw biomassStraw);
    int insertOrUpdateBioStraw(BiomassStraw biomassStraw);
    //道路移动源
    List<RoadMoveVo> getRoadMovesByExample(RoadMoveVo roadMoveVo,int page, int limit);
    RoadMoveVo getRoadMoveById(Integer id);
    int deleteRoadMoveById(Integer id);
    int updateRoadMoveById(RoadMove roadMove);
    int insertOrUpdateRoadMove(RoadMove roadMove);
}
