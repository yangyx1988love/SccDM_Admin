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
    @Resource
    private SccMapper sccMapper;
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
    public int insertOrUpdate(AgricultureMachinery agricultureMachinery,boolean isCul) {
        if (!isCul){
            Scc scc=getSccFactor(agricultureMachinery.getSccCode());
            Double activity=agricultureMachinery.getAnnalAverageMilage();
            agricultureMachinery.setPm25Emission(activity*scc.getPm25());
            agricultureMachinery.setPm10Emission(activity*scc.getPm10());
            agricultureMachinery.setCoEmission(activity*scc.getCo());
            agricultureMachinery.setVocsEmission(activity*scc.getVocs());
            agricultureMachinery.setSo2Emission(activity*scc.getSo2());
            agricultureMachinery.setNoxEmission(activity*scc.getNox());
            agricultureMachinery.setNh3Emission(activity*scc.getNh3());
            agricultureMachinery.setOcEmission(activity*scc.getOc());
            agricultureMachinery.setBcEmission(activity*scc.getBc());
        }
        if(agricultureMachinery.getId()!=null){
            agricultureMachineryMapper.updateById(agricultureMachinery);
        }else {
            agricultureMachineryMapper.insertSelective(agricultureMachinery);
        }
        return 1;
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
    public int insertOrUpdate(Airplane airplane,boolean isCul) {
        if (!isCul){
            Scc scc=getSccFactor(airplane.getSccCode());
            Double activity=airplane.getActivityLevel();
            airplane.setPm25Emission(activity*scc.getPm25());
            airplane.setPm10Emission(activity*scc.getPm10());
            airplane.setCoEmission(activity*scc.getCo());
            airplane.setVocsEmission(activity*scc.getVocs());
            airplane.setSo2Emission(activity*scc.getSo2());
            airplane.setNoxEmission(activity*scc.getNox());
            airplane.setNh3Emission(activity*scc.getNh3());
            airplane.setOcEmission(activity*scc.getOc());
            airplane.setBcEmission(activity*scc.getBc());
        }
        if(airplane.getId()!=null){
            airplaneMapper.updateById(airplane);
        }else {
            airplaneMapper.insertSelective(airplane);
        }
        return 1;
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
    public int insertOrUpdate(NonroadMachinery nonroadMachinery,boolean isCul) {
        if (!isCul){
            Scc scc=getSccFactor(nonroadMachinery.getSccCode());
            Double activity=nonroadMachinery.getAnnalAverageMileage();
            nonroadMachinery.setPm25Emission(activity*scc.getPm25());
            nonroadMachinery.setPm10Emission(activity*scc.getPm10());
            nonroadMachinery.setCoEmission(activity*scc.getCo());
            nonroadMachinery.setVocsEmission(activity*scc.getVocs());
            nonroadMachinery.setSo2Emission(activity*scc.getSo2());
            nonroadMachinery.setNoxEmission(activity*scc.getNox());
            nonroadMachinery.setNh3Emission(activity*scc.getNh3());
            nonroadMachinery.setOcEmission(activity*scc.getOc());
            nonroadMachinery.setBcEmission(activity*scc.getBc());
        }
        if(nonroadMachinery.getId()!=null){
            nonroadMachineryMapper.updateById(nonroadMachinery);
        }else {
            nonroadMachineryMapper.insertSelective(nonroadMachinery);
        }
        return 1;
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
    public int insertOrUpdate(RailwayEngine railwayEngine,boolean isCul) {
        if (!isCul){
            Scc scc=getSccFactor(railwayEngine.getSccCode());
            Double activity=railwayEngine.getFuelAnnualUsage();
            railwayEngine.setPm25Emission(activity*scc.getPm25());
            railwayEngine.setPm10Emission(activity*scc.getPm10());
            railwayEngine.setCoEmission(activity*scc.getCo());
            railwayEngine.setVocsEmission(activity*scc.getVocs());
            railwayEngine.setSo2Emission(activity*scc.getSo2());
            railwayEngine.setNoxEmission(activity*scc.getNox());
            railwayEngine.setNh3Emission(activity*scc.getNh3());
            railwayEngine.setOcEmission(activity*scc.getOc());
            railwayEngine.setBcEmission(activity*scc.getBc());
        }
        if(railwayEngine.getId()!=null){
            railwayEngineMapper.updateById(railwayEngine);
        }else {
            railwayEngineMapper.insertSelective(railwayEngine);
        }
        return 1;
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
    public int insertOrUpdate(SmallMachinery smallMachinery,boolean isCul) {
        if (!isCul){
            Scc scc=getSccFactor(smallMachinery.getSccCode());
            Double activity=smallMachinery.getAnnalAverageMileage();
            smallMachinery.setPm25Emission(activity*scc.getPm25());
            smallMachinery.setPm10Emission(activity*scc.getPm10());
            smallMachinery.setCoEmission(activity*scc.getCo());
            smallMachinery.setVocsEmission(activity*scc.getVocs());
            smallMachinery.setSo2Emission(activity*scc.getSo2());
            smallMachinery.setNoxEmission(activity*scc.getNox());
            smallMachinery.setNh3Emission(activity*scc.getNh3());
            smallMachinery.setOcEmission(activity*scc.getOc());
            smallMachinery.setBcEmission(activity*scc.getBc());
        }
        if(smallMachinery.getId()!=null){
            smallMachineryMapper.updateById(smallMachinery);
        }else {
            smallMachineryMapper.insertSelective(smallMachinery);
        }
        return 1;
    }
    public Scc getSccFactor(String sccCode){
        Scc scc=sccMapper.selectByScc(sccCode);
        if (scc==null){
            throw new NullPointerException("无对应SCC因子表，请自己填写污染物排放量！");
        }
        return scc;
    }
}
