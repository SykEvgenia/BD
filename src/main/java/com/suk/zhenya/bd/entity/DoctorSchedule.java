package com.suk.zhenya.bd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "doctor_schedule")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "available_from")
    private LocalTime availableFrom;

    @Column(name = "available_to")
    private LocalTime availableTo;

    @Column(name = "day_of_week ")
    private String dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
