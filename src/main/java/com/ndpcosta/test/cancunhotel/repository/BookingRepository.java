package com.ndpcosta.test.cancunhotel.repository;

import com.ndpcosta.test.cancunhotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByCheckinDate(LocalDateTime checkinDate);

    Optional<Booking> findByGuestId(Long guestId);

}
