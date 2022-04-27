package ua.com.owu.springboot_demos.controllers;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.com.owu.springboot_demos.models.dto.CustomerSizeExceptionDTO;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomerSizeExceptionDTO sizeException(MethodArgumentNotValidException ex) {
        return new CustomerSizeExceptionDTO(400, ex.getFieldError().getField(), ex.getFieldError().getDefaultMessage());


    }

}
