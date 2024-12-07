package com.suk.zhenya.bd.repository;

import com.suk.zhenya.bd.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
