package nankai.xl.business.service;

import nankai.xl.business.model.Feiqi;
import nankai.xl.business.model.vo.FeiqiVo;

import java.util.List;

public interface DisuseService {
    Feiqi getFeiqiById(Integer id);
    List<FeiqiVo> getFeiqisByFactoryId(Integer factoryId);
    int updateFeiqiById(Feiqi feiqi);
}
