package com.example.springboot_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/*
1.公共的类
2.私有的属性
3.公共的get set方法
4.无参的构造器
 */


@Component //将当前类的对象存放到spring容器
@Data //会自动加上  get set方法
@ToString
@AllArgsConstructor //全参数构造器
@NoArgsConstructor //无参数构造器
public class Cat {
    //通过spring表达式 直接引用配置文件中配置的属性
    @Value("${user.username}")
    private String username;
    @Value("${color}")
    private String color;


}
