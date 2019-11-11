package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.FeiqiMapper;
import nankai.xl.business.model.Feiqi;
import nankai.xl.business.service.DisuseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DisuseServiceImpl implements DisuseService {
    @Resource
    private FeiqiMapper feiqiMapper;
    @Override
    public Feiqi getFeiqiById(Integer id) {
        return feiqiMapper.selectById(id);
    }

    @Override
    public List<Feiqi> getFeiqisByFactoryId(Integer factoryId) {
        return feiqiMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateFeiqiById(Feiqi feiqi) {
        return feiqiMapper.updateById(feiqi);
    }
}
