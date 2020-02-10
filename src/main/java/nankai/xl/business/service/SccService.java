package nankai.xl.business.service;

import nankai.xl.business.model.Scc;
import nankai.xl.business.model.Scc2;
import nankai.xl.business.model.vo.SccActivity;
import nankai.xl.business.model.vo.SccQueryVo;
import nankai.xl.business.model.vo.SccResultVo;

import java.util.List;

public interface SccService {
    public SccActivity getSccByScc(String scc);
    List<Scc> getByLikeScc(String sccCode,int page, int limit);
    List<SccResultVo> getBySccQuery(SccQueryVo sccQueryVo, int page, int limit);
    Scc getSccById(String scc);
    int insertSccSelective(Scc scc);
    int updateSccById(Scc scc);
}
