package br.com.main.project.contalogic.model.dtos.requests;

import br.com.main.project.contalogic.model.entities.Client;
import br.com.main.project.contalogic.model.entities.Partner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientInformationRequestDTO(Long id,
                                          @NotNull
                                          LocalDate fgtsDate,
                                          @NotNull
                                          LocalDate ecacDate,
                                          @NotBlank
                                          String simpleAccessCode,
                                          @NotBlank
                                          String nfseAccess,
                                          @NotBlank
                                          String companyActivity,
                                          @NotBlank
                                          String municipalStateRegistration,
                                          @NotBlank
                                          Partner responsiblePartner,
                                          @NotBlank
                                          String taxRegime,
                                          @NotBlank
                                          String cityHallNotes,
                                          @NotBlank
                                          Client client
                                          ) {
}
