package com.ndg.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @className: Employee
 * @author: ndg
 * @date: 2023/6/30 11:32
 */
@Data
@ToString
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
