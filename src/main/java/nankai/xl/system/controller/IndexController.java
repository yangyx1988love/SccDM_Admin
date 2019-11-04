package nankai.xl.system.controller;

import nankai.xl.business.model.Status;
import nankai.xl.business.service.FactoryService;
import nankai.xl.business.service.SelectCommonService;
import nankai.xl.business.service.SourceService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.ResultBean;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.Menu;
import nankai.xl.system.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @Resource
    private FactoryService factoryService;
    @Resource
    private SourceService sourceService;
    @Resource
    private SelectCommonService selectCommonService;

    @GetMapping(value = {"/", "/main"})
    public String index(Model model) {
        List<Menu> menuTreeVOS = menuService.selectCurrentUserMenuTree();
        model.addAttribute("menus", menuTreeVOS);
        return "index";
    }

    @OperationLog("访问我的桌面")
    @GetMapping("/welcome")
    public String welcome(Model model) {
//        int userCount = adminuserService.count();
//        int roleCount = roleService.count();
//        int menuCount = menuService.count();
//        int loginLogCount = loginLogService.count();
//        int sysLogCount = sysLogService.count();
//        int userOnlineCount = adminuserOnlineService.count();
//
//        model.addAttribute("userCount", userCount);
//        model.addAttribute("roleCount", roleCount);
//        model.addAttribute("menuCount", menuCount);
//        model.addAttribute("loginLogCount", loginLogCount);
//        model.addAttribute("sysLogCount", sysLogCount);
//        model.addAttribute("userOnlineCount", userOnlineCount);
        Adminuser user = ShiroUtil.getCurrentUser();
        if (user.getDeptId()!=null){
            model.addAttribute("nonAuthFactorys",factoryService.getNonAuthFactoryNumByuser(user));
            Map<String, String> map=selectCommonService.getCityAndCountyCodeByuser(user);
            String cityCode=map.get("cityCode");
            String countyCode=map.get("countyCode");
            model.addAttribute("fixedSourceNum",sourceService.getFixedSourceNum(cityCode,countyCode));
            model.addAttribute("processSourceNum",sourceService.getProcessSourceNum(cityCode,countyCode));
            model.addAttribute("solventSourceNum",sourceService.getSolventSourceNum(cityCode,countyCode));
            model.addAttribute("dustSourceNum",sourceService.getDustSourceNum(cityCode,countyCode));
            model.addAttribute("transportSourceNum",sourceService.getTransportSourceNum(cityCode,countyCode));
            model.addAttribute("farmSourceNum",sourceService.getFarmSourceNum(cityCode,countyCode));
            model.addAttribute("biomassSourceNum",sourceService.getBiomassSourceNum(cityCode,countyCode));
            model.addAttribute("roadSourceNum",sourceService.getRoadSourceNum(cityCode,countyCode));
            model.addAttribute("nonRoadSourceNum",sourceService.getNonRoadSourceNum(cityCode,countyCode));
            model.addAttribute("repastSourceNum",sourceService.getRepastSourceNum(cityCode,countyCode));
        }else {
            throw new IllegalArgumentException("用户赋予的部门不能为空！");
        }
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
