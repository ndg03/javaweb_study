package com.ndg.controoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: UserController
 * @author: ndg
 * @date: 2023/7/5 13:31
 */
@RestController
@RequestMapping("/user")//设置根路径
public class UserController {
    @RequestMapping("findAllUsers")
    public String findAllUsers(){
        System.out.println("findAllUsers");
        return "allusers";
    }
}
