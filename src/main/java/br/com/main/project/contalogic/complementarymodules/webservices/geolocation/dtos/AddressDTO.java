package br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos;

public record AddressDTO(Long id,
                         String zipCode,
                         String street,
                         String complement,
                         String neighborhood,
                         String locality,
                         String federativeUnit,
                         String state,
                         String region
                         ) {
}
