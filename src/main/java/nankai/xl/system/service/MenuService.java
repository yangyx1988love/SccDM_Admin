package nankai.xl.system.service;

import nankai.xl.common.util.ShiroUtil;
import nankai.xl.common.util.TreeUtil;
import nankai.xl.system.mapper.MenuMapper;
import nankai.xl.system.mapper.OperatorMapper;
import nankai.xl.system.mapper.RoleMenuMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private OperatorMapper operatorMapper;

    /**
     * 获取所有菜单
     */
    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }
    //用于文件上传
    public List<Menu> selectSourceMeus(Integer parentId){return menuMapper.selectByParentId(parentId);}
    /**
     * 根据父 ID 获取所有菜单
     */
    public List<Menu> selectByParentId(Integer parentId) {
        return menuMapper.selectByParentId(parentId);
    }

    public Menu selectByPrimaryKey(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有菜单 (树形结构)
     */
    public List<Menu> getALLMenuTree() {
        List<Menu> menus = selectAll();
        return toTree(menus);
    }

    /**
     * 获取所有菜单并添加一个根节点 (树形结构)
     */
    public List<Menu> getALLMenuTreeAndRoot() {
        List<Menu> allMenuTree = getALLMenuTree();
        return addRootNode("导航目录", 0, allMenuTree);
    }

    /**
     * 获取所有菜单并统计菜单下的操作权限数 (树形结构)
     */
    public List<Menu> getALLMenuAndCountOperatorTree() {
        List<Menu> menus = menuMapper.selectAllMenuAndCountOperator();
        return toTree(menus);
    }

    /**
     * 获取当前登陆用户拥有的树形菜单 (admin 账户拥有所有权限.)
     */
    public List<Menu> selectCurrentUserMenuTree() {
        Adminuser adminuser = ShiroUtil.getCurrentUser();
        List<Menu> menus;
        if (ShiroUtil.getSuperAdminUsername().equals(adminuser.getUsername())) {
            menus = menuMapper.selectAll();
        } else {
            menus = menuMapper.selectMenuByUserName(adminuser.getUsername());
        }
        return toTree(menus);
    }

    /**
     * 获取指定用户拥有的树形菜单 (admin 账户拥有所有权限.)
     */
    public List<Menu> selectMenuTreeVOByUsername(String username) {
        List<Menu> menus;
        if (ShiroUtil.getSuperAdminUsername().equals(username)) {
            menus = menuMapper.selectAll();
        } else {
            menus = menuMapper.selectMenuByUserName(username);
        }
        return toTree(menus);
    }

    /**
     * 获取导航菜单中的所有叶子节点
     */
    public List<Menu> getLeafNodeMenu() {
        List<Menu> allMenuTreeVO = getALLMenuTree();
        return TreeUtil.getAllLeafNode(allMenuTreeVO);
    }

    public void insert(Menu menu) {
        int maxOrderNum = menuMapper.selectMaxOrderNum();
        menu.setOrderNum(maxOrderNum + 1);
        menuMapper.insert(menu);
    }

    public void updateByPrimaryKey(Menu menu) {
        menuMapper.updateByPrimaryKey(menu);
    }


    /**
     * 删除当前菜单以及其子菜单
     */
    @Transactional
    public void deleteByIDAndChildren(Integer menuId) {
        // 删除子菜单
        List<Integer> childIDList = menuMapper.selectChildrenIDByPrimaryKey(menuId);
        for (Integer childID : childIDList) {
            deleteByIDAndChildren(childID);
        }
        // 删除菜单下的操作权限
        operatorMapper.deleteByMenuId(menuId);
        // 删除分配给用户的菜单
        roleMenuMapper.deleteByMenuId(menuId);
        // 删除自身
        menuMapper.deleteByPrimaryKey(menuId);
    }

    public int count() {
        return menuMapper.count();
    }

    public void swapSort(Integer currentId, Integer swapId) {
        menuMapper.swapSort(currentId, swapId);
    }

    /**
     * 转换为树形结构
     */
    private List<Menu> toTree(List<Menu> menuList) {
        return TreeUtil.toTree(menuList, "menuId", "parentId", "children", Menu.class);
    }

    public List<Menu> getALLMenuAndCountOperatorTreeAndRoot() {
        List<Menu> menus = getALLMenuAndCountOperatorTree();
        return addRootNode("导航目录", 0, menus);
    }

    /**
     * 将树形结构添加到一个根节点下.
     */
    private List<Menu> addRootNode(String rootName, Integer rootId, List<Menu> children) {
        Menu root = new Menu();
        root.setMenuId(rootId);
        root.setMenuName(rootName);
        root.setChildren(children);
        List<Menu> rootList = new ArrayList<>();
        rootList.add(root);
        return rootList;
    }
}