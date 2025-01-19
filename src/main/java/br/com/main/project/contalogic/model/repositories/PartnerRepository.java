package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Optional<Partner> findById(Long id);
    Optional<Partner> findByName(String name);
    Optional<Partner> findByCpf(String cpf);
    Optional<Partner> findByEmail(String email);
    Optional<Partner> findByTelephone(String telephone);

}
