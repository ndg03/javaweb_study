package com.example.springboot_test.controller;

import com.example.springboot_test.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//@RestController 该注解是一个组合注解，（@Contronller  + @ResponseBody）作用
//一 ：是将当前类的对象注入Spring容器中,让Spring容器来管理
//二：将类下方法的返回值 解析成json格式的字符串
@RestController
public class LoginController {

    //,method = RequestMethod.POST
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    //@RequstBody 如果使用post发送请求 ，请求携带的数据时 json格式的对象，就必须使用该注解
    public User postTest(@RequestBody User user){
        //传递给浏览器
        return user;
    }

    // 该注解用来 设置前端发送请求的路径匹配规则
    @RequestMapping("/login") // 与表单中的action值相同，能够获取 变量 username,passwd
    public User  login(String username ,String passwd){
        System.out.println("username:" + username + " passwd:" + passwd);
        User user = new User();
        user.setUsername(username);
        // 返回值变成 json 格式的字符串
        return user;

    }

}
