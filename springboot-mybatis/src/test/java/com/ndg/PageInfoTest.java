package com.ndg;

import com.github.pagehelper.PageInfo;
import com.ndg.common.Result;
import com.ndg.entity.Employee;
import com.ndg.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @className: PageInfoTest
 * @author: ndg
 * @date: 2023/7/3 10:39
 */
@SpringBootTest
public class PageInfoTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void page(){
        Result<PageInfo<Employee>> page = employeeService.getPage(22, 5);
        System.out.println("page:" + page);
    }
}
