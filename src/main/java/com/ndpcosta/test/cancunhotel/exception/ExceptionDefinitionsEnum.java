package com.ndpcosta.test.cancunhotel.exception;

import lombok.Getter;

@Getter
public enum ExceptionDefinitionsEnum {

    ROOM_NOT_FOUND("001", "The room requested does not exist."),
    GUEST_NOT_FOUND("002", "The room requested does not exist."),
    BOOKING_NOT_FOUND("003", "The provided booking does not exist, please check your reservation number."),
    ROOM_NOT_AVAILABLE("004", "This accomodation is not available during the dates requested."),
    TOO_EARLY_TOO_BOOK("005", "Too early to book, please try again with 30 or less days in advance.");

    private String errorCode;
    private String errorDescription;

    ExceptionDefinitionsEnum(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

}
