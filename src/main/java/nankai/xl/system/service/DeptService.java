package nankai.xl.system.service;

import nankai.xl.common.util.TreeUtil;
import nankai.xl.system.mapper.DeptMapper;
import nankai.xl.system.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeptService {

    @Resource
    private DeptMapper deptMapper;

    public int deleteByPrimaryKey(String deptId) {
        return deptMapper.deleteByPrimaryKey(deptId);
    }

    public int insert(Dept dept) {
        int maxOrderNum = deptMapper.selectMaxOrderNum();
        dept.setOrderNum(maxOrderNum + 1);
        return deptMapper.insert(dept);
    }

    public int insertSelective(Dept dept) {
        return deptMapper.insertSelective(dept);
    }

    public Dept selectByPrimaryKey(String deptId) {
        return deptMapper.selectByPrimaryKey(deptId);
    }

    public int updateByPrimaryKeySelective(Dept dept) {
        return deptMapper.updateByPrimaryKeySelective(dept);
    }

    public int updateByPrimaryKey(Dept dept) {
        return deptMapper.updateByPrimaryKey(dept);
    }

    public void deleteByIDAndChildren(String deptId) {
        // 删除子节点
        List<String> childIDList = deptMapper.selectChildrenIDByPrimaryKey(deptId);
        for (String childId : childIDList) {
            deleteByIDAndChildren(childId);
        }
        // 删除自身
        deleteByPrimaryKey(deptId);
    }

    public List<Dept> selectByParentId(String parentId) {
        return deptMapper.selectByParentId(parentId);
    }

    /**
     * 查找所有的部门
     */
    public List<Dept> selectAllDept() {
        return deptMapper.selectAll();
    }

    /**
     * 查找所有的部门的树形结构
     */
    public List<Dept> selectAllDeptTree() {
        return toTree(selectAllDept());
    }

    /**
     * 获取所有菜单并添加一个根节点 (树形结构)
     */
    public List<Dept> selectAllDeptTreeAndRoot() {
        List<Dept> deptList = toTree(selectAllDept());
        Dept root = new Dept();
        root.setDeptId("0");
        root.setDeptName("根部门");
        root.setChildren(deptList);
        List<Dept> rootList = new ArrayList<>();
        rootList.add(root);
        return rootList;
    }

    /**
     * 调用工具类, 将部门列表转化为部门树
     */
    private List<Dept> toTree(List<Dept> depts) {
        return TreeUtil.toTree(depts, "deptId", "parentId", "children", Dept.class);
    }

    public void swapSort(Integer currentId, Integer swapId) {
        deptMapper.swapSort(currentId, swapId);
    }
}
