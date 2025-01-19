package br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeolocationDataDTO(
                                 @NonNull
                                 @JsonAlias("cep") String zipCode,
                                 @NonNull
                                 @JsonAlias("logradouro") String street,
                                 @NonNull
                                 @JsonAlias("complemento") String complement,
                                 @NonNull
                                 @JsonAlias("bairro") String neighborhood,
                                 @NonNull
                                 @JsonAlias("localidade") String locality,
                                 @NonNull
                                 @JsonAlias("uf") String federativeUnit,
                                 @NonNull
                                 @JsonAlias("estado") String state,
                                 @NonNull
                                 @JsonAlias("regiao") String region
                                 ) {
}
