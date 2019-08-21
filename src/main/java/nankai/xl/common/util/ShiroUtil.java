package nankai.xl.common.util;

import nankai.xl.system.model.Adminuser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShiroUtil {

    public static final String USER_LOCK = "0";

    private static String superAdminUsername;

    private static Integer passwordRetryCount;

    private static Boolean loginVerify;

    public static String getSuperAdminUsername() {
        return superAdminUsername;
    }

    public static Integer getPasswordRetryCount() {
        return passwordRetryCount;
    }

    public static Boolean getLoginVerify() {
        return loginVerify;
    }

    @Value("${security.super-admin.username:admin}")
    public void setSuperAdminUsername(String superAdminUsername) {
        this.superAdminUsername = superAdminUsername;
    }

    @Value("${security.retry.count:5}")
    public void setPasswordRetryCount(Integer passwordRetryCount) {
        this.passwordRetryCount = passwordRetryCount;
    }

    @Value("${security.login.verify:false}")
    public void setLoginVerify(Boolean loginVerify) {
        ShiroUtil.loginVerify = loginVerify;
    }


    /**
     * 获取当前登录用户.
     */
    public static Adminuser getCurrentUser() {
        Adminuser adminuser = (Adminuser) SecurityUtils.getSubject().getPrincipal();
        if (adminuser == null) {
            throw new UnauthenticatedException("未登录被拦截");
        }
        return adminuser;
    }
}
