package com.ndg.service.impl;

import com.ndg.domain.MyUser;
import com.ndg.mapper.UserMapper;
import com.ndg.service.UserService;
import com.ndg.util.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @className: UserServiceImpl
 * @author: ndg
 * @date: 2023/7/5 19:37
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public boolean add(MyUser user) {
        //给密码进行加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //对于不能为空的两个参数默认值
        user.setCreateTime(DateFormatUtils.dateFormat("yyyy-MM-dd hh:mm:ss",new Date()));
        user.setUpdateTime(DateFormatUtils.dateFormat("yyyy-MM-dd hh:mm:ss",new Date()));
        int row = userMapper.insert(user);
        return row > 0;
    }

    @Override
    public MyUser selectByUserName(String username) {
        return userMapper.selectByPrimaryKey(username);
    }
}
