package com.suk.zhenya.bd.convert;

import com.suk.zhenya.bd.dto.CrudPatientDto;
import com.suk.zhenya.bd.dto.PatientDto;
import com.suk.zhenya.bd.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PatientConverter {

    public Patient convertToPatient(CrudPatientDto dto) {
        return Patient.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .middleName(dto.getMiddleName())
                .birthDate(dto.getBirthDate())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .build();
    }

    public PatientDto convertToPatientDto(Patient patient) {
        return PatientDto.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .middleName(patient.getMiddleName())
                .birthDate(patient.getBirthDate())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .address(patient.getAddress())
                .build();
    }
}
