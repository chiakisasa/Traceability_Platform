package com.example.traceability_platform.exception;

import lombok.Data;

@Data
public class UserNotExist extends Exception{
    private int code;
    private String message;

    public UserNotExist(int code, String message){
        this.code=code;
        this.message=message;
    }


}
