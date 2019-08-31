package nankai.xl.system.controller;

import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.ResultBean;
import nankai.xl.system.model.Menu;
import nankai.xl.system.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private MenuService menuService;

    @Resource
    private LoginLogService loginLogService;

    @Resource
    private AdminuserService adminuserService;

    @Resource
    private RoleService roleService;

    @Resource
    private SysLogService sysLogService;

    @Resource
    private AdminuserOnlineService adminuserOnlineService;

    @GetMapping(value = {"/", "/main"})
    public String index(Model model) {
        List<Menu> menuTreeVOS = menuService.selectCurrentUserMenuTree();
        model.addAttribute("menus", menuTreeVOS);
        return "index";
    }

    @OperationLog("访问我的桌面")
    @GetMapping("/welcome")
    public String welcome(Model model) {
        int userCount = adminuserService.count();
        int roleCount = roleService.count();
        int menuCount = menuService.count();
        int loginLogCount = loginLogService.count();
        int sysLogCount = sysLogService.count();
        int userOnlineCount = adminuserOnlineService.count();

        model.addAttribute("userCount", userCount);
        model.addAttribute("roleCount", roleCount);
        model.addAttribute("menuCount", menuCount);
        model.addAttribute("loginLogCount", loginLogCount);
        model.addAttribute("sysLogCount", sysLogCount);
        model.addAttribute("userOnlineCount", userOnlineCount);
        return "welcome";
    }

    @OperationLog("查看近七日登录统计图")
    @GetMapping("/weekLoginCount")
    @ResponseBody
    public List<Integer> recentlyWeekLoginCount() {
        return loginLogService.recentlyWeekLoginCount();
    }

    @GetMapping("/clear")
    public ResultBean clear(Model model) {
//        Adminuser user = (Adminuser) SecurityUtils.getSubject().getPrincipal();
//        UserNameRealm userNameRealm=new UserNameRealm();
//        userNameRealm.clearAuthCacheByUserId(user.getUserId());
        return ResultBean.success("清除成功！");
    }
}
