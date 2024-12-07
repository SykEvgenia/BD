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
@Schema(description = "DTO для медичної картки пацієнта")
public class MedicalRecordDto {

    @Schema(description = "Унікальний ідентифікатор медичної картки", example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "Дата візиту", example = "2024-12-01")
    @JsonProperty("visitDate")
    private LocalDate visitDate;

    @Schema(description = "Діагноз, поставлений пацієнту", example = "Гострий бронхіт")
    @JsonProperty("diagnosis")
    private String diagnosis;

    @Schema(description = "Призначене лікування", example = "Антибіотики, рясне пиття")
    @JsonProperty("treatment")
    private String treatment;

    @Schema(description = "Ідентифікатор лікаря", example = "15")
    @JsonProperty("doctorId")
    private Long doctorId;
}
