package com.suk.zhenya.bd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "CRUD DTO для медичної картки пацієнта")
public class CrudMedicalRecordDto {

    @Schema(description = "Дата візиту", example = "2024-12-01")
    @JsonProperty("visitDate")
    private LocalDate visitDate;

    @Schema(description = "Діагноз, поставлений пацієнту", example = "Гіпертонія")
    @JsonProperty("diagnosis")
    private String diagnosis;

    @Schema(description = "Призначене лікування", example = "Антигіпертензивна терапія")
    @JsonProperty("treatment")
    private String treatment;

    @Schema(description = "Ідентифікатор лікаря", example = "5")
    @JsonProperty("doctorId")
    private Long doctorId;
}
