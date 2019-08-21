package nankai.xl.business.service;

import nankai.xl.business.model.RongjiProduct;
import nankai.xl.business.model.RongjiRaw;
import nankai.xl.business.model.vo.RongjiProductVo;
import nankai.xl.business.model.vo.RongjiRawVo;

import java.util.List;

public interface SolventService {

    RongjiRaw getRawById(Integer id);
    List<RongjiRawVo> getRawsByFactoryId(Integer factoryId);
    int updateRawById(RongjiRaw rongjiRaw);

    RongjiProduct getProductById(Integer id);
    List<RongjiProductVo> getProductsByFactoryId(Integer factoryId);
    int updateProductById(RongjiProduct rongjiProduct);
}
