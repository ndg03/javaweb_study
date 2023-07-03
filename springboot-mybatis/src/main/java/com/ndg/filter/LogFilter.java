package com.ndg.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @className:      LogFilter
 * @author:     ndg
 * @date:    2023/6/30 16:34
 */
@Component //该注解的作用是将当前类的 对象 存放到spring 让他管理
@WebFilter("/*") //表示拦截所有请求
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器------控制层方法执行前打印日志1");
        Map<String,String[]> map = servletRequest.getParameterMap();
        map.entrySet()
                .stream()
                .forEach(entry-> System.out.println(entry.getKey() + ":"+
                        Arrays.toString(entry.getValue())));
        //放行请求 ，如果不执行该方法，就执行到这里
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器------执行完成之后 打印日志 2");
    }
}
