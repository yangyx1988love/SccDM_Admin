package nankai.xl.business.service;

import nankai.xl.business.model.Feiqi;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.FeiqiSumVo;
import nankai.xl.system.model.Adminuser;

import java.util.List;

public interface DisuseService {
    //废弃
    Feiqi getFeiqiById(Integer id);
    List<Feiqi> getFeiqisByFactoryId(Integer factoryId);
    int updateFeiqiById(Feiqi feiqi);
    List<FeiqiSumVo> getSumFeiqis(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<FeiqiSumVo> getSumFeiqis(Adminuser user, int page, int limit);
}
