package nankai.xl.business.service;

import nankai.xl.business.model.Repast;
import nankai.xl.business.model.RepastBarbecue;
import nankai.xl.business.model.RepastFamily;
import nankai.xl.business.model.vo.RepastBarbecueVo;
import nankai.xl.business.model.vo.RepastVo;

import java.util.List;

public interface RepastService {
    //烧烤
    List<RepastBarbecueVo> getByExample(RepastBarbecueVo repastBarbecueVo,int page, int limit);
    RepastBarbecueVo getBarbecueById(Integer id);
    int deleteBarbecueById(Integer id);
    int updateById(RepastBarbecue repastBarbecue);
    int insertOrUpdate(RepastBarbecue repastBarbecue);
    //家庭
    List<RepastFamily> getByExample(RepastFamily repastFamily,int page, int limit);
    RepastFamily getFamilyById(Integer id);
    int deleteFamilyById(Integer id);
    int updateById(RepastFamily repastFamily);
    int insertOrUpdate(RepastFamily repastFamily);
    //社会
    List<RepastVo> getByExample(RepastVo repastVo,int page, int limit);
    RepastVo getById(Integer id);
    int deleteById(Integer id);
    int updateById(Repast repast);
    int insertOrUpdate(Repast repast);
}
