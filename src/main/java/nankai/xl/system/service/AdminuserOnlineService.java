package nankai.xl.system.service;

import nankai.xl.common.util.IPUtils;
import nankai.xl.system.model.Adminuser;
import nankai.xl.system.model.AdminuserOnline;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AdminuserOnlineService {

    @Resource
    private SessionDAO sessionDAO;

    public List<AdminuserOnline> list() {
        List<AdminuserOnline> list = new ArrayList<>();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            AdminuserOnline adminuserOnline = new AdminuserOnline();
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
                continue;
            } else {
                SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) session
                        .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                Adminuser adminuser = (Adminuser) principalCollection.getPrimaryPrincipal();
                adminuserOnline.setUsername(adminuser.getUsername());
                adminuserOnline.setUserId(adminuser.getUserId());
            }
            adminuserOnline.setId((String) session.getId());
            adminuserOnline.setIp(IPUtils.getIpAddr());
            adminuserOnline.setStartTimestamp(session.getStartTimestamp());
            adminuserOnline.setLastAccessTime(session.getLastAccessTime());
            Long timeout = session.getTimeout();
            if (timeout == 0L) {
                adminuserOnline.setStatus("离线");
            } else {
                adminuserOnline.setStatus("在线");
            }
            adminuserOnline.setTimeout(timeout);
            list.add(adminuserOnline);
        }
        return list;
    }

    public void forceLogout(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        if (session != null) {
            session.stop();
            session.stop();
            sessionDAO.delete(session);
        }
    }

    public int count() {
        int count = 0;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) != null) {
                count++;
            }
        }
        return count;
    }
}
