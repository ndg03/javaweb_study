package com.ndg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @className: MySpringSecurityConfiger
 * @author: ndg
 * @date: 2023/7/5 13:47
 */
@Configuration
public class MySpringSecurityConfiger extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    //工厂方法

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //内存中设置用户名密码和角色
//        auth.inMemoryAuthentication().withUser("user1")
//                .password(passwordEncoder().encode("1234")).roles("manger");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
