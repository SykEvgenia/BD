package com.suk.zhenya.bd.controller;

import com.suk.zhenya.bd.dto.AppointmentDto;
import com.suk.zhenya.bd.dto.CrudAppointmentDto;
import com.suk.zhenya.bd.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Appointment Controller", description = "Операції для роботи із записами до лікарів")
public class AppointmentController {

    private final AppointmentService service;

    @Operation(summary = "Отримати всі записи лікаря", description = "Отримує список записів для лікаря за його ідентифікатором")
    @GetMapping("/doctor/{doctorId}/appointment")
    public List<AppointmentDto> getAppointments(@PathVariable Long doctorId) {
        return service.getAppointments(doctorId);
    }

    @Operation(summary = "Додати запис до лікаря", description = "Додає новий запис до лікаря на основі переданих даних")
    @PostMapping("/doctor/appointment")
    public void addAppointment(@RequestBody CrudAppointmentDto dto) {
        service.addAppointment(dto);
    }

    @Operation(summary = "Видалити запис до лікаря", description = "Видаляє запис до лікаря на основі переданих даних")
    @DeleteMapping("/doctor/appointment/{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId) {
        service.deleteAppointment(appointmentId);
    }
}
