package com.ndg.mapper;

import com.ndg.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper //将mybatis通过动态代理 生成该类的实现类  存放到spring容器中
//在运行时会自动生成该接口的实现类对象（代理对象），并且将对象交给IOC容器管理
public interface EmployeeMapper {

    //@Select("select * from employees")
    //如果实体类中的字段名，与数据库中的列名 不一致， mybatis 不会自动映射
//    解决方案一： 给数据库中的字段起一个别名 ,使别名与 实体类中的字段名相同
//    e.g.  select employee_id employeeId
//    解决方法二:通过@Results @Result注解进行手动封装
//    @Results({
//             @Result(column = "数据库中字段名" ,property = "实体类中字段名"),
//             @Result(column = "" ,property = ""),
//             @Result(column = "" ,property = ""),
//    })
//解决方案三 :开启驼峰命名 (推荐)
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    //@Options(useGeneratedKeys = true,keyProperty = "employeeId") 主键返回
    @Insert("insert employees (employee_id, first_name, last_name, email, phone_number, job_id, salary, commission_pct, manager_id, department_id, hiredate) " +
            "value (#{employeeId},#{firstName},#{lastName},#{email},#{phoneNumber},#{jobId},#{salary},#{commissionPct},#{managerId},#{departmentId},#{hiredate})")
    void addEmployee(Employee employee);

    //根据id删除员工信息
    //执行SQL时，会将#{} 替换为 ？ ，生成预编译的SQL ,会自动设置参数值
    // ${}  拼接SQL 语句，直接将参数拼接在SQL语句中，存在SQl注入的问题   性能更低
    @Delete("delete from employees where employee_id = #{id}")
    void deleteEmployee(Integer id);

    int updateEmployee(Employee employee);



    //条件查询
    // '%#{firstName}%'  不行，引号里边不能有#{}
//    解决方法： 使用  ${}   $ 是字符串拼接符号 ，不安全 ，性能低，有SQL注入
//    使用 concat拼接函数
    //@Select("select * from employees where first_name like concat('%',#{firstName},'%') and last_name like concat('%',#{lastName},'%')")
    public List<Employee> select(String firstName,String lastName);
}
