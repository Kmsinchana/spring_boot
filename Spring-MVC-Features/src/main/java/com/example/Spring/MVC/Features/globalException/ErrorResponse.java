package com.example.Spring.MVC.Features.globalException;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

//to exclude the null value in the json response
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private LocalDateTime localDateTime;
    private int http_status;
    private String message;
    private String path;
    private Object details;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getHttp_status() {
        return http_status;
    }

    public void setHttp_status(int http_status) {
        this.http_status = http_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }
}
