package com.ndpcosta.test.cancunhotel.service.impl;

import com.ndpcosta.test.cancunhotel.dto.BookingRequestDTO;
import com.ndpcosta.test.cancunhotel.dto.BookingResponseDTO;
import com.ndpcosta.test.cancunhotel.entity.Booking;
import com.ndpcosta.test.cancunhotel.entity.Guest;
import com.ndpcosta.test.cancunhotel.entity.Room;
import com.ndpcosta.test.cancunhotel.enums.BookingStatus;
import com.ndpcosta.test.cancunhotel.repository.BookingRepository;
import com.ndpcosta.test.cancunhotel.repository.GuestRepository;
import com.ndpcosta.test.cancunhotel.repository.RoomRepository;
import com.ndpcosta.test.cancunhotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public void cancelBooking() {

    }

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO dto) {
        checkReservationRequest(dto);
        checkRoomAvailabity(dto.getCheckinDate(), dto.getCheckoutDate());

        Optional<Booking> booking = Optional.ofNullable(bookingRepository.save(buildBooking(dto, BookingStatus.CONFIRMED)));
        booking.orElseThrow(); //add specific exception

        BookingResponseDTO responseDTO = buildBookingResponseDTO(booking.get());
        responseDTO.setBookingStatus(BookingStatus.CONFIRMED.getBookingStatus());

        return responseDTO;
    }

    @Override
    public void changeBooking() {

    }

    private void checkRoomAvailabity(LocalDateTime checkinDate, LocalDateTime checkoutDate) {
        //throw roomNotAvailableError
    }

    private void checkReservationRequest(BookingRequestDTO dto) {
        if(dto.getCheckinDate().isAfter((LocalDateTime.now().plusDays(31)))){
            //throw error - too early to book, please book with 30 or less days in advance
        }
    }

    private Booking buildBooking(BookingRequestDTO dto, BookingStatus bookingStatus) {
        Optional<Room> room = roomRepository.findById(Long.valueOf(dto.getRoomId()));
        room.orElseThrow();

        Optional<Guest> guest = guestRepository.findById(Long.valueOf(dto.getGuestId()));
        guest.orElseThrow();

        Booking booking = new Booking();
        booking.setRoom(room.get());
        booking.setGuest(guest.get());
        booking.setCheckinDate(dto.getCheckinDate());
        booking.setCheckoutDate(dto.getCheckoutDate());
        booking.setBookingStatus(bookingStatus.getBookingStatus());

        return booking;
    }

    private BookingResponseDTO buildBookingResponseDTO(Booking booking) {
        return null;
    }
}
