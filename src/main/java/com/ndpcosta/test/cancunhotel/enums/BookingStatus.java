package com.ndpcosta.test.cancunhotel.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum BookingStatus {

    CONFIRMED("Booking confirmed"),
    CANCELED("Booking canceled"),
    UPDATED("Booking updated");

    private String bookingStatus;

    private BookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public static BookingStatus getByName(String bookingStatus) {
        Optional<BookingStatus> bookingStatusOptional = Arrays.stream(BookingStatus.values()).filter(status -> status.name().equals(bookingStatus)).findFirst();
        return bookingStatusOptional.get();
    }

    public String getBookingStatus() {
        return this.bookingStatus;
    }
}
