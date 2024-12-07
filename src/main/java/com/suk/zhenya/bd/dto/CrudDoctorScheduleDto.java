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
@Schema(description = "CRUD DTO для графіка роботи лікаря")
public class CrudDoctorScheduleDto {

    @Schema(description = "Час початку доступності лікаря", example = "08:00")
    @JsonProperty("availableFrom")
    private LocalTime availableFrom;

    @Schema(description = "Час закінчення доступності лікаря", example = "16:00")
    @JsonProperty("availableTo")
    private LocalTime availableTo;

    @Schema(description = "День тижня, коли лікар доступний", example = "Monday")
    @JsonProperty("dayOfWeek")
    private String dayOfWeek;
}
