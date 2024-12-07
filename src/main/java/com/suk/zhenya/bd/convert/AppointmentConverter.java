package com.suk.zhenya.bd.convert;

import com.suk.zhenya.bd.dto.AppointmentDto;
import com.suk.zhenya.bd.dto.CrudAppointmentDto;
import com.suk.zhenya.bd.entity.Appointment;
import com.suk.zhenya.bd.repository.DoctorRepository;
import com.suk.zhenya.bd.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppointmentConverter {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public AppointmentDto convertToAppointmentDto(Appointment appointment) {
        return AppointmentDto.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime())
                .doctorId(appointment.getDoctor().getId())
                .patientId(appointment.getPatient().getId())
                .build();
    }

    public Appointment convertToAppointment(CrudAppointmentDto dto) {
        return Appointment.builder()
                .appointmentDate(dto.getAppointmentDate())
                .appointmentTime(dto.getAppointmentTime())
                .doctor(doctorRepository.findById(dto.getDoctorId()).orElseThrow())
                .patient(patientRepository.findById(dto.getPatientId()).orElseThrow())
                .build();
    }
}
