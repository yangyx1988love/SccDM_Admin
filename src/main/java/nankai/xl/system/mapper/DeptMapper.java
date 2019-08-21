package nankai.xl.system.mapper;

import nankai.xl.system.model.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptMapper {
    int deleteByPrimaryKey(String deptId);

    int insert(Dept dept);

    int insertSelective(Dept dept);

    Dept selectByPrimaryKey(String deptId);

    int updateByPrimaryKeySelective(Dept dept);

    int updateByPrimaryKey(Dept dept);

    List<Dept> selectByParentId(@Param("parentId")String parentId);

    List<Dept> selectAll();

    List<String> selectChildrenIDByPrimaryKey(String deptId);

    int selectMaxOrderNum();

    int swapSort(@Param("currentId")Integer currentId, @Param("swapId")Integer swapId);
}