package com.suk.zhenya.bd.convert;

import com.suk.zhenya.bd.dto.CrudMedicalRecordDto;
import com.suk.zhenya.bd.dto.MedicalRecordDto;
import com.suk.zhenya.bd.entity.Doctor;
import com.suk.zhenya.bd.entity.MedicalRecord;
import com.suk.zhenya.bd.entity.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MedicalRecordConverter {


    public MedicalRecordDto convertToMedicalRecordDto(MedicalRecord medicalRecord) {
        return MedicalRecordDto.builder()
                .id(medicalRecord.getId())
                .diagnosis(medicalRecord.getDiagnosis())
                .treatment(medicalRecord.getTreatment())
                .visitDate(medicalRecord.getVisitDate())
                .doctorId(medicalRecord.getDoctor().getId())
                .build();
    }

    public MedicalRecord convertToMedicalRecord(CrudMedicalRecordDto dto, Doctor doctor, Patient patient) {
        return MedicalRecord.builder()
                .diagnosis(dto.getDiagnosis())
                .visitDate(dto.getVisitDate())
                .treatment(dto.getTreatment())
                .doctor(doctor)
                .patient(patient)
                .build();
    }
}
