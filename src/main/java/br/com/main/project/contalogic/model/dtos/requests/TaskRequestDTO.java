package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.entities.User;
import br.com.main.project.contalogic.model.enums.RecurringType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TaskRequestDTO(Long id,
                             @NotNull
                             User user,
                             @NotBlank
                             String taskName,
                             @NotBlank
                             String additionalInformation,
                             @NotNull
                             RecurringType recurringType,
                             @NotNull
                             @JsonFormat(pattern = "yyyy-MM-dd")
                             LocalDate expirationDate,
                             @NotNull
                             Boolean generatesFine,
                             @NotNull
                             Integer taskNumber,
                             @NotBlank
                             String taskStatus,
                             @NotNull
                             Boolean automaticallyGenerating
                             ) {
}
