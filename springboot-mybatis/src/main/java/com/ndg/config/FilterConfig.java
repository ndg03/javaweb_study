package com.ndg.config;

import com.ndg.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @className:       FilterConfig
 * @author:          ndg
 * @date:            2023/6/30 16:50
 */
@Configuration //表示该类是一个配置类，并将该类存放到spring容器中去
public class FilterConfig {
    @Bean //将该方法返回的对象 存放到spring 容器中
    public FilterRegistrationBean<Filter> baseFilter(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoginFilter());
        registrationBean.addUrlPatterns("/*","/user");//拦截的路径
        registrationBean.setOrder(1);//拦截的顺序
        return registrationBean;
    }
}
