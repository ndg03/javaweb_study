package com.ndg.controller;

import com.ndg.entity.Employee;
import com.ndg.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//import org.springframework.web.bind.annotation.RestController;


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
    public Employee getEmployeeById(Integer id){

        return employeeService.getEmployeeById(id);
    }

    @RequestMapping("/allEmployee")
    public List<Employee> getAllEmployees(){

        //交给业务逻辑层处理
        return employeeService.getAllEmployees();

    }

    //添加一行数据 /add?id=207
    @RequestMapping("/add")
    public void addEmployee(Integer id ,String first_name){
        Employee employee = new Employee();
        employee.setEmployeeId(id);
        employee.setFirstName(first_name);
        employeeService.addEmployee(employee);
    }

    //删除一行数据 /delete?id=207
    @RequestMapping("/delete")
    public void deleteEmployee(Integer id){
        employeeService.deleteEmployee(id);
    }

    //修改数据 /update?id=208
    @RequestMapping("/update")
    public int updateEmployee(Integer id, String first_name){
        Employee employee = new Employee();
        employee.setEmployeeId(id);
        employee.setFirstName(first_name);
        return employeeService.updateEmployee(employee);
    }
}
