package nankai.xl.common.interceptor;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogHandlerInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LogHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("请求 URL:" + request.getRequestURI());
        log.info("请求参数:" + JSONUtil.toJsonStr(request.getParameterMap()));
        return true;
    }
}