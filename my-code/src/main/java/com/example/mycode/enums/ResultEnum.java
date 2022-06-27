package com.example.mycode.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    VALID_ERROR(50, "Wrong information"),
    USER_NOT_FOUND(51, "User not found");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
