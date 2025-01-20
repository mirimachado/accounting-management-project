package br.com.main.project.contalogic.complementarymodules.webservices.register.repositories;

import br.com.main.project.contalogic.model.entities.Cnpj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExternalRegisterRepository extends JpaRepository<Cnpj, Long> {
    Optional<Cnpj> findById(Long id);
    Optional<Cnpj> findByCnpj(String cnpj);
}
