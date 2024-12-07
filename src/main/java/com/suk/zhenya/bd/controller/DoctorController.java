package com.suk.zhenya.bd.controller;

import com.suk.zhenya.bd.dto.CrudDoctorDto;
import com.suk.zhenya.bd.dto.DoctorDto;
import com.suk.zhenya.bd.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Doctor Controller", description = "Операції для управління лікарями")
public class DoctorController {

    private final DoctorService service;

    @Operation(summary = "Отримати список всіх лікарів", description = "Повертає список всіх лікарів, доступних у базі даних.")
    @GetMapping("/doctor")
    public List<DoctorDto> getDoctors() {
        return service.getDoctors();
    }

    @Operation(summary = "Отримати лікаря за ідентифікатором", description = "Повертає дані про конкретного лікаря на основі його ID.")
    @GetMapping("/doctor/{id}")
    public DoctorDto getDoctor(@PathVariable Long id) {
        return service.getDoctor(id);
    }

    @Operation(summary = "Додати нового лікаря", description = "Додає нового лікаря до бази даних.")
    @PostMapping("/doctor")
    public DoctorDto addDoctor(@RequestBody CrudDoctorDto dto) {
        return service.addDoctor(dto);
    }

    @Operation(summary = "Оновити дані лікаря", description = "Оновлює інформацію про лікаря на основі його ID.")
    @PutMapping("/doctor/{id}")
    public DoctorDto updateDoctor(@PathVariable Long id, @RequestBody CrudDoctorDto dto) {
        return service.updateDoctor(id, dto);
    }
}
