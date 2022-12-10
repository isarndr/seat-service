package com.codewithisa.seatservice.service;

import com.codewithisa.seatservice.entity.Seats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatService {
    void saveSeat(Seats seat);
    List<Seats> findSeatsByScheduleId(Long scheduleId);
    void deleteSeatByScheduleIdAndNomorKursi(Long scheduleId, String nomorKursi);
    Seats findSeatByScheduleIdAndNomorKursi(Long scheduleId, String nomorKursi);
}
