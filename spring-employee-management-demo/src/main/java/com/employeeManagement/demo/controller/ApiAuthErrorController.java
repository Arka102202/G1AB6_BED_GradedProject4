package com.employeeManagement.demo.controller;

import com.employeeManagement.demo.model.ErrorResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

@RestController
public class ApiAuthErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<ErrorResponse> error(HttpServletResponse response) throws ParseException {
        ErrorResponse errResponse = new ErrorResponse(
                response.getStatus(),
                "User doesn't have permission to access this endpoint",
                System.currentTimeMillis());
        return new ResponseEntity<>(errResponse, HttpStatus.valueOf(response.getStatus()));
    }
}
