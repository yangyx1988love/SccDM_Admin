package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.*;
import nankai.xl.business.service.NonRoadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NonRoadServiceImpl implements NonRoadService {
    @Resource
    private AgricultureMachineryMapper agricultureMachineryMapper;
    @Resource
    private AirplaneMapper airplaneMapper;
    @Resource
    private NonroadMachineryMapper nonroadMachineryMapper;
    @Resource
    private RailwayEngineMapper railwayEngineMapper;
    @Resource
    private SmallMachineryMapper smallMachineryMapper;
    @Override
    public List<AgricultureMachineryVo> getByExample(AgricultureMachineryVo agricultureMachineryVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return agricultureMachineryMapper.selectByExample(agricultureMachineryVo);
    }

    @Override
    public AgricultureMachineryVo getAgricultureById(Integer id) {
        return agricultureMachineryMapper.selectById(id);
    }

    @Override
    public int deleteAgricultureById(Integer id) {
        return agricultureMachineryMapper.deleteById(id);
    }

    @Override
    public int updateById(AgricultureMachinery agricultureMachinery) {
        return agricultureMachineryMapper.updateById(agricultureMachinery);
    }

    @Override
    public int insertOrUpdate(AgricultureMachinery agricultureMachinery) {
        return agricultureMachineryMapper.insertOrUpdate(agricultureMachinery);
    }

    @Override
    public List<AirplaneVo> getByExample(AirplaneVo airplaneVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return airplaneMapper.selectByExample(airplaneVo);
    }

    @Override
    public AirplaneVo getAirplaneById(Integer id) {
        return airplaneMapper.selectById(id);
    }

    @Override
    public int deleteAirplaneById(Integer id) {
        return airplaneMapper.deleteById(id);
    }

    @Override
    public int updateById(Airplane airplane) {
        return airplaneMapper.updateById(airplane);
    }

    @Override
    public int insertOrUpdate(Airplane airplane) {
        return airplaneMapper.insertOrUpdate(airplane);
    }

    @Override
    public List<NonroadMachineryVo> getByExample(NonroadMachineryVo nonroadMachineryVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return nonroadMachineryMapper.selectByExample(nonroadMachineryVo);
    }

    @Override
    public NonroadMachineryVo getMachineryById(Integer id) {
        return nonroadMachineryMapper.selectById(id);
    }

    @Override
    public int deleteMachineryById(Integer id) {
        return nonroadMachineryMapper.deleteById(id);
    }

    @Override
    public int updateById(NonroadMachinery nonroadMachinery) {
        return nonroadMachineryMapper.updateById(nonroadMachinery);
    }

    @Override
    public int insertOrUpdate(NonroadMachinery nonroadMachinery) {
        return nonroadMachineryMapper.insertOrUpdate(nonroadMachinery);
    }

    @Override
    public List<RailwayEngineVo> getByExample(RailwayEngineVo railwayEngineVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return railwayEngineMapper.selectByExample(railwayEngineVo);
    }

    @Override
    public RailwayEngineVo getRailwayById(Integer id) {
        return railwayEngineMapper.selectById(id);
    }

    @Override
    public int deleteRailwayById(Integer id) {
        return railwayEngineMapper.deleteById(id);
    }

    @Override
    public int updateById(RailwayEngine railwayEngine) {
        return railwayEngineMapper.updateById(railwayEngine);
    }

    @Override
    public int insertOrUpdate(RailwayEngine railwayEngine) {
        return railwayEngineMapper.insertOrUpdate(railwayEngine);
    }

    @Override
    public List<SmallMachineryVo> getByExample(SmallMachineryVo smallMachineryVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return smallMachineryMapper.selectByExample(smallMachineryVo);
    }

    @Override
    public SmallMachineryVo getSmallMachineryById(Integer id) {
        return smallMachineryMapper.selectById(id);
    }

    @Override
    public int deleteSmallMachineryById(Integer id) {
        return smallMachineryMapper.deleteById(id);
    }

    @Override
    public int updateById(SmallMachinery smallMachinery) {
        return smallMachineryMapper.updateById(smallMachinery);
    }

    @Override
    public int insertOrUpdate(SmallMachinery smallMachinery) {
        return smallMachineryMapper.insertOrUpdate(smallMachinery);
    }
}
