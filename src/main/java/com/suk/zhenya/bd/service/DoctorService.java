package com.suk.zhenya.bd.service;

import com.suk.zhenya.bd.convert.DoctorConverter;
import com.suk.zhenya.bd.dto.CrudDoctorDto;
import com.suk.zhenya.bd.dto.DoctorDto;
import com.suk.zhenya.bd.entity.Doctor;
import com.suk.zhenya.bd.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    private DoctorRepository repository;
    private DoctorConverter doctorConverter;

    public List<DoctorDto> getDoctors() {
        return repository.findAll().stream().map(doctorConverter::convertToDoctorDto).toList();
    }

    public DoctorDto getDoctor(Long id) {
        return doctorConverter.convertToDoctorDto(repository.findById(id).orElseThrow());
    }

    public DoctorDto addDoctor(CrudDoctorDto dto) {
        return doctorConverter.convertToDoctorDto(repository.save(doctorConverter.convertToDoctor(dto)));
    }

    public DoctorDto updateDoctor(Long id, CrudDoctorDto dto) {
        Doctor doctor = repository.findById(id).orElseThrow();
        doctor.setFirstName(dto.getFirstName());
        doctor.setFirstName(dto.getFirstName());
        doctor.setMiddleName(dto.getMiddleName());
        doctor.setPhone(dto.getPhone());
        doctor.setEmail(dto.getEmail());
        doctor.setSpecialization(dto.getSpecialization());
        return doctorConverter.convertToDoctorDto(repository.save(doctor));
    }
}
