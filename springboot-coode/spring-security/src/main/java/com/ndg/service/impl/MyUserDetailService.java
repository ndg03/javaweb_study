package com.ndg.service.impl;

import com.ndg.domain.MyUser;
import com.ndg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: MyUserDetailService
 * @author: ndg
 * @date: 2023/7/5 14:12
 */
//实现了 spring-security  提供了UserDetailsService

@Service  // 注入到spring 容器中
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper; //根据用户名 获取用户信息
    // 根据用户名 查询用户对象：User
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = userMapper.selectByPrimaryKey(username);//根据用户名 获取用户信息
        if(myUser == null){
            // spring-security 自定义的异常
            throw new UsernameNotFoundException("查找的用户不存在，请先注册：" + username);
        }
        //通过工具类设置用户的权限标识
        List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList("admin","manager");
        // 参数1：用户名 参数2 ： 密码 参数3： 密码加密  参数4： 权限列表
        User user = new User(username,
                passwordEncoder.encode(myUser.getPassword()),
                auths);
        return user;
    }
}
