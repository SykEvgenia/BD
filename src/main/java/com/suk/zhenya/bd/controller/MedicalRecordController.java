package com.suk.zhenya.bd.controller;

import com.suk.zhenya.bd.dto.CrudMedicalRecordDto;
import com.suk.zhenya.bd.dto.MedicalRecordDto;
import com.suk.zhenya.bd.service.MedicalRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Medical Record Controller", description = "Операції для управління медичними записами пацієнтів")
public class MedicalRecordController {

    private final MedicalRecordService service;

    @Operation(summary = "Отримати медичні записи пацієнта",
            description = "Повертає список медичних записів для конкретного пацієнта за його ID.")
    @GetMapping("/patient/{patientId}/medical/record")
    public List<MedicalRecordDto> getMedicalRecord(@PathVariable Long patientId) {
        return service.getMedicalRecord(patientId);
    }

    @Operation(summary = "Додати медичний запис для пацієнта",
            description = "Додає новий медичний запис для пацієнта за його ID.")
    @PostMapping("/patient/{patientId}/medical/record")
    public MedicalRecordDto addMedicalRecord(@PathVariable Long patientId, @RequestBody CrudMedicalRecordDto dto) {
        return service.addMedicalRecord(patientId, dto);
    }

    @Operation(summary = "Видалити медичний запис пацієнта",
            description = "Видаляє медичний запис за ID пацієнта та ID запису.")
    @DeleteMapping("/medical/record/{medicalRecordId}")
    public void deleteMedicalRecord(@PathVariable Long medicalRecordId) {
        service.deleteMedicalRecord(medicalRecordId);
    }
}
