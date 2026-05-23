package com.example.Spring.MVC.Features.globalException;

import com.example.Spring.MVC.Features.uncheckedException.EmployeeNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlingValidationError(MethodArgumentNotValidException exception, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse();

        Map<String,String> detailsField = new HashMap<>();

        exception.getBindingResult().getFieldErrors()
                .forEach(error->
                detailsField.put(
                        error.getField(),
                        error.getDefaultMessage()
                )
        );
        errorResponse.setLocalDateTime(LocalDateTime.now());
        errorResponse.setHttp_status(400);
        errorResponse.setMessage("validation error");
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setDetails(detailsField);

        return new  ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handlingValidationErrorForPathVariableAndRequestParam(ConstraintViolationException exception, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse();

        Map<String,String> detailsField = new HashMap<>();

        exception.getConstraintViolations()
                .forEach(error->
                        detailsField.put(
                                error.getPropertyPath().toString(),
                                error.getMessage()
                        )
                );
        errorResponse.setLocalDateTime(LocalDateTime.now());
        errorResponse.setHttp_status(400);
        errorResponse.setMessage("validation error");
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setDetails(detailsField);

        return new  ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> employeeNotFount(EmployeeNotFoundException exception, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setLocalDateTime(LocalDateTime.now());
        errorResponse.setHttp_status(HttpStatus.NOT_FOUND.value());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setDetails(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
//always keeping one generic exception to stop stack trace
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex) {

        return new ResponseEntity<>(
                "Something went wrong",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
