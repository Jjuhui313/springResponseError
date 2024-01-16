package com.example.responseerror.exception;

import com.example.responseerror.dto.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {CustumException.class})
    protected ApiResponse customExceptionHandler(CustumException custumException) {
        return new ApiResponse(custumException.getErrorCode().getCode(), custumException.getErrorCode().getMessage(), custumException.getData());
    }
}
