package com.group20.coursemanagementsystem.security.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //HANDLE BAD REQUEST ERROR
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public List<String> handleException(MethodArgumentNotValidException exception) {
        return exception.getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();
    }
}
