package com.example.traceability_platform.exception;

import lombok.Data;

@Data
public class TokenUnavailable extends Exception{
    private int code;
    private String message;

    public TokenUnavailable(int code, String message){
        this.code=code;
        this.message=message;
    }


}
