package nankai.xl.system.service;

import com.github.pagehelper.PageHelper;
import nankai.xl.common.exception.DuplicateNameException;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.common.util.TreeUtil;
import nankai.xl.system.mapper.AdminuserMapper;
import nankai.xl.system.mapper.UserRoleMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Menu;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminuserService {

    private static final Logger log = LoggerFactory.getLogger(AdminuserService.class);

    @Resource
    private AdminuserMapper adminuserMapper;

    @Resource
    private MenuService menuService;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private SessionDAO sessionDAO;

    public List<Adminuser> selectAllWithDept(int page, int rows) {
        PageHelper.startPage(page, rows);
        return adminuserMapper.selectAllWithDept();
    }

    public Integer[] selectRoleIdsById(Integer userId) {
        return adminuserMapper.selectRoleIdsByUserId(userId);
    }

    @Transactional
    public Integer add(Adminuser adminuser, Integer[] roleIds) {
        checkUserNameExistOnCreate(adminuser.getUsername());
        String salt = generateSalt();
        String encryptPassword = new Md5Hash(adminuser.getPassword(), salt).toString();

        adminuser.setSalt(salt);
        adminuser.setPassword(encryptPassword);
        adminuserMapper.insert(adminuser);

        grantRole(adminuser.getUserId(), roleIds);

        return adminuser.getUserId();
    }

    public void updateLastLoginTimeByUsername(String username) {
        adminuserMapper.updateLastLoginTimeByUsername(username);
    }

    public boolean disableUserByID(Integer id) {
//        offlineByUserId(id); // 加上这段代码, 禁用用户后, 会将当前在线的用户立即踢出.
        return adminuserMapper.updateStatusByPrimaryKey(id, 0) == 1;
    }

    public boolean enableUserByID(Integer id) {
        return adminuserMapper.updateStatusByPrimaryKey(id, 1) == 1;
    }

    /**
     * 根据用户 ID 激活账号.
     * @param userId    用户 ID
     */
    public void activeUserByUserId(Integer userId) {
        adminuserMapper.activeUserByUserId(userId);
    }

    @Transactional
    public boolean update(Adminuser adminuser, Integer[] roleIds) {
        checkUserNameExistOnUpdate(adminuser);
        grantRole(adminuser.getUserId(), roleIds);
        return adminuserMapper.updateByPrimaryKeySelective(adminuser) == 1;
    }

    public Adminuser selectOne(Integer id) {
        return adminuserMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增时校验用户名是否重复
     * @param username  用户名
     */
    public void checkUserNameExistOnCreate(String username) {
        if (adminuserMapper.countByUserName(username) > 0) {
            throw new DuplicateNameException();
        }
    }

    public void checkUserNameExistOnUpdate(Adminuser adminuser) {
        if (adminuserMapper.countByUserNameNotIncludeUserId(adminuser.getUsername(), adminuser.getUserId()) > 0) {
            throw new DuplicateNameException();
        }
    }

    public void offlineBySessionId(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        if (session != null) {
            log.debug("成功踢出 sessionId 为 :" + sessionId + "的用户.");
            session.stop();
            sessionDAO.delete(session);
        }
    }

    /**
     * 删除所有此用户的在线用户
     */
    public void offlineByUserId(Integer userId) {
        Collection<Session> activeSessions = sessionDAO.getActiveSessions();
        for (Session session : activeSessions) {
            SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (simplePrincipalCollection != null) {
                Adminuser adminuser = (Adminuser) simplePrincipalCollection.getPrimaryPrincipal();
                if (adminuser != null && userId.equals(adminuser.getUserId())) {
                    offlineBySessionId(String.valueOf(session.getId()));
                }
            }
        }
    }

    @Transactional
    public void grantRole(Integer userId, Integer[] roleIds) {
        if (roleIds == null || roleIds.length == 0) {
            throw new IllegalArgumentException("赋予的角色数组不能为空.");
        }
        // 清空原有的角色, 赋予新角色.
        userRoleMapper.deleteUserRoleByUserId(userId);
        userRoleMapper.insertList(userId, roleIds);
    }

    public Adminuser selectByActiveCode(String activeCode) {
        return adminuserMapper.selectByActiveCode(activeCode);
    }

    public int count() {
        return adminuserMapper.count();
    }

    @Transactional
    public void delete(Integer userId) {
        // 检查删除的是否是超级管理员, 如果是, 则不允许删除.
        Adminuser adminuser = adminuserMapper.selectByPrimaryKey(userId);
        if (ShiroUtil.getSuperAdminUsername().equals(adminuser.getUsername())) {
            throw new UnauthorizedException("试图删除超级管理员, 被禁止.");
        }
        adminuserMapper.deleteByPrimaryKey(userId);
        userRoleMapper.deleteUserRoleByUserId(userId);
    }

    /**
     * 获取用户拥有的所有菜单权限和操作权限.
     * @param username      用户名
     * @return              权限标识符号列表
     */
    public Set<String> selectPermsByUsername(String username) {
        Set<String> perms = new HashSet<>();
        List<Menu> menuTreeVOS = menuService.selectMenuTreeVOByUsername(username);
        List<Menu> leafNodeMenuList = TreeUtil.getAllLeafNode(menuTreeVOS);
        for (Menu menu : leafNodeMenuList) {
            perms.add(menu.getPerms());
        }
        perms.addAll(adminuserMapper.selectOperatorPermsByUserName(username));
        return perms;
    }

    public Set<String> selectRoleNameByUserName(String username) {
        return adminuserMapper.selectRoleNameByUserName(username);
    }

    public Adminuser selectOneByUserName(String username) {
        return adminuserMapper.selectOneByUserName(username);
    }

    public void updatePasswordByUserId(Integer userId, String password) {
        String salt = generateSalt();
        String encryptPassword = new Md5Hash(password, salt).toString();
        adminuserMapper.updatePasswordByUserId(userId, encryptPassword, salt);
    }

    private String generateSalt() {
        return String.valueOf(System.currentTimeMillis());
    }
}