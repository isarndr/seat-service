package com.codewithisa.seatservice.controller;

import com.codewithisa.seatservice.entity.Seats;
import com.codewithisa.seatservice.service.SeatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    SeatService seatService;

    @PostMapping("/add-seat")
    public ResponseEntity<Seats> saveSeat(@RequestBody Seats seat) {
        log.info("Inside saveSeat of SeatController");
        seatService.saveSeat(seat);
        return new ResponseEntity<>(seat, HttpStatus.CREATED);
    }

    @Operation(summary = "untuk mendapatkan seats berdasarkan schedule id")
    @GetMapping("/find-seats-by-schedule-id/{scheduleId}")
    public ResponseEntity<List<Seats>> findSeatsByScheduleId(@Schema(example = "1") @PathVariable("scheduleId") Long scheduleId){
        log.info("Inside findSeatsByScheduleId of SeatController");
        return new ResponseEntity<>(seatService.findSeatsByScheduleId(scheduleId), HttpStatus.OK);
    }

    @DeleteMapping("delete-seat-by-schedule-id-and-nomor-kursi")
    public ResponseEntity<String> deleteSeatByScheduleIdAndNomorKursi(@RequestParam("scheduleId") Long scheduleId,
                                                                      @RequestParam("nomorKursi") String nomorKursi){
        log.info("Inside deleteSeatByScheduleIdAndNomorKursi of SeatController");
        seatService.deleteSeatByScheduleIdAndNomorKursi(scheduleId, nomorKursi);
        return new ResponseEntity<>("Seat deleted", HttpStatus.OK);
    }

    @GetMapping("/find-seat-by-schedule-id-and-nomor-kursi")
    public ResponseEntity<Seats> findSeatByScheduleIdAndNomorKursi(@RequestParam("scheduleId") Long scheduleId,
                                                                   @RequestParam("nomorKursi") String nomorKursi){
        log.info("Inside findSeatByScheduleIdAndNomorKursi of SeatController");
        return new ResponseEntity<>(seatService.findSeatByScheduleIdAndNomorKursi(scheduleId, nomorKursi), HttpStatus.OK);
    }
}
