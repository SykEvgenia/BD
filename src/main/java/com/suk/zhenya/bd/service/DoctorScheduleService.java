package com.suk.zhenya.bd.service;

import com.suk.zhenya.bd.convert.DoctorScheduleConverter;
import com.suk.zhenya.bd.dto.CrudDoctorScheduleDto;
import com.suk.zhenya.bd.dto.DoctorScheduleDto;
import com.suk.zhenya.bd.entity.DoctorSchedule;
import com.suk.zhenya.bd.repository.DoctorRepository;
import com.suk.zhenya.bd.repository.DoctorScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorScheduleService {

    private DoctorScheduleRepository repository;
    private DoctorRepository doctorRepository;
    private DoctorScheduleConverter converter;

    public List<DoctorScheduleDto> getDoctorSchedule(Long doctorId) {
        return repository.findByDoctorId(doctorId).stream()
                .map(converter::convertToDoctorScheduleDto)
                .toList();
    }

    public DoctorScheduleDto addDoctorSchedule(Long id, CrudDoctorScheduleDto dto) {
        return converter.convertToDoctorScheduleDto(repository.save(converter.convertToDoctorSchedule(id, dto)));
    }

    public DoctorScheduleDto updateDoctorSchedule(Long id, CrudDoctorScheduleDto dto) {
        DoctorSchedule doctorSchedule = repository.findById(id).orElseThrow();
        doctorSchedule.setAvailableFrom(dto.getAvailableFrom());
        doctorSchedule.setAvailableTo(dto.getAvailableTo());
        doctorSchedule.setDayOfWeek(dto.getDayOfWeek());
        doctorSchedule.setDoctor(doctorRepository.findById(id).orElseThrow());
        return converter.convertToDoctorScheduleDto(repository.save(doctorSchedule));
    }

    public void deleteDoctorSchedule(Long id) {
        repository.deleteById(id);
    }
}
