package nankai.xl.business.service;

import nankai.xl.business.model.Feiqi;

import java.util.List;

public interface DisuseService {
    Feiqi getFeiqiById(Integer id);
    List<Feiqi> getFeiqisByFactoryId(Integer factoryId);
    int updateFeiqiById(Feiqi feiqi);
}
