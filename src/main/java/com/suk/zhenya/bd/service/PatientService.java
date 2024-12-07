package com.suk.zhenya.bd.service;

import com.suk.zhenya.bd.convert.PatientConverter;
import com.suk.zhenya.bd.dto.CrudPatientDto;
import com.suk.zhenya.bd.dto.PatientDto;
import com.suk.zhenya.bd.entity.Patient;
import com.suk.zhenya.bd.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository repository;
    private PatientConverter converter;

    public List<PatientDto> getPatients() {
        return repository.findAll().stream()
                .map(converter::convertToPatientDto)
                .toList();
    }

    public PatientDto getPatient(Long id) {
        Patient patient = repository.findById(id).orElseThrow();
        return converter.convertToPatientDto(patient);
    }

    public PatientDto addPatient(CrudPatientDto dto) {
        Patient patient = converter.convertToPatient(dto);
        return converter.convertToPatientDto(repository.save(patient));
    }

    public PatientDto updatePatient(Long id, CrudPatientDto dto) {
        Patient patient = getPatientUpdate(id, dto);
        return converter.convertToPatientDto(repository.save(patient));
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }

    private Patient getPatientUpdate(Long id, CrudPatientDto dto) {
        Patient patient = repository.findById(id).orElseThrow();
        patient.setLastName(dto.getLastName());
        patient.setFirstName(dto.getFirstName());
        patient.setEmail(dto.getEmail());
        patient.setPhone(dto.getPhone());
        patient.setAddress(dto.getAddress());
        patient.setBirthDate(dto.getBirthDate());
        patient.setMiddleName(dto.getMiddleName());
        return patient;
    }
}
