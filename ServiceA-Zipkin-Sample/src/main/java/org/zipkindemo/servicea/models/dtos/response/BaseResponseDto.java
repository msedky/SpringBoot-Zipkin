package org.zipkindemo.servicea.models.dtos.response;

import lombok.*;
@Data
@ToString
@EqualsAndHashCode
public class BaseResponseDto<T> {
    private int status;
    private String message;

    private T result;

    protected BaseResponseDto() {

    }

    protected BaseResponseDto(int status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public static BaseResponseDto success(Object result) {
        return new BaseResponseDto(200, "success", result);
    }

    public static BaseResponseDto success(String message, Object result) {
        return new BaseResponseDto(200, message, result);
    }

    public static BaseResponseDto failure(String message) {
        return new BaseResponseDto(500, message, null);
    }

    public static BaseResponseDto failure(int status, String message) {
        return new BaseResponseDto(status, message, null);
    }
}