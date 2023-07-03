package com.ndg.entity;

import lombok.*;

/**
 * @className: Employee
 * @author: ndg
 * @date: 2023/6/30 11:32
 */
@Data  //等于下面的四个注解
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@NoArgsConstructor //无参构造
@AllArgsConstructor // 全参构造
public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String jobId;
    private double salary;
    private double commissionPct;
    private Integer managerId;
    private Integer departmentId;
    private String hiredate;
}
