package com.suk.zhenya.bd.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name ")
    private String lastName;

    @Column(name = "middle_name ")
    private String middleName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "specialization")
    private String specialization;
}
