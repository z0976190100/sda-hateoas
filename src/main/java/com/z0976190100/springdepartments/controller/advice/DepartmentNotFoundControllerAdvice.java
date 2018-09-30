package com.z0976190100.springdepartments.controller.advice;

import com.z0976190100.springdepartments.controller.exceptions.DepartmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DepartmentNotFoundControllerAdvice {

    @ResponseBody
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(DepartmentNotFoundException ex) {
        return ex.getMessage();
    }
}
