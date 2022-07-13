package com.example.traceability_platform.common;

import com.fasterxml.jackson.core.TSFBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ReturnInfo {

    private int code=2000;         //2000:成功
    private String  message="success";
    private Object result;

    public static ReturnInfo success(Object result){
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setResult(result);
        return returnInfo;

    }

    public static ReturnInfo fail(int code, String message){
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setCode(code);
        returnInfo.setMessage(message);
        return returnInfo;

    }

}
