package com.example.springboot_test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user")
    public String submit(String aa,String bb){
        System.out.println(aa);
        System.out.println(bb);
        return aa+bb;
    }
}
