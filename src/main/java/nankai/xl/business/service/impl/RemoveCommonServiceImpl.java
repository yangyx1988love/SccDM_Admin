package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.DustremoveMapper;
import nankai.xl.business.mapper.NitreremoveMapper;
import nankai.xl.business.mapper.SulphurremoveMapper;
import nankai.xl.business.model.Dustremove;
import nankai.xl.business.model.Nitreremove;
import nankai.xl.business.model.Sulphurremove;
import nankai.xl.business.service.RemoveCommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RemoveCommonServiceImpl implements RemoveCommonService {
    @Resource
    private DustremoveMapper dustremoveMapper;
    @Resource
    private NitreremoveMapper nitreremoveMapper;
    @Resource
    private SulphurremoveMapper sulphurremoveMapper;
    @Override
    public Dustremove getDustremoveById(Integer id) {
        return dustremoveMapper.selectById(id);
    }

    @Override
    public Nitreremove getNitrremoveById(Integer id) {
        return nitreremoveMapper.selectById(id);
    }

    @Override
    public Sulphurremove getSulphurremoveById(Integer id) {
        return sulphurremoveMapper.selectById(id);
    }
}
