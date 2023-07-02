package com.ndg.service;

import com.ndg.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //获取所有员工的信息  的方法
    List<Employee> getAllEmployees();

    public Employee getEmployeeById(Integer id);

    int addEmployee(Employee employee);
}
