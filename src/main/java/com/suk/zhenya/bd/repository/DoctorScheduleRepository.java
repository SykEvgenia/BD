package com.suk.zhenya.bd.repository;

import com.suk.zhenya.bd.entity.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {

    List<DoctorSchedule> findByDoctorId(Long id);
    void deleteByDoctorId(Long id);
}
