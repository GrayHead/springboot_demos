package ua.com.owu.springboot_demos.controllers;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String sizeException( MethodArgumentNotValidException ex) {

        return ex.getFieldError().getDefaultMessage();
    }

}
