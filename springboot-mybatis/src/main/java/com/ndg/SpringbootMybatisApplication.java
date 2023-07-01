package com.ndg;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // 默认扫描范围 启动类所在包 及其子包
//@ComponentScan({"mapper","com.ndg"}) //设置扫描范围，覆盖了 默认的扫描范围  --> 不推荐使用
// 将该包下的所有类的代理实现注入到 spring容器中
//@MapperScan(basePackages = "com.ndg.mapper")
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
