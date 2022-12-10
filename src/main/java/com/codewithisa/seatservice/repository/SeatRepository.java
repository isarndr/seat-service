package com.codewithisa.seatservice.repository;

import com.codewithisa.seatservice.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seats,Long> {

    @Query(
            nativeQuery = true,
            value = "select * from seats where schedule_id = :scheduleId"
    )
    List<Seats> findSeatsByScheduleId(@RequestParam("scheduleId") Long scheduleId);
}

