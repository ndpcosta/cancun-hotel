package com.ndpcosta.test.cancunhotel.repository;

import com.ndpcosta.test.cancunhotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>  {

    Optional<Room> findById(Long id);
}
