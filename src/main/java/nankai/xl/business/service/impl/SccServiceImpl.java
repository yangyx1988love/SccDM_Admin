package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.SccMapper;
import nankai.xl.business.model.Scc;
import nankai.xl.business.service.SccService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SccServiceImpl implements SccService {
    @Resource
    private SccMapper sccMapper;
    @Override
    public Scc getSccByScc(String scc) {
        return sccMapper.selectByScc(scc);
    }

    @Override
    public <T> T culByscc(String sccCode, Class<T> tClass) {
        return null;
    }
}
