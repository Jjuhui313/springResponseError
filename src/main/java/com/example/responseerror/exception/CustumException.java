package com.example.responseerror.exception;

import com.example.responseerror.entity.ErrorCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.AbstractMap;
import java.util.Map;

public class CustumException extends RuntimeException{

    @Getter
    private final ErrorCode errorCode;

    private String message;

    @Getter
    private Map.Entry<String, Object> data;

    public CustumException(ErrorCode errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;

        if(data != null) {
            this.data = new AbstractMap.SimpleEntry<>(data.getClass().getSimpleName(), data);
        } else {
            this.data = null;
        }
    }

    @Override
    public String getMessage() {
        if(StringUtils.hasLength(this.message)) {
            return this.message;
        }
        return errorCode.getMessage();
    }
}
