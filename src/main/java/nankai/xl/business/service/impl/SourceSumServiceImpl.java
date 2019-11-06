package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.ScatteredCoalMapper;
import nankai.xl.business.model.ScatteredCoal;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.business.service.SourceSumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SourceSumServiceImpl implements SourceSumService {
    @Resource
    private ScatteredCoalMapper scatteredCoalMapper;
    @Override
    public List<SumVo> sumScatByFuleTypeACity() {
        return scatteredCoalMapper.sumByFuleTypeACity();
    }
}
