package com.ndg.service.impl;

import com.ndg.entity.Employee;
import com.ndg.mapper.EmployeeMapper;
import com.ndg.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className: EmployeeServiceImpl
 * author: ndg
 * date: 2023/6/30 11:40
 */
@Service //将当前类的对象注入到spring容器中
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired //根据类型 注入到下面的对象中

    //当有 多个相同类型的bean时，可以通过@primary 注解 设置bean的优先级
    //可以通过@Qualifier 注解 设置要注入的类型  e.g  @Qualifier("employeeServiceImpl") 名称默认为实现类的首字母小写
    //直接使用@Resource 注解 ，声明 bean的名字  e.g @Resource(name="bean的名称")   `

    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAllEmployees() {
        //获取Dao层对象，调用dao层的方法
        return employeeMapper.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Integer id) {

        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public int addEmployee(Employee employee) {

        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int deleteEmployee(Employee employee) {

        return employeeMapper.deleteEmployee(employee);
    }
}
