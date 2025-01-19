package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ContractManagementRequestDTO(
        Long id,
        @NotBlank
        Client client,
        @NotBlank
        String service,
        @NotBlank
        String additionalInformation,
        @NotNull
        LocalDate validity) {
}
