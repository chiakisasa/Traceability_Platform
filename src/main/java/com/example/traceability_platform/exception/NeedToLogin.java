package com.example.traceability_platform.exception;

import lombok.Data;

@Data
public class NeedToLogin extends Exception{
    private int code;
    private String message;

    public  NeedToLogin(int code, String message){
        this.code=code;
        this.message=message;
    }
}
