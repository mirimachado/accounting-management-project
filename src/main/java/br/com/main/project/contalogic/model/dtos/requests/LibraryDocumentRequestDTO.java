package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.entities.File;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDate;
import java.util.List;

public record LibraryDocumentRequestDTO(Long id,
                                        @NotBlank
                                        String documentType,
                                        LocalDate creationDate,
                                        @NotBlank
                                        String folderName,
                                        @NotBlank
                                        List<File> file
                                        ) {
}
