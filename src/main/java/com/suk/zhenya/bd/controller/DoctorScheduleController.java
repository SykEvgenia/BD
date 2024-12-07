package com.suk.zhenya.bd.controller;

import com.suk.zhenya.bd.dto.CrudDoctorScheduleDto;
import com.suk.zhenya.bd.dto.DoctorScheduleDto;
import com.suk.zhenya.bd.service.DoctorScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Doctor Schedule Controller", description = "Операції для управління розкладом лікарів")
public class DoctorScheduleController {

    private final DoctorScheduleService service;

    @Operation(summary = "Отримати розклад лікаря", description = "Повертає розклад для конкретного лікаря за його ID.")
    @GetMapping("/doctor/{doctorId}/schedule")
    public List<DoctorScheduleDto> getDoctorSchedule(@PathVariable Long doctorId) {
        return service.getDoctorSchedule(doctorId);
    }

    @Operation(summary = "Додати новий розклад для лікаря", description = "Додає новий розклад для лікаря за його ID.")
    @PostMapping("/doctor/{id}/schedule")
    public DoctorScheduleDto addDoctorSchedule(@PathVariable Long id,@RequestBody CrudDoctorScheduleDto dto) {
        return service.addDoctorSchedule(id, dto);
    }

    @Operation(summary = "Оновити розклад", description = "Оновлює існуючий розклад за його ID.")
    @PutMapping("/schedule/{id}")
    public DoctorScheduleDto updateDoctorSchedule(@PathVariable Long id, @RequestBody CrudDoctorScheduleDto dto) {
        return service.updateDoctorSchedule(id, dto);
    }

    @Operation(summary = "Видалити розклад", description = "Видаляє розклад за його ID.")
    @DeleteMapping("/schedule/{id}")
    public void deleteDoctorSchedule(@PathVariable Long id) {
        service.deleteDoctorSchedule(id);
    }
}
