package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.ContractManagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractManagementRepository extends JpaRepository<ContractManagement, Long> {
    Optional<ContractManagement> findById(Long id);
}
