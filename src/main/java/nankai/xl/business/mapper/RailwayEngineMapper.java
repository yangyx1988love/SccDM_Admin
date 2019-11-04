package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.RailwayEngine;
import nankai.xl.business.model.vo.RailwayEngineVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RailwayEngineMapper {
    List<RailwayEngineVo> selectByExample(RailwayEngineVo railwayEngineVo);
    RailwayEngineVo selectById(Integer id);
    int deleteById(Integer id);
    int updateById(RailwayEngine railwayEngine);
    int insertOrUpdate(RailwayEngine railwayEngine);
    int insertSelective(RailwayEngine railwayEngine);
    int insertList(List<RailwayEngine> list);
}