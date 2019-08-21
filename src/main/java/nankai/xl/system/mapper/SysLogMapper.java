package nankai.xl.system.mapper;

import nankai.xl.system.model.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLog sysLog);

    int insertSelective(SysLog sysLog);

    SysLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLog sysLog);

    int updateByPrimaryKey(SysLog sysLog);

    List<SysLog> selectAll();

    int count();
}