package com.suk.zhenya.bd.repository;

import com.suk.zhenya.bd.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
