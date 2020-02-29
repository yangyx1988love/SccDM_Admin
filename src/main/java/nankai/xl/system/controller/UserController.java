package nankai.xl.system.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ResultBean;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.common.validate.groups.Create;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.vo.PasswordVO;
import nankai.xl.system.service.AdminuserService;
import nankai.xl.system.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private AdminuserService userService;

    @Resource
    private RoleService roleService;

    @GetMapping("/index")
    public String index() {
        return "user/user-list";
    }

    @OperationLog("获取用户列表")
    @GetMapping("/list")
    @ResponseBody
    public PageResultBean<Adminuser> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "limit", defaultValue = "10")int limit) {
        List<Adminuser> users = userService.selectAllWithDept(page, limit);
        PageInfo<Adminuser> userPageInfo = new PageInfo<>(users);
        return new PageResultBean<>(userPageInfo.getTotal(), userPageInfo.getList());
    }

    @GetMapping
    public String add(Model model) {
        Adminuser currtUser = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        Integer[] roleIds=userService.selectRoleIdsById(currtUser.getUserId());
        if (ShiroUtil.getSuperAdminUsername().equals(currtUser.getUsername())){
            model.addAttribute("roles", roleService.selectAll());
        }else{
            model.addAttribute("roles", roleService.selectLessById(roleIds[0]));
        }
        return "user/user-add";
    }

    @GetMapping("/{userId}")
    public String update(@PathVariable("userId") Integer userId, Model model) {
        Integer[] roleIds=userService.selectRoleIdsById(userId);
        model.addAttribute("roleIds",roleIds );
        model.addAttribute("user", userService.selectOne(userId));
        Adminuser currtUser = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        if (ShiroUtil.getSuperAdminUsername().equals(currtUser.getUsername())){
            model.addAttribute("roles", roleService.selectAll());
        }else{
            model.addAttribute("roles", roleService.selectLessById(userService.selectRoleIdsById(currtUser.getUserId())[0]));
        }
        return "user/user-add";
    }
    @GetMapping("/currtUser")
    public String updatecurrtUser(Model model) {
        Adminuser currtUser = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        currtUser=userService.selectOne(currtUser.getUserId());
        model.addAttribute("user", currtUser);
        return "user/user-edit";
    }

    @OperationLog("编辑角色")
    @PutMapping
    @ResponseBody
    public ResultBean update(@Valid Adminuser user, @RequestParam(value = "role[]", required = false) Integer roleIds[]) {
        Adminuser currtUser = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        if (currtUser.getUserId().equals(user.getUserId())){
            currtUser=user;
        }
        userService.update(user, roleIds);
        return ResultBean.success();
    }
    @OperationLog("编辑用户基本信息")
    @PutMapping("/currtUser")
    @ResponseBody
    public ResultBean updateCurrtuser(@Valid Adminuser user) {
        userService.update(user);
        return ResultBean.success();
    }

    @OperationLog("新增用户")
    @PostMapping
    @ResponseBody
    public ResultBean add(@Validated(Create.class) Adminuser user, @RequestParam(value = "role[]", required = false) Integer roleIds[]) {
        return ResultBean.success(userService.add(user, roleIds));
    }

    @OperationLog("禁用账号")
    @PostMapping("/{userId}/disable")
    @ResponseBody
    public ResultBean disable(@PathVariable("userId") Integer userId) {
        return ResultBean.success(userService.disableUserByID(userId));
    }

    @OperationLog("激活账号")
    @PostMapping("/{userId}/enable")
    @ResponseBody
    public ResultBean enable(@PathVariable("userId") Integer userId) {
        return ResultBean.success(userService.enableUserByID(userId));
    }

    @OperationLog("删除账号")
    @DeleteMapping("/{userId}")
    @ResponseBody
    public ResultBean delete(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
        return ResultBean.success();
    }

    @GetMapping("/{userId}/reset")
    public String resetPassword(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("userId", userId);
        return "user/user-reset-pwd";
    }
    @OperationLog("重置密码")
    @PostMapping("/{userId}/reset")
    @ResponseBody
    public ResultBean resetPassword(@PathVariable("userId") Integer userId,String password) {
        userService.updatePasswordByUserId(userId,password);
        return ResultBean.success();
    }
    @GetMapping("/currtUser/reset")
    public String resetPasswordCurrtUser(Model model) {
        Adminuser currtUser = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("userId", currtUser.getUserId());
        return "user/currtuser-reset-pwd";
    }

    @OperationLog("重置密码")
    @PostMapping("/currtUser/{userId}/reset")
    @ResponseBody
    public ResultBean currtUserresetPassword(@PathVariable("userId") Integer userId,String oldpassword,String password) {
        Adminuser user=userService.selectOne(userId);
        String encryptPassword0 = new Md5Hash(oldpassword,user.getSalt()).toString();
        if (encryptPassword0.equals(user.getPassword())){
            userService.updatePasswordByUserId(userId,password);
        }else {
            return ResultBean.error("老密码输入错误！");
        }
        return ResultBean.success();
    }

}