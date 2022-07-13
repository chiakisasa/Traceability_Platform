package com.example.traceability_platform.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.traceability_platform.entity.User;
import com.example.traceability_platform.exception.NeedToLogin;
import com.example.traceability_platform.exception.UserNotExist;
import com.example.traceability_platform.interfaces.PassToken;
import com.example.traceability_platform.service.Impl.UserServiceImpl;
import com.example.traceability_platform.service.UserService;
import com.example.traceability_platform.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;


public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        //System.out.println("kaishi");
        // 从请求头中取出 token  这里需要和前端约定好把jwt放到请求头一个叫token的地方
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //默认全部检查
        else {
            System.out.println("被jwt拦截需要验证");
            // 执行认证
            if (token == null) {
                System.out.println("没有token");
                //这里其实是登录失效,没token了
                throw new NeedToLogin(2002,"用户未登录");
            }

            // 获取 token 中的 userId
            String userId = JwtUtils.getAudience(token);
            System.out.println(userId);

            //找找看是否有这个user   因为我们需要检查用户是否存在
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",userId);

            List<User> list = userService.list(queryWrapper);

            User user = list.get(0);

            if (user == null) {
                //这个错误也是我自定义的
                throw new UserNotExist(2003,"用户不存在");
            }

            // 验证 token
            JwtUtils.verifyToken(token, userId);

            //获取载荷内容
            String email = JwtUtils.getClaimByName(token, "email").asString();

            //放入attribute以便后面调用
            request.setAttribute("email", email);


            return true;

        }
        return true;

    }
}
