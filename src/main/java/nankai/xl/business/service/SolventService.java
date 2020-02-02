package nankai.xl.business.service;

import nankai.xl.business.model.RongjiProduct;
import nankai.xl.business.model.RongjiRaw;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.RongjiProductSumVo;
import nankai.xl.business.model.vo.RongjiRawSumVo;
import nankai.xl.system.model.Adminuser;

import java.util.List;

public interface SolventService {
    //溶剂原料
    RongjiRaw getRawById(Integer id);
    List<RongjiRaw> getRawsByFactoryId(Integer factoryId);
    int updateRawById(RongjiRaw rongjiRaw);
    List<RongjiRawSumVo> getSumRongjiRaws(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<RongjiRawSumVo> getSumRongjiRaws(Adminuser user, int page, int limit);
    //溶剂产品
    RongjiProduct getProductById(Integer id);
    List<RongjiProduct> getProductsByFactoryId(Integer factoryId);
    int updateProductById(RongjiProduct rongjiProduct);
    List<RongjiProductSumVo> getSumRongjiProducts(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<RongjiProductSumVo> getSumRongjiProducts(Adminuser user, int page, int limit);
}
