package com.ndg.controoller;

import com.ndg.common.Result;
import com.ndg.common.StatusCode;
import com.ndg.domain.MyUser;
import com.ndg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


/**
 * @className: UserController
 * @author: ndg
 * @date: 2023/7/5 13:31
 */
@RestController
@RequestMapping("/user")//设置根路径
public class UserController {

    //@Autowired // 通过类型在spring容器中查找
    //根据名称来获取存放到spring容器中的对象
    @Resource(name = "userService")
    UserService userService;

    @RequestMapping("findAllUsers")
    @PreAuthorize("hasAnyAuthority('admin')")//设置可以访问盖房的的用户的权限的标志，只有该用户具有该权限标识才可以访问
    public String findAllUsers(){
        System.out.println("findAllUsers");
        return "allusers";
    }

    @RequestMapping("/add")
    public Result<String> add(@Valid @RequestBody MyUser user, BindingResult result){
        //判断 表单验证是否正确
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            StringBuilder sb = new StringBuilder();
            allErrors.forEach(error -> sb.append(error.getDefaultMessage()).append(" : "));
            String mes = sb.toString();
            return new Result<>(false, StatusCode.ERROR, mes);
        }
        boolean bo = userService.add(user);
        return bo ? new Result<>(true, StatusCode.OK,"注册成功----------")
                : new Result<>(false,StatusCode.ERROR,"注册失败----------");
    }
}
