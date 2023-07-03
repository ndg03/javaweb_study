package com.ndg;

import com.ndg.entity.Employee;
import com.ndg.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//springboot 整合单元测试的注解
class SpringbootMybatisApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void testGetAllEmployee(){
        List<Employee> list = employeeMapper.getAllEmployees();
        list.stream().forEach(employee -> {
            System.out.println(employee);
        });
    }
    @Test
    public void select(){
        List<Employee> list = employeeMapper.select("an","a");
        list.stream().forEach(employee -> System.out.println(employee));
    }
}
