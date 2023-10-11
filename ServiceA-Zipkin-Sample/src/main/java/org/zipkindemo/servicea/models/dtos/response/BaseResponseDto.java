package org.zipkindemo.servicea.models.dtos.response;

import lombok.*;

@Data
@Builder
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

    public static <T> BaseResponseDto<T> success(T result) {
        return new BaseResponseDto<T>(200, "success", result);
    }

    public static <T> BaseResponseDto<T> success(String message, T result) {
        return new BaseResponseDto<T>(200, message, result);
    }

    public static <T> BaseResponseDto<T> failure(String message) {
        return new BaseResponseDto<T>(500, message, null);
    }

    public static <T> BaseResponseDto<T> failure(int status, String message) {
        return new BaseResponseDto<T>(status, message, null);
    }
}