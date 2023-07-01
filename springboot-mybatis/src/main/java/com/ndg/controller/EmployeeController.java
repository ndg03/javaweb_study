package com.ndg.controller;

import com.ndg.entity.Employee;
import com.ndg.entity.Result;
import com.ndg.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @className: EmployeeController
 * @author: ndg
 * @date: 2023/6/30 11:26
 */
//@RestController   =  @Controller + @ResponseBody
@Controller// 加入到 spring容器中
@ResponseBody // 将方法的返回值的直接返回，如果是 list或者 对象格式的数据，会转化为 json格式
public class EmployeeController {
    @Autowired//从spring容器中取出业务逻辑层对象，并赋值给该对象
            // 运行时，IOC 容器会提供给类型的 bean对象，并赋值给该变量  -  依赖注入
    EmployeeService employeeService;

    @RequestMapping("/getId")
    @ResponseBody
    //查询
    public Result getEmployeeById(Integer id){

        //return employeeService.getEmployeeById(id);
        return Result.success(employeeService.getEmployeeById(id));
    }

    @RequestMapping("/allEmployee")
    public List<Employee> getAllEmployees(){

        //交给业务逻辑层处理
        return employeeService.getAllEmployees();

    }
}
