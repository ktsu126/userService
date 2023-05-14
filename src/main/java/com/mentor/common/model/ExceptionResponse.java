package com.mentor.common.model;

import com.mentor.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
    @NonNull
    private String code;
    @NonNull
    private String message;

    public static ExceptionResponse of(BusinessException businessException) {
        return new ExceptionResponse(
                businessException.getExceptionType().getCode(),
                businessException.getMessage()
        );
    }
}
