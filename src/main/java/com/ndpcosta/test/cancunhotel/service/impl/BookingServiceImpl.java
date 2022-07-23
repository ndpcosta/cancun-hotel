package com.ndpcosta.test.cancunhotel.service.impl;

import com.ndpcosta.test.cancunhotel.dto.BookingRequestDTO;
import com.ndpcosta.test.cancunhotel.dto.BookingResponseDTO;
import com.ndpcosta.test.cancunhotel.entity.Booking;
import com.ndpcosta.test.cancunhotel.entity.Guest;
import com.ndpcosta.test.cancunhotel.enums.BookingStatusEnum;
import com.ndpcosta.test.cancunhotel.enums.ExceptionDefinitionsEnum;
import com.ndpcosta.test.cancunhotel.enums.RoomEnum;
import com.ndpcosta.test.cancunhotel.exception.HotelException;
import com.ndpcosta.test.cancunhotel.repository.BookingRepository;
import com.ndpcosta.test.cancunhotel.repository.GuestRepository;
import com.ndpcosta.test.cancunhotel.service.BookingService;
import com.ndpcosta.test.cancunhotel.utils.ReservationNumberBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO dto) throws HotelException {
        checkReservationRequest(dto);

        RoomEnum room = RoomEnum.valueOf(dto.getRoomId());
        if(room == null) {
            throw new HotelException(ExceptionDefinitionsEnum.ROOM_NOT_FOUND);
        }

        checkRoomAvailability(dto.getCheckinDate(), dto.getCheckoutDate());

        Optional<Booking> booking = Optional.ofNullable(bookingRepository.save(buildBooking(dto, room, BookingStatusEnum.CONFIRMED)));
        BookingResponseDTO responseDTO = buildBookingResponseDTO(booking.get());
        responseDTO.setBookingStatus(BookingStatusEnum.CONFIRMED.getBookingStatus());

        return responseDTO;
    }

    @Override
    public void changeBooking() {}

    @Override
    public void cancelBooking() {}

    private void checkRoomAvailability(LocalDate checkinDate, LocalDate checkoutDate) throws HotelException {
        if(bookingRepository.findRoomAlreadyBooked(checkinDate, checkoutDate).isPresent()){
            throw new HotelException(ExceptionDefinitionsEnum.ROOM_NOT_AVAILABLE);
        };
    }

    private void checkReservationRequest(BookingRequestDTO dto) throws HotelException {
        if(dto.getCheckinDate().isAfter((LocalDate.now().plusDays(31)))){
            throw new HotelException(ExceptionDefinitionsEnum.TOO_EARLY_TO_BOOK);
        }
        if(dto.getCheckinDate().isBefore(LocalDate.now())){
            throw new HotelException(ExceptionDefinitionsEnum.TOO_LATE_TO_BOOK);
        }
    }

    private Booking buildBooking(BookingRequestDTO dto, RoomEnum room, BookingStatusEnum bookingStatus) throws HotelException {
        Optional<Guest> guest = guestRepository.findById(Long.valueOf(dto.getGuestId()));
        guest.orElseThrow(new HotelException(ExceptionDefinitionsEnum.GUEST_NOT_FOUND));

        Booking booking = new Booking();
        booking.setRoom(room.name());
        booking.setGuest(guest.get());
        booking.setReservationNumber(ReservationNumberBuilder.buildReservationNumber());
        booking.setCheckinDate(dto.getCheckinDate());
        booking.setCheckoutDate(dto.getCheckoutDate());
        booking.setBookingStatus(bookingStatus.name());

        return booking;
    }

    private BookingResponseDTO buildBookingResponseDTO(Booking booking) {
        BookingResponseDTO responseDTO = new BookingResponseDTO();
        responseDTO.setReservationNumber(booking.getReservationNumber());
        responseDTO.setGuestName(booking.getGuest().getName());

        responseDTO.setRoomName(RoomEnum.valueOf(booking.getRoom()).getRoomName());
        responseDTO.setCheckinDate(booking.getCheckinDate());
        responseDTO.setCheckoutDate(booking.getCheckoutDate());

        BookingStatusEnum bookingStatus = BookingStatusEnum.valueOf(booking.getBookingStatus());
        responseDTO.setBookingStatus(bookingStatus.getBookingStatus());

        return responseDTO;
    }

}
