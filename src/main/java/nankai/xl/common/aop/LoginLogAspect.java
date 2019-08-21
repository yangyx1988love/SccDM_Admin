package nankai.xl.common.aop;

import nankai.xl.common.util.IPUtils;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.service.LoginLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
@ConditionalOnProperty(value = "log.login", havingValue = "true")
public class LoginLogAspect {

    @Resource
    private LoginLogService loginLogService;

    @Pointcut("execution(nankai.xl.common.util.ResultBean nankai.xl.system.controller..LoginController.login(nankai.xl.system.model.Adminuser, String) )")
    public void loginLogPointCut() {}


    @After("loginLogPointCut()")
    public void recordLoginLog(JoinPoint joinPoint) {
        // 获取登陆参数
        Object[] args = joinPoint.getArgs();
        Adminuser user = (Adminuser) args[0];

        Subject subject = SecurityUtils.getSubject();

        String ip = IPUtils.getIpAddr();
        loginLogService.addLog(user.getUsername(), subject.isAuthenticated(), ip);
    }
}
