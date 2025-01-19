package br.com.main.project.contalogic.complementarymodules.webservices.geolocation.repositories;

import br.com.main.project.contalogic.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExternalGeolocationRepository extends JpaRepository<Address, Long> {
    Optional<Address> findById(Long id);

}
