package br.com.main.project.contalogic.model.dtos.requests;


import br.com.main.project.contalogic.model.entities.ContractManagement;
import br.com.main.project.contalogic.model.entities.File;
import jakarta.validation.constraints.NotBlank;

public record ContractRequestDTO(Long id,
                                 @NotBlank
                                 String contractTitle,
                                 @NotBlank
                                 Integer contractNumber,
                                 @NotBlank
                                 ContractManagement contractManagement,
                                 @NotBlank
                                 File file
                                 ) {
}
