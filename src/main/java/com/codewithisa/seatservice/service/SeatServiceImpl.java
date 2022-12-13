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
        log.info("Inside findSeatsByScheduleId of SeatServiceImpl");
        return seatRepository.findSeatsByScheduleId(scheduleId);
    }

    @Override
    public void deleteSeatByScheduleIdAndNomorKursi(Long scheduleId, String nomorKursi) {
        log.info("Inside deleteSeatByScheduleIdAndNomorKursi of SeatServiceImpl");
        seatRepository.deleteSeatByScheduleIdAndNomorKursi(scheduleId, nomorKursi);
    }

    @Override
    public Seats findSeatByScheduleIdAndNomorKursi(Long scheduleId, String nomorKursi) {
        log.info("Inside findSeatByScheduleIdAndNomorKursi of SeatServiceImpl");
        return seatRepository.findSeatByScheduleIdAndNomorKursi(scheduleId, nomorKursi);
    }

    @Override
    public Boolean existByScheduleId(Long scheduleId) {
        log.info("Inside existByScheduleId of SeatServiceImpl");
        return seatRepository.existsByScheduleId(scheduleId);
    }

    @Override
    public Boolean existsByNomorKursi(String nomorKursi) {
        log.info("Inside existsByNomorKursi of SeatServiceImpl");
        return seatRepository.existsByNomorKursi(nomorKursi);
    }
}

