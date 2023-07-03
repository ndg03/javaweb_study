package com.ndg.service;

import com.github.pagehelper.PageInfo;
import com.ndg.common.Result;
import com.ndg.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //获取所有员工的信息  的方法
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    void addEmployee(Employee employee);

    void deleteEmployee(Integer id);

    int updateEmployee(Employee employee);

    Result<PageInfo<Employee>> getPage(Integer currentPage, Integer pageSize);
}
