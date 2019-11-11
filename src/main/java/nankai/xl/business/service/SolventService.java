package nankai.xl.business.service;

import nankai.xl.business.model.RongjiProduct;
import nankai.xl.business.model.RongjiRaw;

import java.util.List;

public interface SolventService {

    RongjiRaw getRawById(Integer id);
    List<RongjiRaw> getRawsByFactoryId(Integer factoryId);
    int updateRawById(RongjiRaw rongjiRaw);

    RongjiProduct getProductById(Integer id);
    List<RongjiProduct> getProductsByFactoryId(Integer factoryId);
    int updateProductById(RongjiProduct rongjiProduct);
}
