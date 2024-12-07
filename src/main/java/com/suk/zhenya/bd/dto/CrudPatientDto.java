package com.suk.zhenya.bd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "CRUD DTO для пацієнта")
public class CrudPatientDto {

    @Schema(description = "Ім'я пацієнта", example = "Іван")
    @JsonProperty("firstName")
    private String firstName;

    @Schema(description = "Прізвище пацієнта", example = "Шевченко")
    @JsonProperty("lastName")
    private String lastName;

    @Schema(description = "По батькові пацієнта", example = "Іванович")
    @JsonProperty("middleName")
    private String middleName;

    @Schema(description = "Адреса проживання пацієнта", example = "м. Київ, вул. Шевченка, 10")
    @JsonProperty("address")
    private String address;

    @Schema(description = "Контактний телефон пацієнта", example = "+380501234567")
    @JsonProperty("phone")
    private String phone;

    @Schema(description = "Email пацієнта", example = "patient@example.com")
    @JsonProperty("email")
    private String email;

    @Schema(description = "Дата народження пацієнта у форматі yyyy-MM-dd", example = "1990-05-20")
    @JsonProperty("birthDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
