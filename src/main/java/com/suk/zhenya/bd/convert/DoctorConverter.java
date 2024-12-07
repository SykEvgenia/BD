package com.suk.zhenya.bd.convert;

import com.suk.zhenya.bd.dto.CrudDoctorDto;
import com.suk.zhenya.bd.dto.DoctorDto;
import com.suk.zhenya.bd.entity.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DoctorConverter {

    public Doctor convertToDoctor(CrudDoctorDto dto) {
        return Doctor.builder()
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .firstName(dto.getFirstName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .specialization(dto.getSpecialization())
                .build();
    }

    public DoctorDto convertToDoctorDto(Doctor doctor) {
        return DoctorDto.builder()
                .id(doctor.getId())
                .middleName(doctor.getMiddleName())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .phone(doctor.getPhone())
                .email(doctor.getEmail())
                .specialization(doctor.getSpecialization())
                .build();
    }
}
