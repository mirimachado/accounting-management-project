package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.entities.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientRequestDTO(Long id,
                               @NotBlank
                               String fantasyName,
                               @NotBlank
                               String corporateReason,
                               @NotBlank
                               String telephone,
                               @NotBlank
                               Address address,
                               @NotBlank
                               String email,
                               @NotNull
                               LocalDate entryDate
                               ) {
}
