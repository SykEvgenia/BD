package com.suk.zhenya.bd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "CRUD DTO для лікаря")
public class CrudDoctorDto {

    @Schema(description = "Ім'я лікаря", example = "Олександр")
    @JsonProperty("firstName")
    private String firstName;

    @Schema(description = "Прізвище лікаря", example = "Петренко")
    @JsonProperty("lastName")
    private String lastName;

    @Schema(description = "По батькові лікаря", example = "Михайлович")
    @JsonProperty("middleName")
    private String middleName;

    @Schema(description = "Телефон лікаря", example = "+380501234567")
    @JsonProperty("phone")
    private String phone;

    @Schema(description = "Email лікаря", example = "doctor@example.com")
    @JsonProperty("email")
    private String email;

    @Schema(description = "Спеціалізація лікаря", example = "Кардіолог")
    @JsonProperty("specialization")
    private String specialization;
}
