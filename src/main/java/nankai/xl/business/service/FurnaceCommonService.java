package nankai.xl.business.service;

import nankai.xl.business.model.Boiler;
import nankai.xl.business.model.Kiln;
import nankai.xl.business.model.vo.BoilerSumVo;
import nankai.xl.business.model.vo.FactorySumCommonQuery;
import nankai.xl.business.model.vo.KilnSumVo;
import nankai.xl.business.model.vo.SumVo;
import nankai.xl.system.model.Adminuser;

import java.util.List;

public interface FurnaceCommonService {
    //锅炉服务
    Boiler getBoilerById(Integer id);
    List<Boiler> getBoilersByExhustId(Integer exhustId);
    List<Boiler> getBoilersByFactoryId(Integer factoryId);
    int updateBoilerById(Boiler boiler);
    List<BoilerSumVo> getSumBoilers(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<BoilerSumVo> getSumBoilers(Adminuser user, int page, int limit);
    //窑炉服务
    Kiln getKilnById(Integer id);
    List<Kiln> getKilnsByExhustId(Integer exhustId);
    List<Kiln> getKilnsByFactoryId(Integer factoryId);
    List<KilnSumVo> getSumKilns(FactorySumCommonQuery factorySumCommonQuery, int page, int limit);
    List<KilnSumVo> getSumKilns(Adminuser user, int page, int limit);
    int updateKilnById(Kiln kiln);

    //按城市统计锅炉数量
    public List<SumVo> countBoilerByCity();
    public List<SumVo> countBoilerByCounty();
    //按城市统计窑炉数量
    public List<SumVo> countKilnByCity();
    public List<SumVo> countKilnByCounty();
}
