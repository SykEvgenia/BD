package com.suk.zhenya.bd.controller;

import com.suk.zhenya.bd.dto.CrudPatientDto;
import com.suk.zhenya.bd.dto.PatientDto;
import com.suk.zhenya.bd.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Patient Controller", description = "Операції для управління пацієнтами")
public class PatientController {

    private final PatientService service;

    @Operation(summary = "Отримати список всіх пацієнтів",
            description = "Повертає список всіх пацієнтів, доступних у базі даних.")
    @GetMapping("/patient")
    public List<PatientDto> getPatients() {
        return service.getPatients();
    }

    @Operation(summary = "Отримати пацієнта за ID",
            description = "Повертає дані про конкретного пацієнта на основі його ID.")
    @GetMapping("/patient/{id}")
    public PatientDto getPatient(@PathVariable Long id) {
        return service.getPatient(id);
    }

    @Operation(summary = "Додати нового пацієнта",
            description = "Додає нового пацієнта до бази даних.")
    @PostMapping("/patient")
    public PatientDto addPatient(@RequestBody CrudPatientDto dto) {
        return service.addPatient(dto);
    }

    @Operation(summary = "Оновити дані пацієнта",
            description = "Оновлює інформацію про пацієнта на основі його ID.")
    @PutMapping("/patient/{id}")
    public PatientDto updatePatient(@PathVariable Long id, @RequestBody CrudPatientDto dto) {
        return service.updatePatient(id, dto);
    }

    @Operation(summary = "Видалити пацієнта",
            description = "Видаляє пацієнта з бази даних за його ID.")
    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
    }
}
