package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.RongjiProductMapper;
import nankai.xl.business.mapper.RongjiRawMapper;
import nankai.xl.business.model.RongjiProduct;
import nankai.xl.business.model.RongjiRaw;
import nankai.xl.business.service.SolventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SolventServiceImpl implements SolventService {
    @Resource
    private RongjiRawMapper rongjiRawMapper;
    @Resource
    private RongjiProductMapper rongjiProductMapper;
    @Override
    public RongjiRaw getRawById(Integer id) {
        return rongjiRawMapper.selectById(id);
    }

    @Override
    public List<RongjiRaw> getRawsByFactoryId(Integer factoryId) {
        return rongjiRawMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateRawById(RongjiRaw rongjiRaw) {
        return rongjiRawMapper.updateById(rongjiRaw);
    }

    @Override
    public RongjiProduct getProductById(Integer id) {
        return rongjiProductMapper.selectById(id);
    }

    @Override
    public List<RongjiProduct> getProductsByFactoryId(Integer factoryId) {
        return rongjiProductMapper.selectByFactoryId(factoryId);
    }

    @Override
    public int updateProductById(RongjiProduct rongjiProduct) {
        return rongjiProductMapper.updateById(rongjiProduct);
    }
}
