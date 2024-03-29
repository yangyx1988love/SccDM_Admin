package nankai.xl.business.service;

import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;

import java.util.List;

public interface SourceService {
    /*
        固体燃烧源
    */
    //固体燃烧源//散煤
    int insertOrUpdateScatteredCoal(ScatteredCoalVo scatteredCoalVo,boolean isCul);
    List<ScatteredCoalVo> getByScatteredCoals(ScatteredCoalVo scatteredCoalVo,int page, int limit);
    int getFixedSourceNum(String cityCode,String countyCode);
    ScatteredCoalVo getScatById(Integer id);
    int deleteScatById(Integer id);
    /*
        工艺过程源
    */
    int getProcessSourceNum(String cityCode,String countyCode);
    //工艺过程源//石化有组织废气排放
    int insertOrUpdateShGa(ShGasemissionVo shGasemissionVo,boolean isCul);
    List<ShGasemissionVo> getShGasByShGas(ShGasemissionVo shGasemissionVo,int page, int limit);
    ShGasemissionVo getShGaById(Integer id);
    int deleteShGaById(Integer id);
    //工艺过程源//装置密封点
    int insertOrUpdateShSeal(ShSealpointVo shSealpointVo,boolean isCul);
    List<ShSealpointVo> getShSealsByExample(ShSealpointVo shSealpointVo,int page, int limit);
    ShSealpointVo getShSealById(Integer id);
    int deleteShSealById(Integer id);
    //工艺过程源//废水无组织排放
    int insertOrUpdateShEff(ShEffluentemissionVo shEffluentemissionVo,boolean isCul);
    List<ShEffluentemissionVo> getShEffsByExample(ShEffluentemissionVo shEffluentemissionVo,int page, int limit);
    ShEffluentemissionVo getShEffById(Integer id);
    int deleteShEffById(Integer id);
    //工艺过程源//VOC处理装置
    int insertOrUpdateShVoc(ShVocdeviceeffiVo shVocdeviceeffiVo,boolean isCul);
    List<ShVocdeviceeffiVo> getShVocsByExample(ShVocdeviceeffiVo shVocdeviceeffiVo,int page, int limit);
    ShVocdeviceeffiVo getShVocById(Integer id);
    int deleteShVocById(Integer id);
    /*
        溶剂使用源
    */
    int getSolventSourceNum(String cityCode,String countyCode);
    //溶剂使用源//建筑涂装二手房
    List<BuildingSmearVo> getBuildsByExample(BuildingSmearVo buildingSmearVo,int page, int limit);
    BuildingSmearVo getBuildById(Integer id);
    int deleteBuildById(Integer id);
    int insertOrUpdateBuild(BuildingSmearVo buildingSmearVo,boolean isCul);
    //溶剂使用源//汽修厂
    List<CarRepairVo> getCarsByExample(CarRepairVo carRepairVo,int page, int limit);
    CarRepairVo getCarById(Integer id);
    int deleteCarById(Integer id);
    int insertOrUpdateCar(CarRepairVo carRepairVo,boolean isCul);
    //溶剂使用源//去污油脂
    List<DeoilVo> getDeoilsByExample(DeoilVo deoilVo,int page, int limit);
    DeoilVo getDeoilById(Integer id);
    int deleteDeoilById(Integer id);
    int insertOrUpdateDeoil(DeoilVo deoilVo,boolean isCul);
    //溶剂使用源//干洗店
    List<DryCleanerVo> getDrysByExample(DryCleanerVo dryCleanerVo,int page, int limit);
    DryCleanerVo getDryById(Integer id);
    int deleteDryById(Integer id);
    int insertOrUpdateDry(DryCleanerVo dryCleanerVo,boolean isCul);
    //溶剂使用源//家居家装
    List<HouseVo> getHousesByExample(HouseVo houseVo,int page, int limit);
    HouseVo getHouseById(Integer id);
    int deleteHouseById(Integer id);
    int insertOrUpdateHouse(HouseVo houseVo,boolean isCul);
    //溶剂使用源//道路铺装
    List<RoadPaveVo> getRoadPasByExample(RoadPaveVo roadPaveVo,int page, int limit);
    RoadPaveVo getRoadPaById(Integer id);
    int deleteRoadPaById(Integer id);
    int insertOrUpdateRoadPa(RoadPaveVo roadPaveVo,boolean isCul);
    /*
    扬尘源
    */
    int getDustSourceNum(String cityCode,String countyCode);
    //施工扬尘源
    List<ycConstructdustVo> getConsByExample(ycConstructdustVo xjconstructdustVo, int page, int limit);
    ycConstructdustVo getConById(Integer id);
    int deleteConById(Integer id);
    int insertOrUpdateCon(ycConstructdustVo xjconstructdustVo, boolean isCul);
    //堆场装卸扬尘源
    List<YcDustLoadVo> getDustLoadsByExample(YcDustLoadVo xjcydustLoadVo, int page, int limit);
    YcDustLoadVo getDustLoadById(Integer id);
    int deleteDustLoadById(Integer id);
    int insertOrUpdateDustLoad(YcDustLoadVo xjcydustLoadVo, boolean isCul);
    //堆场风蚀扬尘源
    List<YcDustStackVo> getDustStacksByExample(YcDustStackVo xjcydustStackVo, int page, int limit);
    YcDustStackVo getDustStackById(Integer id);
    int deleteDustStackById(Integer id);
    int insertOrUpdateDustStack(YcDustStackVo xjcydustStackVo, boolean isCul);
    //道路扬尘源
    List<YcRoaddustVo> getRoadDustsByExample(YcRoaddustVo xjroaddustVo, int page, int limit);
    YcRoaddustVo getRoadDustById(Integer id);
    int deleteRoadDustById(Integer id);
    int insertOrUpdateRoadDust(YcRoaddustVo xjroaddustVo, boolean isCul);
    //土壤扬尘源
    List<YcSoildustVo> getSoilDustsByExample(YcSoildustVo xjsoildustVo, int page, int limit);
    YcSoildustVo getSoilDustById(Integer id);
    int deleteSoilDustById(Integer id);
    int insertOrUpdateSoilDust(YcSoildustVo xjsoildustVo, boolean isCul);
    /*
        存储与运输源
    */
    int getTransportSourceNum(String cityCode,String countyCode);
    //存储与运输源//加气站
    List<GasSourceVo> getGassByExample(GasSourceVo gasSourceVo,int page, int limit);
    GasSourceVo getGasById(Integer id);
    int deleteGasById(Integer id);
    int insertOrUpdateGas(GasSourceVo gasSourceVo,boolean isCul);
    //存储与运输源//加油站
    List<OilSourceVo> getOilsByExample(OilSourceVo oilSourceVo,int page, int limit);
    OilSourceVo getOilById(Integer id);
    int deleteOilById(Integer id);
    int insertOrUpdateOil(OilSourceVo oilSourceVo,boolean isCul);
    //存储与运输源//装载过程排放
    List<OilTransportVo> getOilTransByExample(OilTransportVo oilTransportVo,int page, int limit);
    OilTransportVo getOilTranById(Integer id);
    int deleteOilTranById(Integer id);
    int insertOrUpdateOilTran(OilTransportVo oilTransportVo,boolean isCul);
    //存储与运输源//储罐存储
    List<TankSourceVo> getTanksByExample(TankSourceVo tankSourceVo,int page, int limit);
    TankSourceVo getTankById(Integer id);
    int deleteTankById(Integer id);
    int insertOrUpdateTank(TankSourceVo tankSourceVo,boolean isCul);
    /*
        农牧源
    */
    int getFarmSourceNum(String cityCode,String countyCode);
    //农牧源//土壤本底
    List<BaseSoilVo> getBaseSoilsByExample(BaseSoilVo baseSoilVo,int page, int limit);
    BaseSoilVo getBaseSoilById(Integer id);
    int deleteBaseSoilById(Integer id);
    int insertOrUpdateBaseSoil(BaseSoilVo baseSoilVo,boolean isCul);
    //农牧源//畜禽集约化养殖
    List<CollectbreedingVo> getCoBreedsByExample(CollectbreedingVo collectbreedingVo,int page, int limit);
    CollectbreedingVo getCoBreedById(Integer id);
    int deleteCoBreedById(Integer id);
    int insertOrUpdateCoBreed(CollectbreedingVo collectbreedingVo,boolean isCul);
    //农牧源//农肥施用源
    List<FertilizationVo> getFertilsByExample(FertilizationVo fertilizationVo,int page, int limit);
    FertilizationVo getFertilById(Integer id);
    int deleteFertilById(Integer id);
    int insertOrUpdateFertil(FertilizationVo fertilizationVo,boolean isCul);
    //农牧源//畜牧散养源
    List<FreeStockbreedingVo> getFreeStocksByExample(FreeStockbreedingVo freeStockbreedingVo,int page, int limit);
    FreeStockbreedingVo getFreeStockById(Integer id);
    int deleteFreeStockById(Integer id);
    int insertOrUpdateFreeStock(FreeStockbreedingVo freeStockbreedingVo,boolean isCul);
    //农牧源//固氮植物源
    List<NPlantVo> getNPlantsByExample(NPlantVo nPlantVo,int page, int limit);
    NPlantVo getNPlantById(Integer id);
    int deleteNPlantById(Integer id);
    int insertOrUpdateNPlant(NPlantVo nPlantVo,boolean isCul);
    //农牧源//农药施用
    List<PesticideVo> getPesticidesByExample(PesticideVo pesticideVo,int page, int limit);
    PesticideVo getPesticideById(Integer id);
    int deletePesticideById(Integer id);
    int insertOrUpdatePesticide(PesticideVo pesticideVo,boolean isCul);
    //农牧源//秸秆堆肥源
    List<StrawCompostVo> getStrawCompostsByExample(StrawCompostVo strawCompostVo,int page, int limit);
    StrawCompostVo getStrawCompostById(Integer id);
    int deleteStrawCompostById(Integer id);
    int insertOrUpdateStrawCompost(StrawCompostVo strawCompostVo,boolean isCul);
    /*
        生物质燃烧源
     */
    int getBiomassSourceNum(String cityCode,String countyCode);
    //生物质燃烧源//生物质锅炉燃烧源
    List<BiomassBoilerVo> getBioBoilersByExample(BiomassBoilerVo biomassBoilerVo,int page, int limit);
    BiomassBoilerVo getBioBoilerById(Integer id);
    int deleteBioBoilerById(Integer id);
    int insertOrUpdateBioBoiler(BiomassBoilerVo biomassBoilerVo,boolean isCul);
    //生物质燃烧源//森林火灾与草原火灾
    List<BiomassForestGrasslandVo> getBioForestsByExample(BiomassForestGrasslandVo biomassForestGrasslandVo,int page, int limit);
    BiomassForestGrasslandVo getBioForestById(Integer id);
    int deleteBioForestById(Integer id);
    int insertOrUpdateBioForest(BiomassForestGrasslandVo biomassForestGrasslandVo,boolean isCul);
    //生物质燃烧源//生物质户用生物质炉具
    List<BiomassStoveVo> getBioStovesByExample(BiomassStoveVo biomassStoveVo,int page, int limit);
    BiomassStoveVo getBioStoveById(Integer id);
    int deleteBioStoveById(Integer id);
    int insertOrUpdateBioStove(BiomassStoveVo biomassStoveVo,boolean isCul);
    //生物质燃烧源//秸秆露天焚烧
    List<BiomassStrawVo> getBioStrawsByExample(BiomassStrawVo biomassStrawVo,int page, int limit);
    BiomassStrawVo getBioStrawById(Integer id);
    int deleteBioStrawById(Integer id);
    int insertOrUpdateBioStraw(BiomassStrawVo biomassStrawVo,boolean isCul);
    /*
      道路移动源
    */
    int getRoadSourceNum(String cityCode,String countyCode);
    //道路移动源
    List<RoadMoveVo> getRoadMovesByExample(RoadMoveVo roadMoveVo,int page, int limit);
    RoadMoveVo getRoadMoveById(Integer id);
    int deleteRoadMoveById(Integer id);
    int insertOrUpdateRoadMove(RoadMoveVo roadMoveVo,boolean isCul);
    /*
      //非道路移动源
    */
    int getNonRoadSourceNum(String cityCode,String countyCode);
    //非道路移动源//农用运输车
    List<AgricultureMachineryVo> getByExample(AgricultureMachineryVo agricultureMachineryVo,int page, int limit);
    AgricultureMachineryVo getAgricultureById(Integer id);
    int deleteAgricultureById(Integer id);
    int updateById(AgricultureMachinery agricultureMachinery);
    int insertOrUpdate(AgricultureMachinery agricultureMachinery,boolean isCul);
    //非道路移动源//飞机
    List<AirplaneVo> getByExample(AirplaneVo airplaneVo,int page, int limit);
    AirplaneVo getAirplaneById(Integer id);
    int deleteAirplaneById(Integer id);
    int updateById(Airplane airplane);
    int insertOrUpdate(Airplane airplane,boolean isCul);
    //非道路移动源//非道路机械
    List<NonroadMachineryVo> getByExample(NonroadMachineryVo nonroadMachineryVo,int page, int limit);
    NonroadMachineryVo getMachineryById(Integer id);
    int deleteMachineryById(Integer id);
    int updateById(NonroadMachinery nonroadMachinery);
    int insertOrUpdate(NonroadMachinery nonroadMachinery,boolean isCul);
    //非道路移动源//铁路内燃机
    List<RailwayEngineVo> getByExample(RailwayEngineVo railwayEngineVo,int page, int limit);
    RailwayEngineVo getRailwayById(Integer id);
    int deleteRailwayById(Integer id);
    int updateById(RailwayEngine railwayEngine);
    int insertOrUpdate(RailwayEngine railwayEngine,boolean isCul);
    //非道路移动源//小型通用机械
    List<SmallMachineryVo> getByExample(SmallMachineryVo smallMachineryVo,int page, int limit);
    SmallMachineryVo getSmallMachineryById(Integer id);
    int deleteSmallMachineryById(Integer id);
    int updateById(SmallMachinery smallMachinery);
    int insertOrUpdate(SmallMachinery smallMachinery,boolean isCul);
    /*
      餐饮源
    */
    int getRepastSourceNum(String cityCode,String countyCode);
    //烧烤
    List<RepastBarbecueVo> getRepastsBarbecuesByExample(RepastBarbecueVo repastBarbecueVo,int page, int limit);
    RepastBarbecueVo getRepastBarbecueById(Integer id);
    int deleteRepastBarbecueById(Integer id);
    int insertOrUpdateRepastBarbecue(RepastBarbecueVo repastBarbecueVo,boolean isCul);
    //家庭
    List<RepastFamilyVo> getRepastFamilysByExample(RepastFamilyVo repastFamilyVo,int page, int limit);
    RepastFamilyVo getRepastFamilyById(Integer id);
    int deleteRepastFamilyById(Integer id);
    int insertOrUpdateRepastFamily(RepastFamilyVo repastFamilyVo, boolean isCul);
    //社会
    List<RepastVo> getRepastsByExample(RepastVo repastVo,int page, int limit);
    RepastVo getRepastById(Integer id);
    int deleteRepastById(Integer id);
    int insertOrUpdateRepast(RepastVo repastVo,boolean isCul);

}
