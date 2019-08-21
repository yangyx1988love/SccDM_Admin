package nankai.xl.system.service;

import com.github.pagehelper.PageHelper;
import nankai.xl.common.util.ShiroUtil;
import nankai.xl.system.mapper.LoginLogMapper;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.LoginLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 登陆日志 Service
 */
@Service
public class LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    public void addLog(String username, boolean isAuthenticated, String ip) {
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginTime(new Date());
        loginLog.setUsername(username);
        loginLog.setLoginStatus(isAuthenticated ? "1" : "0");
        loginLog.setIp(ip);
        loginLogMapper.insert(loginLog);
    }

    /**
     * 最近一周登陆次数
     */
    public List<Integer> recentlyWeekLoginCount() {
        Adminuser adminuser = ShiroUtil.getCurrentUser();
        return loginLogMapper.recentlyWeekLoginCount(adminuser.getUsername());
    }

    public List<LoginLog> selectAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        return loginLogMapper.selectAll();
    }

    public int count() {
        return loginLogMapper.count();
    }
}