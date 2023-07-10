package com.ndg.service;

import com.ndg.domain.MyUser;
import com.ndg.mapper.UserMapper;

/**
 * @className: UserService
 * @author: ndg
 * @date: 2023/7/5 19:36
 */
public interface UserService {

    boolean add(MyUser user);

    MyUser selectByUserName(String username);
}
