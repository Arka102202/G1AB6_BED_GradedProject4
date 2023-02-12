package com.employeeManagement.demo.responseHandler;

import org.springframework.http.HttpStatus;

public class HttpStatusCode {

    private HttpStatus httpStatus;

    public HttpStatusCode(int code){
        switch (code){
            case 400:
                this.httpStatus = HttpStatus.BAD_REQUEST;
                break;
            case 401:
                this.httpStatus = HttpStatus.UNAUTHORIZED;
                break;
            case 403:
                this.httpStatus = HttpStatus.FORBIDDEN;
                break;
            case 404:
                this.httpStatus = HttpStatus.NOT_FOUND;
                break;
        }
    }

    public HttpStatus getHttpStatus(){
        return this.httpStatus;
    }


}
