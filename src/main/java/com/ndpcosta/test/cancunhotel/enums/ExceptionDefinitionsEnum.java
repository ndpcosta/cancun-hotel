package com.ndpcosta.test.cancunhotel.enums;

import lombok.Getter;

@Getter
public enum ExceptionDefinitionsEnum {

    ROOM_NOT_FOUND("HE001", "The room requested does not exist."),
    GUEST_NOT_FOUND("HE002", "The room requested does not exist."),
    BOOKING_NOT_FOUND("HE003", "The provided booking does not exist, please check your reservation number."),
    ROOM_NOT_AVAILABLE("HE004", "This accomodation is not available during the dates requested."),
    TOO_EARLY_TO_BOOK("HE005", "Too early to book, please try again with 30 or less days in advance."),
    TOO_LATE_TO_BOOK("HE006", "Reservations are only accepted with a checkin date from today.");

    private String errorCode;
    private String errorDescription;

    ExceptionDefinitionsEnum(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

}
