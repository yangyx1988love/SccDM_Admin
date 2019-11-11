package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.ExhaustMapper;
import nankai.xl.business.model.Exhaust;
import nankai.xl.business.service.ExhaustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExhaustServiceImpl implements ExhaustService {
    @Resource
    private ExhaustMapper exhaustMapper;
    @Override
    public List<Exhaust> getByFactoryId(Integer factoryId) {
        return exhaustMapper.selectByFactoryId(factoryId);
    }

    @Override
    public Exhaust getByExfId(Integer exfId) {
        return exhaustMapper.selectByExfId(exfId);
    }

    @Override
    public int updateExhaustByExfId(Exhaust exhaust) {
        return exhaustMapper.updateByExfId(exhaust);
    }
}
