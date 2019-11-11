package nankai.xl.business.service;

import nankai.xl.business.model.Exhaust;

import java.util.List;

public interface ExhaustService {
    List<Exhaust> getByFactoryId(Integer factoryId);
    Exhaust getByExfId(Integer exfId);
    int updateExhaustByExfId(Exhaust exhaust);
}
