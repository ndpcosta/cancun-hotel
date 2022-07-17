package com.ndpcosta.test.cancunhotel.enums;

public enum BookingStatus {

    CONFIRMED("Booking confirmed"),
    CANCELED("Booking canceled"),
    UPDATED("Booking updated");

    private String bookingStatus;

    BookingStatus(String s) { }

    public String getBookingStatus() {
        return this.bookingStatus;
    }
}
