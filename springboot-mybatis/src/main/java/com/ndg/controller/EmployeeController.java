package com.ndg.controller;

import com.github.pagehelper.PageInfo;
import com.ndg.common.Result;
import com.ndg.common.StatusCode;
import com.ndg.entity.Employee;
import com.ndg.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
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
    @RequestMapping("/getPage")
    public Result<PageInfo<Employee>> getPage(Integer currentPage, Integer pageSize){
        return employeeService.getPage(currentPage,pageSize);
    }

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
    public Employee addEmployee(Integer id ,String first_name){
        Employee employee = new Employee();
        employee.setEmployeeId(id);
        employee.setFirstName(first_name);
        employeeService.addEmployee(employee);
        return employee;
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

    @PostMapping("/add")//post类型的请求
    public Result<String> addEmployee(@Valid @RequestBody Employee employee, BindingResult result){
        //判断验证规则是否包含错误
        if(result.hasErrors()){
            //获取所有错误信息
            List<ObjectError> allErrors = result.getAllErrors();
            //将错误信息拼接为一个字符穿返回
            StringBuilder sb= new StringBuilder();// 该对象是可变字符串对象
            for (ObjectError allError : allErrors){
                //获取粗无消息的提示
                String message = allError.getDefaultMessage();
                sb.append(message).append("  : ");
            }
            String mes = sb.toString();
            return new Result<>(false, StatusCode.ERROR,"验证失败",mes);
        }
        employeeService.addEmployee(employee);
        return new Result<>(true ,StatusCode.OK,"添加成功",employee.toString());
    }
}
