package com.ndg.mapper;

import com.ndg.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper //将mybatis通过动态代理 生成该类的实现类  存放到spring容器中
public interface EmployeeMapper {

    //@Select("select * from employees")
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    int addEmployee(Employee employee);

    int deleteEmployee(Employee employee);
}
