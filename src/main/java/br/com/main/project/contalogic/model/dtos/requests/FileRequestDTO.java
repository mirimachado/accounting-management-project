package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.enums.ExtensionType;
import jakarta.validation.constraints.NotBlank;

public record FileRequestDTO(Long id,
                             @NotBlank
                             String fileSize,
                             @NotBlank
                             ExtensionType extensionType,
                             @NotBlank
                             String fileName
                             ) {
}
