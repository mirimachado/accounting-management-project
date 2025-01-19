package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PermissionRequestDTO(Long id,
                                   User user,
                                   @NotBlank
                                   String permissionName,
                                   @NotBlank
                                   String type,
                                   @NotBlank
                                   String description,
                                   @NotNull
                                   LocalDate creationDate
                                   ) {
}
