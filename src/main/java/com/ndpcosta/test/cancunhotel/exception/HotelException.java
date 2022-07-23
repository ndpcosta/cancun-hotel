package com.ndpcosta.test.cancunhotel.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public final class HotelException extends Exception implements Serializable {

    private final String exceptionId;

    private final String exceptionCode;

    private final String message;

    public HotelException(ExceptionDefinitionsEnum exceptionDefinitionsEnum) {
        this.exceptionId = exceptionDefinitionsEnum.name();
        this.exceptionCode = exceptionDefinitionsEnum.getErrorCode();
        this.message = exceptionDefinitionsEnum.getErrorDescription();
    }

}
