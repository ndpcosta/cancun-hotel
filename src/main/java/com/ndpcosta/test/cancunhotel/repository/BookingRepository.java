package com.ndpcosta.test.cancunhotel.repository;

import com.ndpcosta.test.cancunhotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByGuestId(Long guestId);

    @Query("SELECT b FROM Booking b " +
           "WHERE (b.checkinDate BETWEEN :checkinDate and :checkoutDate) " +
           "OR (b.checkoutDate BETWEEN :checkinDate and :checkoutDate) ")
    Optional<Booking> findRoomAlreadyBooked(@Param("checkinDate") LocalDate checkinDate, @Param("checkoutDate") LocalDate checkoutDate);

}
