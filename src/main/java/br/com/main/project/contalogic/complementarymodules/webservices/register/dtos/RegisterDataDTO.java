package br.com.main.project.contalogic.complementarymodules.webservices.register.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NonNull;


@JsonIgnoreProperties(ignoreUnknown = true)
public record RegisterDataDTO( @NonNull
                               @JsonAlias("cnpj") String cnpj,
                               @NonNull
                               @JsonAlias("descricao_situacao_cadastral") String descriptionCadastralStatus,
                               @NonNull
                               @JsonAlias("data_situacao_cadastral") String registrationStatusDate,
                               @NonNull
                               @JsonAlias("data_inicio_atividade") String dateInitialActivity,
                               @NonNull
                               @JsonAlias("cnae_fiscal_descricao") String cnaeTaxDescription
                             ) {
}
