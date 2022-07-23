package com.ndpcosta.test.cancunhotel.exception;

import com.ndpcosta.test.cancunhotel.enums.ExceptionDefinitionsEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.function.Supplier;

@Data
public final class HotelException extends Throwable implements Serializable, Supplier<HotelException> {

    private final String exceptionId;

    private final String exceptionCode;

    private final String message;

    public HotelException(ExceptionDefinitionsEnum exceptionDefinitionsEnum) {
        this.exceptionId = exceptionDefinitionsEnum.name();
        this.exceptionCode = exceptionDefinitionsEnum.getErrorCode();
        this.message = exceptionDefinitionsEnum.getErrorDescription();
    }

    @Override
    public HotelException get() {
        return this;
    }
}
