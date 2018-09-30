package com.z0976190100.springdepartments.controller.exceptions;

public class DepartmentNotFoundException extends Exception {

    private Long id;

    public DepartmentNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage(){
        return "The resource with id: " + id + " not found.";
    }
}
