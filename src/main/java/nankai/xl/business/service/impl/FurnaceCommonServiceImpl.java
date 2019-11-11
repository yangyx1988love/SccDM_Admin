package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.BoilerMapper;
import nankai.xl.business.mapper.KilnMapper;
import nankai.xl.business.model.Boiler;
import nankai.xl.business.model.Kiln;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.business.service.FurnaceCommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FurnaceCommonServiceImpl implements FurnaceCommonService {
    @Resource
    private BoilerMapper boilerMapper;
    @Resource
    private KilnMapper kilnMapper;

    @Override
    public Boiler getBoilerById(Integer id) {
        return boilerMapper.selectById(id);
    }

    @Override
    public List<Boiler> getBoilersByExhustId(Integer exhustId) {
        return boilerMapper.selectByExhustId(exhustId);
    }

    @Override
    public List<Boiler> getBoilersByFactoryId(Integer factoryId) {
        return boilerMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateBoilerById(Boiler boiler) {
        return boilerMapper.updateById(boiler);
    }

    @Override
    public Kiln getKilnById(Integer id) {
        return kilnMapper.selectById(id);
    }

    @Override
    public List<Kiln> getKilnsByExhustId(Integer exhustId) {
        return kilnMapper.selectByExhustId(exhustId);
    }

    @Override
    public List<Kiln> getKilnsByFactoryId(Integer factoryId) {
        return kilnMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateKilnById(Kiln kiln) {
        return kilnMapper.updateById(kiln);
    }

    @Override
    public List<SumVo> countBoilerByCity() {
        return boilerMapper.countByCity();
    }

    @Override
    public List<SumVo> countBoilerByCounty() {
        return boilerMapper.countByCounty();
    }

    @Override
    public List<SumVo> countKilnByCity() {
        return kilnMapper.countByCity();
    }

    @Override
    public List<SumVo> countKilnByCounty() {
        return kilnMapper.countByCounty();
    }
}
