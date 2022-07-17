package com.ndpcosta.test.cancunhotel.repository;

import com.ndpcosta.test.cancunhotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking findByCheckinDate(LocalDateTime checkinDate);

    Booking findByCustomerId(Long customerId);
}
