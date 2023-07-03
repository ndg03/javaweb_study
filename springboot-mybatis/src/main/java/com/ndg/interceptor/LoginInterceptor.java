package com.ndg.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @className: LoginInterceptor
 * @author: ndg
 * @date: 2023/7/3 9:11
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String,String[]>> entries = map.entrySet();//key  value
        entries.stream().forEach(stringEntry -> System.out.println(stringEntry.getKey() + ":" + Arrays.toString(stringEntry.getValue())));
        System.out.println("拦截器------在控制层方法执行前执行");
        // 如果return的值为 true则放行请求，如果为false 则拦截请求
        //return HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("拦截器------在控制层 方法执行之后 ，在视图返回给客户端之前执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("拦截器------所有方法执行完后，执行");
    }
}
