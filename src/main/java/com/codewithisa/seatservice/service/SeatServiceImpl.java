package com.codewithisa.seatservice.service;

import com.codewithisa.seatservice.entity.Seats;
import com.codewithisa.seatservice.repository.SeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    SeatRepository seatRepository;

    @Override
    public void saveSeat(Seats seat) {
        log.info("Inside saveSeat of SeatServiceImpl");
        log.info("seat successfully added");
        seatRepository.save(seat);
    }

    @Override
    public List<Seats> findSeatsByScheduleId(Long scheduleId) {
        return seatRepository.findSeatsByScheduleId(scheduleId);
    }
}

