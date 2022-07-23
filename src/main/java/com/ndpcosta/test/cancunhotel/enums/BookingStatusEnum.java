package com.ndpcosta.test.cancunhotel.enums;

import lombok.Getter;

@Getter
public enum BookingStatusEnum {

    CONFIRMED("Booking confirmed"),
    CANCELED("Booking canceled"),
    UPDATED("Booking updated");

    private String bookingStatus;

    BookingStatusEnum(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
