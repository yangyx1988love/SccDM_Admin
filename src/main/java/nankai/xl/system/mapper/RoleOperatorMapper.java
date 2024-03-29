package nankai.xl.system.mapper;

import nankai.xl.system.model.RoleOperator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleOperatorMapper {
    int insert(RoleOperator roleOperator);

    int insertSelective(RoleOperator roleOperator);

    Integer[] getOperatorsByRoleId(Integer roleId);

    int deleteByRoleId(@Param("roleId")Integer roleId);

    int insertRoleOperators(@Param("roleId")Integer roleId, @Param("operatorIds")Integer[] operatorIds);

    int deleteByOperatorId(@Param("operatorId")Integer operatorId);
}