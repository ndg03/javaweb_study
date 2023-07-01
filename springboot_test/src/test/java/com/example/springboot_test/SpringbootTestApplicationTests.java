package com.example.springboot_test;

import com.example.springboot_test.entity.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootTestApplicationTests {
    //将spring容器中的Cat对象取出  赋值给Cat变量
    //获取方式：通过类型来查找，找不到通过名称来cat来查找
    @Autowired
    Cat cat;

    @Test
    void contextLoads() {
        System.out.println(cat);
    }

}
