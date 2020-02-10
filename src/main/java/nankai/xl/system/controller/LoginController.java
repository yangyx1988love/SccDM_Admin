package nankai.xl.system.controller;

import cn.hutool.core.util.IdUtil;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.exception.CaptchaIncorrectException;
import nankai.xl.common.util.CaptchaUtil;
import nankai.xl.common.util.ResultBean;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.service.AdminuserService;
import nankai.xl.system.service.MailService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class LoginController {

    @Resource
    private AdminuserService adminuserService;

    @Resource
    private MailService mailService;

    @Resource
    private TemplateEngine templateEngine;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginVerify", ShiroUtil.getLoginVerify());
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultBean login(Adminuser user, @RequestParam(value = "captcha", required = false) String captcha) {
        Subject subject = SecurityUtils.getSubject();

        // 如果开启了登录校验
        if (ShiroUtil.getLoginVerify()) {
            String realCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute("captcha");
            // session 中的验证码过期了
            if (realCaptcha == null || !realCaptcha.equals(captcha.toLowerCase())) {
                throw new CaptchaIncorrectException();
            }
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);
        adminuserService.updateLastLoginTimeByUsername(user.getUsername());
        return ResultBean.success("登录成功");
    }

    @OperationLog("注销")
    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:login";
    }

    @PostMapping("/register")
    @ResponseBody
    public ResultBean register(Adminuser user) {
        adminuserService.checkUserNameExistOnCreate(user.getUsername());
        String activeCode = IdUtil.fastSimpleUUID();
        user.setActiveCode(activeCode);
        user.setStatus("0");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getScheme() + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + "/active/"
                + activeCode;
        Context context = new Context();
        context.setVariable("url", url);
        String mailContent = templateEngine.process("/mail/registerTemplate", context);
        new Thread(() ->
                mailService.sendHTMLMail(user.getEmail(), "污染源清单管理系统 激活邮件", mailContent))
                .start();

        // 注册后默认的角色, 根据自己数据库的角色表 ID 设置
        Integer[] initRoleIds = {1};
        return ResultBean.success(adminuserService.add(user, initRoleIds));
    }

    @GetMapping("/captcha")
    public void captcha(HttpServletResponse response) throws IOException {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CaptchaUtil.Captcha captcha = CaptchaUtil.createCaptcha(140, 38, 4, 10, 30);
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("captcha", captcha.getCode());

        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(captcha.getImage(), "png", os);
    }

    @OperationLog("激活注册账号")
    @GetMapping("/active/{token}")
    public String active(@PathVariable("token") String token, Model model) {
        Adminuser user = adminuserService.selectByActiveCode(token);
        String msg;
        if (user == null) {
            msg = "请求异常, 激活地址不存在!";
        } else if ("1".equals(user.getStatus())) {
            msg = "用户已激活, 请勿重复激活!";
        } else {
            msg = "激活成功!";
            user.setStatus("1");
            adminuserService.activeUserByUserId(user.getUserId());
        }
        model.addAttribute("msg", msg);
        return "active";
    }
    @GetMapping("/forget")
    public String forget() {
        return "forget";
    }
    @PostMapping("/forget/{username}")
    @ResponseBody
    public ResultBean forget(@PathVariable("username") String username,Adminuser user,Model model) {
        Adminuser userr = adminuserService.selectOneByUserName(username);
        String activeCode = IdUtil.fastSimpleUUID();
        user.setUserId(userr.getUserId());
        user.setActiveCode(activeCode);
        String mailContent="验证码:"+activeCode;
        new Thread(() ->
                mailService.sendHTMLMail(userr.getEmail(), "污染源清单管理系统 密码找回邮件", mailContent))
                .start();
        model.addAttribute("userId", user.getUserId());
        return ResultBean.success(adminuserService.update(user));
    }
    @PutMapping("/forget/{activeCode}")
    @ResponseBody
    public ResultBean forget(@PathVariable("activeCode") String activeCode,Adminuser user) {
        Adminuser userr=adminuserService.selectOneByUserName(user.getUsername());
        if(userr.getActiveCode().equals(activeCode)){
            user.setActiveCode(IdUtil.fastSimpleUUID());
            adminuserService.update(user);
        }else {
            return ResultBean.error("验证码已使用！请重新获取邮箱验证码！！");
        }
        return ResultBean.success();
    }
}
