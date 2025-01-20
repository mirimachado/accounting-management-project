package br.com.main.project.contalogic.complementarymodules.webservices.register.dtos;

import java.time.LocalDate;

public record CnpjDTO(Long id,
                      String cnpj,
                      String descriptionCadastralStatus,
                      LocalDate registrationStatusDate,
                      LocalDate dateInitialActivity,
                      String cnaeTaxDescription
                      ) {
}
