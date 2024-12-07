package com.suk.zhenya.bd.service;

import com.suk.zhenya.bd.convert.AppointmentConverter;
import com.suk.zhenya.bd.dto.AppointmentDto;
import com.suk.zhenya.bd.dto.CrudAppointmentDto;
import com.suk.zhenya.bd.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {

    private AppointmentRepository repository;
    private AppointmentConverter converter;

    public List<AppointmentDto> getAppointments(Long doctorId) {
        return repository.findByDoctorId(doctorId).stream()
                .map(converter::convertToAppointmentDto)
                .toList();
    }

    public void addAppointment(CrudAppointmentDto dto) {
        repository.save(converter.convertToAppointment(dto));
    }

    public void deleteAppointment(Long appointmentId) {
        repository.deleteById(appointmentId);
    }
}
