package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author okcgogogo
 * @date 2021/2/3 15:08
 */
@Slf4j
public class ControllerInterceptor implements HandlerInterceptor {
    private ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        StopWatch sw = new StopWatch();
        stopWatchThreadLocal.set(sw);
        sw.start();
        log.info("requestURI:[{}], method:[{}]--start", request.getRequestURI(), getMethod(handler));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        StopWatch sw = stopWatchThreadLocal.get();
        sw.stop();
        log.info("requestURI:[{}], method:[{}]--end, cost:[{}s]", request.getRequestURI(), getMethod(handler), sw.getTotalTimeSeconds());
        stopWatchThreadLocal.remove();
    }

    private String getMethod(Object handler) {
        String method = "";
        if (handler instanceof HandlerMethod) {
            String beanType = ((HandlerMethod) handler).getBeanType().getSimpleName();
            String methodName = ((HandlerMethod) handler).getMethod().getName();
            method = beanType + "." + methodName;
        }
        return method;
    }
}
