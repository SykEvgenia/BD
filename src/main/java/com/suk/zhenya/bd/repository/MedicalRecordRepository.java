package com.suk.zhenya.bd.repository;

import com.suk.zhenya.bd.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

    List<MedicalRecord> findAllByPatientId(Long patientId);
}
