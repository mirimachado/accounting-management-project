package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.Fees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeesRepository extends JpaRepository<Fees, Long> {
    Optional<Fees> findById(Long id);
}
