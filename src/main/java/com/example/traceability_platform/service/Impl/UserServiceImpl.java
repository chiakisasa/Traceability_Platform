package com.example.traceability_platform.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.traceability_platform.common.ReturnInfo;
import com.example.traceability_platform.entity.User;
import com.example.traceability_platform.exception.UserException;
import com.example.traceability_platform.mapper.UserMapper;
import com.example.traceability_platform.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public ReturnInfo saveUser(User user) {
        List<User> list = list();

        //查看用户是否已经存在
        for(User u:list) {
            if (user.getEmail().equals(u.getEmail())){
                //交给UserExceptionHandler处理异常
                throw  new UserException(2001,"用户已经存在");
            }
        }

        //成功注册
        this.save(user);

        return ReturnInfo.success(user);

    }

    @Override
    public ReturnInfo checkUser(String email, String password) {
        QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
        queryWrapper.eq("email",email);
        queryWrapper.eq("password",password);

        List<User> list = this.list(queryWrapper);
        if(list.size()==0){
            return ReturnInfo.fail(2005,"用户不存在");
        }
        User user = list.get(0);

        return ReturnInfo.success(user);
    }
}
