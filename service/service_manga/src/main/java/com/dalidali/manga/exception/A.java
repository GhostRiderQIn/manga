package com.dalidali.manga.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: manga
 * @description:
 * @author: qinda
 * @create: 2020-09-08 19:02
 **/
@ControllerAdvice
public class A {

    @ExceptionHandler(Exception.class)
    public void e(){
        System.out.println("niubi");
    }
}
