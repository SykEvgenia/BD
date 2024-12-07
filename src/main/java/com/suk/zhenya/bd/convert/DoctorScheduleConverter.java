package com.suk.zhenya.bd.convert;

import com.suk.zhenya.bd.dto.CrudDoctorScheduleDto;
import com.suk.zhenya.bd.dto.DoctorScheduleDto;
import com.suk.zhenya.bd.entity.DoctorSchedule;
import com.suk.zhenya.bd.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DoctorScheduleConverter {

    private DoctorRepository repository;

    public DoctorScheduleDto convertToDoctorScheduleDto(DoctorSchedule doctorSchedule) {
        return DoctorScheduleDto.builder()
                .id(doctorSchedule.getId())
                .availableTo(doctorSchedule.getAvailableTo())
                .availableFrom(doctorSchedule.getAvailableFrom())
                .dayOfWeek(doctorSchedule.getDayOfWeek())
                .build();
    }

    public DoctorSchedule convertToDoctorSchedule(Long id, CrudDoctorScheduleDto dto) {
        return DoctorSchedule.builder()
                .availableFrom(dto.getAvailableFrom())
                .availableTo(dto.getAvailableTo())
                .dayOfWeek(dto.getDayOfWeek())
                .doctor(repository.findById(id).orElseThrow())
                .build();
    }
}
