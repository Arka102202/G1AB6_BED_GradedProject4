package com.employeeManagement.demo.model;

import com.employeeManagement.demo.responseHandler.HttpStatusCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private HttpStatus status;
    private String message;
    private Date date;

    public ErrorResponse(int code, String extras, long milliSecond) throws ParseException {
        this.status = new HttpStatusCode(code).getHttpStatus();
        if(extras != null) this.message = status.getReasonPhrase()+" - " + extras;
        this.date = new Date(milliSecond);

    }
}
