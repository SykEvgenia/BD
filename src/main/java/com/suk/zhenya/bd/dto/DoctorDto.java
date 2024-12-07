package com.suk.zhenya.bd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO для лікаря")
public class DoctorDto {

    @Schema(description = "Унікальний ідентифікатор лікаря", example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "Ім'я лікаря", example = "Іван")
    @JsonProperty("firstName")
    private String firstName;

    @Schema(description = "Прізвище лікаря", example = "Шевченко")
    @JsonProperty("lastName")
    private String lastName;

    @Schema(description = "По батькові лікаря", example = "Іванович")
    @JsonProperty("middleName")
    private String middleName;

    @Schema(description = "Контактний телефон лікаря", example = "+380501234567")
    @JsonProperty("phone")
    private String phone;

    @Schema(description = "Email лікаря", example = "doctor@example.com")
    @JsonProperty("email")
    private String email;

    @Schema(description = "Спеціалізація лікаря", example = "Терапевт")
    @JsonProperty("specialization")
    private String specialization;
}
