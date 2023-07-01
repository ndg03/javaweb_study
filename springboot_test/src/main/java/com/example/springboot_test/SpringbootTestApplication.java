package com.example.springboot_test;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



//springboot启动类
//@SpringBootApplication springboot 配置类的核心注解，作用是将对象自动注入到spring 容器中
@SpringBootApplication
public class SpringbootTestApplication {

    public static void main(String[] args) {
        //代码初始化运行 创建spring容器并注入 对象代码
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootTestApplication.class, args);
        User bean = run.getBean(User.class);
        System.out.println("bean:" + bean);

        Log log = LogFactory.getLog(SpringbootTestApplication.class);
        log.trace("trace级别日志");
        log.debug("debug级别日志");
        log.info("info级别日志");
        log.warn("warn级别日志");
        log.error("error级别日志");
    }

}
