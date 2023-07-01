package com.ndg.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @className:      LoginFilter
 * @author:     ndg
 * @date:    2023/6/30 16:45
 */
@Component
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("登录验证~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("登录逻辑处理之后执行~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~·");
    }
}
