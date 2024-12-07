package com.suk.zhenya.bd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO для запису на прийом до лікаря")
public class AppointmentDto {

    @Schema(description = "Ідентифікатор запису", example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "Дата прийому", example = "2024-12-01")
    @JsonProperty("appointmentDate")
    private LocalDate appointmentDate;

    @Schema(description = "Час прийому", example = "10:30")
    @JsonProperty("appointmentTime")
    private LocalTime appointmentTime;

    @Schema(description = "Ідентифікатор лікаря", example = "5")
    @JsonProperty("doctorId")
    private Long doctorId;

    @Schema(description = "Ідентифікатор користувача", example = "10")
    @JsonProperty("patientId")
    private Long patientId;
}
