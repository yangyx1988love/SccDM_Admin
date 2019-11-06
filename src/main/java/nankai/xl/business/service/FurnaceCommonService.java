package nankai.xl.business.service;

import nankai.xl.business.model.Boiler;
import nankai.xl.business.model.Kiln;
import nankai.xl.business.model.vo.BoilerVo;
import nankai.xl.business.model.vo.KilnVo;
import nankai.xl.business.model.vo.SumVo;

import java.util.List;

public interface FurnaceCommonService {
    //锅炉服务
    Boiler getBoilerById(Integer id);
    List<Boiler> getBoilersByExhustId(Integer exhustId);
    List<BoilerVo> getBoilersByFactoryId(Integer factoryId);
    int updateBoilerById(Boiler boiler);
    int insertOrUpdateBoiler(Boiler boiler);
    //窑炉服务
    Kiln getKilnById(Integer id);
    List<Kiln> getKilnsByExhustId(Integer exhustId);
    List<KilnVo> getKilnsByFactoryId(Integer factoryId);
    int updateKilnById(Kiln kiln);
    int insertOrUpdateKiln(Kiln kiln);

    //按城市统计锅炉数量
    public List<SumVo> countBoilerByCity();
    public List<SumVo> countBoilerByCounty();
    //按城市统计窑炉数量
    public List<SumVo> countKilnByCity();
    public List<SumVo> countKilnByCounty();
}
