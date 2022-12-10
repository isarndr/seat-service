package com.codewithisa.seatservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(SeatsId.class)
public class Seats {
    @Id
    private Character studioName;
    @Id
    private String nomorKursi;
    @Id
    private Long scheduleId;
}

