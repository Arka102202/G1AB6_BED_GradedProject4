package com.employeeManagement.demo.exception;

public class UserRoleAlreadyExistException extends RuntimeException{

    public UserRoleAlreadyExistException(String message){
        super(message);
    }
}
