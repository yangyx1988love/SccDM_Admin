package nankai.xl.system.mapper;

import nankai.xl.system.model.Operator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperatorMapper {
    int deleteByPrimaryKey(Integer operatorId);

    int insert(Operator operator);

    int insertSelective(Operator operator);

    Operator selectByPrimaryKey(Integer operatorId);

    int updateByPrimaryKeySelective(Operator operator);

    int updateByPrimaryKey(Operator operator);

    List<Operator> selectByMenuId(@Param("menuId")Integer menuId);

    List<Operator> selectAll();

    int deleteByMenuId(Integer menuId);
}