package nankai.xl.business.service;

import nankai.xl.business.model.Exhaust;
import nankai.xl.business.model.vo.ExhaustSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.system.model.Adminuser;

import java.util.List;

public interface ExhaustService {
    List<Exhaust> getByFactoryId(Integer factoryId);
    Exhaust getByExfId(Integer exfId);
    int updateExhaustByExfId(Exhaust exhaust);
    List<ExhaustSumVo> getSumExhausts(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<ExhaustSumVo> getSumExhausts(Adminuser user, int page, int limit);
}
