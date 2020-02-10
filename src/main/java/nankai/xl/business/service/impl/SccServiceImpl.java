package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.SccMapper;
import nankai.xl.business.model.Scc;
import nankai.xl.business.model.vo.SccActivity;
import nankai.xl.business.model.vo.SccQueryVo;
import nankai.xl.business.model.vo.SccResultVo;
import nankai.xl.business.service.SccService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SccServiceImpl implements SccService {
    @Resource
    private SccMapper sccMapper;
    @Override
    public SccActivity getSccByScc(String scc) {
        return sccMapper.selectSccActivityByScc(scc);
    }

    @Override
    public List<Scc> getByLikeScc(String sccCode,int page, int limit) {
        PageHelper.startPage(page, limit);
        return sccMapper.selectByLikeScc(sccCode);
    }

    @Override
    public List<SccResultVo> getBySccQuery(SccQueryVo sccQueryVo, int page, int limit) {
        PageHelper.startPage(page, limit);
        return sccMapper.selectBySccQuery(sccQueryVo);
    }

    @Override
    public Scc getSccById(String scc) {
        return sccMapper.selectById(scc);
    }

    @Override
    public int insertSccSelective(Scc scc) {
        return sccMapper.insertSelective(scc);
    }

    @Override
    public int updateSccById(Scc scc) {
        return sccMapper.updateById(scc);
    }
}
