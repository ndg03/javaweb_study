package com.ndg.config;

import com.ndg.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @className: MyInterceptorConfig
 * @author: ndg
 * @date: 2023/7/3 9:24
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**","/main")//添加需要拦截的路径，其中 /**  表示拦截所有请求
                .excludePathPatterns("/login","/register","/allEmployee") //括号中的参数 是不拦截的路径
                .order(1);//设置拦截器 拦截的顺序
    }
}
