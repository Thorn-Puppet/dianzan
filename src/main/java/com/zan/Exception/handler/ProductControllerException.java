package com.zan.Exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerException {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(){
        return "error";
    }
}
