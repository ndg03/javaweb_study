package com.ndg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean //将密码加密器放到spring容器中 来管理 @Bean  需要在配置类 中使用
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();// 返回一个具体的密码加密器
    }
}
