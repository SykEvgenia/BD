package com.suk.zhenya.bd.service;

import com.suk.zhenya.bd.convert.MedicalRecordConverter;
import com.suk.zhenya.bd.dto.CrudMedicalRecordDto;
import com.suk.zhenya.bd.dto.MedicalRecordDto;
import com.suk.zhenya.bd.entity.Doctor;
import com.suk.zhenya.bd.entity.Patient;
import com.suk.zhenya.bd.repository.DoctorRepository;
import com.suk.zhenya.bd.repository.MedicalRecordRepository;
import com.suk.zhenya.bd.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicalRecordService {

    private MedicalRecordRepository repository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private MedicalRecordConverter converter;

    public List<MedicalRecordDto> getMedicalRecord(Long patientId) {
        return repository.findAllByPatientId(patientId).stream()
                .map(converter::convertToMedicalRecordDto)
                .toList();
    }

    public MedicalRecordDto addMedicalRecord(Long patientId, CrudMedicalRecordDto dto) {
        Doctor doctor = doctorRepository.findById(dto.getDoctorId()).orElseThrow();
        Patient patient = patientRepository.getReferenceById(patientId);
        return converter.convertToMedicalRecordDto(repository.save(converter.convertToMedicalRecord(dto,doctor, patient)));
    }

    public void deleteMedicalRecord(Long medicalRecordId) {
        repository.deleteById(medicalRecordId);
    }
}
