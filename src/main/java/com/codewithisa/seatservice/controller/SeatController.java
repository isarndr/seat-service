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

    @PostMapping("/")
    public ResponseEntity<Seats> saveSeat(@RequestBody Seats seat) {
        log.info("Inside saveSeat of SeatController");
        seatService.saveSeat(seat);
        return new ResponseEntity<>(seat, HttpStatus.CREATED);
    }

    @Operation(summary = "untuk mendapatkan seats berdasarkan schedule id")
    @GetMapping("/{scheduleId}")
    public ResponseEntity<List<Seats>> findSeatsByScheduleId(@Schema(example = "1") @PathVariable("scheduleId") Long scheduleId){
        log.info("Inside findSeatsByScheduleId of SeatController");
        return new ResponseEntity<>(seatService.findSeatsByScheduleId(scheduleId), HttpStatus.OK);
    }
}
