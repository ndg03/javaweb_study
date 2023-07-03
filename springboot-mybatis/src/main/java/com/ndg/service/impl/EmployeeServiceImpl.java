package com.ndg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ndg.common.Result;
import com.ndg.common.StatusCode;
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
    public Result<PageInfo<Employee>> getPage(Integer currentPage, Integer pageSize){
        //获取Dao层对象，调用dao层的方法
        //1.设置分页参数
        PageHelper.startPage(currentPage,pageSize);
        //2.获取分页数据
        List<Employee> list = employeeMapper.getAllEmployees();
        //3.获取当前页的数据以及总条数等信息
        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        long total = pageInfo.getTotal();//获取分页总条数
        int nextPage = pageInfo.getNextPage();//获取下一页
        System.out.println("下一页：" + nextPage + "总条数：" + total);

        int prePage = pageInfo.getPrePage();//获取前一页
        System.out.println("获取前页面：" + prePage);
        List<Employee> list1 = pageInfo.getList();
        System.out.println(list1);

       return new Result<>(true, StatusCode.OK, "分页查询", pageInfo);
    }


    @Override
    public Employee getEmployeeById(Integer id) {

        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteEmployee(id);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }
}
