package com.suk.zhenya.bd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO для розкладу лікаря")
public class DoctorScheduleDto {

    @Schema(description = "Унікальний ідентифікатор розкладу", example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "Час початку доступності лікаря", example = "08:00")
    @JsonProperty("availableFrom")
    private LocalTime availableFrom;

    @Schema(description = "Час закінчення доступності лікаря", example = "17:00")
    @JsonProperty("availableTo")
    private LocalTime availableTo;

    @Schema(description = "День тижня, коли лікар доступний", example = "Понеділок")
    @JsonProperty("dayOfWeek")
    private String dayOfWeek;
}
