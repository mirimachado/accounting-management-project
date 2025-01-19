package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(Long id,
                             @NotBlank
                             String name,
                             UserRole role,
                             @NotBlank
                             String email,
                             @NotBlank
                             String password,
                             String token
                             ) {
}
