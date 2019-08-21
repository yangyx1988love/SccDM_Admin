package nankai.xl.system.mapper;

import nankai.xl.system.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role role);

    int insertSelective(Role role);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role role);

    int updateByPrimaryKey(Role role);

    List<Role> selectAll();

    int count();
}