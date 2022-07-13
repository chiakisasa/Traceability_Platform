package com.example.traceability_platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.traceability_platform.common.ReturnInfo;
import com.example.traceability_platform.entity.User;
import org.springframework.stereotype.Service;


public interface UserService extends IService<User> {

    ReturnInfo saveUser(User user);
    ReturnInfo checkUser(String email,String password);
}
