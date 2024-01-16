package com.example.responseerror.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Status {
    private int code;
    private String message;
}
