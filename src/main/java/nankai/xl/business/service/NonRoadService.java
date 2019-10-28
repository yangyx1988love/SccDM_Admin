package nankai.xl.business.service;

import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;

import java.util.List;

public interface NonRoadService {
    //农用运输车
    List<AgricultureMachineryVo> getByExample(AgricultureMachineryVo agricultureMachineryVo,int page, int limit);
    AgricultureMachineryVo getAgricultureById(Integer id);
    int deleteAgricultureById(Integer id);
    int updateById(AgricultureMachinery agricultureMachinery);
    int insertOrUpdate(AgricultureMachinery agricultureMachinery,boolean isCul);
    //飞机
    List<AirplaneVo> getByExample(AirplaneVo airplaneVo,int page, int limit);
    AirplaneVo getAirplaneById(Integer id);
    int deleteAirplaneById(Integer id);
    int updateById(Airplane airplane);
    int insertOrUpdate(Airplane airplane,boolean isCul);
    //非道路机械
    List<NonroadMachineryVo> getByExample(NonroadMachineryVo nonroadMachineryVo,int page, int limit);
    NonroadMachineryVo getMachineryById(Integer id);
    int deleteMachineryById(Integer id);
    int updateById(NonroadMachinery nonroadMachinery);
    int insertOrUpdate(NonroadMachinery nonroadMachinery,boolean isCul);
    //铁路内燃机
    List<RailwayEngineVo> getByExample(RailwayEngineVo railwayEngineVo,int page, int limit);
    RailwayEngineVo getRailwayById(Integer id);
    int deleteRailwayById(Integer id);
    int updateById(RailwayEngine railwayEngine);
    int insertOrUpdate(RailwayEngine railwayEngine,boolean isCul);
    //小型通用机械
    List<SmallMachineryVo> getByExample(SmallMachineryVo smallMachineryVo,int page, int limit);
    SmallMachineryVo getSmallMachineryById(Integer id);
    int deleteSmallMachineryById(Integer id);
    int updateById(SmallMachinery smallMachinery);
    int insertOrUpdate(SmallMachinery smallMachinery,boolean isCul);
}
