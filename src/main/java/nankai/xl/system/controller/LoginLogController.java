package nankai.xl.system.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.system.model.LoginLog;
import nankai.xl.system.service.LoginLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/log/login")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @GetMapping("/index")
    public String index() {
        return "log/login-logs";
    }

    @OperationLog("查看登录日志")
    @GetMapping("/list")
    @ResponseBody
    public PageResultBean<LoginLog> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestParam(value = "limit", defaultValue = "10")int limit) {
        List<LoginLog> loginLogs = loginLogService.selectAll(page, limit);
        PageInfo<LoginLog> rolePageInfo = new PageInfo<>(loginLogs);
        return new PageResultBean<>(rolePageInfo.getTotal(), rolePageInfo.getList());
    }
}
