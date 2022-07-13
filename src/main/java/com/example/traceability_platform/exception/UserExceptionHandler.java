package com.example.traceability_platform.exception;

import com.example.traceability_platform.common.ReturnInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class UserExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserException.class)
    public ReturnInfo HandleUserException(UserException userException){

       return ReturnInfo.fail(userException.getCode(),userException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(NeedToLogin.class)
    public ReturnInfo HandleLoginException(NeedToLogin needToLogin){

        return ReturnInfo.fail(needToLogin.getCode(),needToLogin.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(TokenUnavailable.class)
    public ReturnInfo HandleTokenException(TokenUnavailable tokenUnavailable){

        return ReturnInfo.fail(tokenUnavailable.getCode(),tokenUnavailable.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(UserNotExist.class)
    public ReturnInfo HandleUserNotExistsException(UserNotExist userNotExist){

        return ReturnInfo.fail(userNotExist.getCode(),userNotExist.getMessage());
    }



}
