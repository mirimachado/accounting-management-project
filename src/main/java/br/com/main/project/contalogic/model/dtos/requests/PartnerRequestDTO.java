package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.entities.Address;
import br.com.main.project.contalogic.model.entities.Client;
import jakarta.validation.constraints.NotBlank;

public record PartnerRequestDTO(Long id,
                                @NotBlank
                                String name,
                                @NotBlank
                                String telephone,
                                @NotBlank
                                String email,
                                @NotBlank
                                Address address,
                                @NotBlank
                                String cpf,
                                @NotBlank
                                String vacancy,
                                @NotBlank
                                Client client
                                ) {
}
