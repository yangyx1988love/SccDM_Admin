package nankai.xl.business.service.impl;

import com.github.pagehelper.PageHelper;
import nankai.xl.business.mapper.RepastBarbecueMapper;
import nankai.xl.business.mapper.RepastFamilyMapper;
import nankai.xl.business.mapper.RepastMapper;
import nankai.xl.business.model.Repast;
import nankai.xl.business.model.RepastBarbecue;
import nankai.xl.business.model.RepastFamily;
import nankai.xl.business.model.vo.RepastBarbecueVo;
import nankai.xl.business.model.vo.RepastVo;
import nankai.xl.business.service.RepastService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepastServiceImpl implements RepastService {
    @Resource
    private RepastBarbecueMapper repastBarbecueMapper;
    @Resource
    private RepastFamilyMapper repastFamilyMapper;
    @Resource
    private RepastMapper repastMapper;
    @Override
    public List<RepastBarbecueVo> getByExample(RepastBarbecueVo repastBarbecueVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return repastBarbecueMapper.selectByExample(repastBarbecueVo);
    }

    @Override
    public RepastBarbecueVo getBarbecueById(Integer id) {
        return repastBarbecueMapper.selectById(id);
    }

    @Override
    public int deleteBarbecueById(Integer id) {
        return repastBarbecueMapper.deleteById(id);
    }

    @Override
    public int updateById(RepastBarbecue repastBarbecue) {
        return repastBarbecueMapper.updateById(repastBarbecue);
    }

    @Override
    public int insertOrUpdate(RepastBarbecue repastBarbecue) {
        return repastBarbecueMapper.insertOrUpdate(repastBarbecue);
    }

    @Override
    public List<RepastFamily> getByExample(RepastFamily repastFamily,int page, int limit) {
        PageHelper.startPage(page, limit);
        return repastFamilyMapper.selectByExample(repastFamily);
    }

    @Override
    public RepastFamily getFamilyById(Integer id) {
        return repastFamilyMapper.selectById(id);
    }

    @Override
    public int deleteFamilyById(Integer id) {
        return repastFamilyMapper.deleteById(id);
    }

    @Override
    public int updateById(RepastFamily repastFamily) {
        return repastFamilyMapper.updateById(repastFamily);
    }

    @Override
    public int insertOrUpdate(RepastFamily repastFamily) {
        return repastFamilyMapper.insertOrUpdate(repastFamily);
    }

    @Override
    public List<RepastVo> getByExample(RepastVo repastVo,int page, int limit) {
        PageHelper.startPage(page, limit);
        return repastMapper.selectByExample(repastVo);
    }

    @Override
    public RepastVo getById(Integer id) {
        return repastMapper.selectById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return repastMapper.deleteById(id);
    }

    @Override
    public int updateById(Repast repast) {
        return repastMapper.updateById(repast);
    }

    @Override
    public int insertOrUpdate(Repast repast) {
        return repastMapper.insertOrUpdate(repast);
    }
}
