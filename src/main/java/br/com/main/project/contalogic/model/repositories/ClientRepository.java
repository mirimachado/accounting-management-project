package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(Long id);
    Optional<Client> findByFantasyName(String fantasyName);
    Optional<Client> findByEmail(String email);
    Optional<Client> findByTelephone(String telephone);
}
