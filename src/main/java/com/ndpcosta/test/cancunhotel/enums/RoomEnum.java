package com.ndpcosta.test.cancunhotel.enums;

import lombok.Getter;

@Getter
public enum RoomEnum {

    BASIC("Basic Room"),
    STANDARD("Standard Room"),
    LUXURY("Luxury Room");

    private String roomName;

    RoomEnum(String roomName) {
        this.roomName = roomName;
    }
}
