package com.ndg.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: MyUser
 * @author: ndg
 * @date: 2023/7/5 13:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
}
