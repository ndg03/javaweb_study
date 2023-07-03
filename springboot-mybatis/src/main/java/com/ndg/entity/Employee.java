package com.ndg.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;


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
    @NotBlank(message = "firstName 不能为空")
    @Length(min = 2,max = 10,message = "firstName 必须在2-10之间")
    private String firstName;
    @NotBlank(message = "lastName 不能为空")
    @Length(min = 2,max = 10,message = "lastName 必须在2-10之间")
    private String lastName;
    private String email;
    @NotBlank(message = "电话号码不能为空")
    @Pattern(regexp = "^1(3[0-9]|5[012356789]|7[1235678]|8[0-9])\\d{8}$")
    private String phoneNumber;
    private String jobId;
    private double salary;
    private double commissionPct;
    private Integer managerId;
    private Integer departmentId;
    private String hiredate;
}
