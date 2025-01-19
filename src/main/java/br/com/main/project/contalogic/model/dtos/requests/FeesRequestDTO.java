package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.entities.Client;
import br.com.main.project.contalogic.model.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FeesRequestDTO(Long id,
                             @NotBlank
                             Double valueFees,
                             @NotBlank
                             Client client,
                             @NotBlank
                             String service,
                             @NotBlank
                             String situation,
                             @NotBlank
                             String additionalInformation,
                             @NotBlank
                             PaymentMethod paymentMethod,
                             @NotNull
                             LocalDate competence
                             ) {
}
