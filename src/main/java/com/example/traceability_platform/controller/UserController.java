package com.example.traceability_platform.controller;

import com.example.traceability_platform.common.ReturnInfo;
import com.example.traceability_platform.entity.User;
import com.example.traceability_platform.interfaces.PassToken;
import com.example.traceability_platform.service.UserService;
import com.example.traceability_platform.utils.JwtUtils;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Year;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PassToken
    @RequestMapping ("/register")
    public ReturnInfo Register(@RequestParam("email") String  email, @RequestParam("password") String  password,
                               @RequestParam("phone_num") String  phoneNum, @RequestParam("sex") int sex) throws NoSuchAlgorithmException {

        //对用户密码进行加密存储
        MessageDigest messageDigest =MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        String private_password = Hex.encodeHexString(digest);

        //生成私钥
        String privateKey = UUID.randomUUID().toString();
        //生成公钥
        String publicKey = UUID.randomUUID().toString();

        User user = new User();
        user.setEmail(email);
        user.setPassword(private_password);
        user.setPhoneNum(phoneNum);
        user.setSex(sex);
        user.setPrivateKey(privateKey);
        user.setPublicKey(publicKey);
        //默认没有公司
        user.setCompanyId(-1);
        return userService.saveUser(user);



    }

    //此处不设置拦截
    @PassToken
    @RequestMapping("/login")
    public ReturnInfo Login(@RequestParam("email") String email,@RequestParam("password")String password) throws NoSuchAlgorithmException {
        //对明文密码进行加密，用于与数据库中密文进行比较
        MessageDigest messageDigest =MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        String private_password = Hex.encodeHexString(digest);

        ReturnInfo returnInfo = userService.checkUser(email, private_password);
        //登录不成功就不用设置token了
        if (returnInfo.getCode()!=2000){
            return returnInfo;
        }

        User user = (User) returnInfo.getResult();
        String token = JwtUtils.createToken(user.getId().toString(), user.getEmail());
        //把token返回给前端 ，前端把token以cookie的形式存储在名称为“token”的请求头中
        returnInfo.setResult(token);
        return returnInfo;


    }
}
