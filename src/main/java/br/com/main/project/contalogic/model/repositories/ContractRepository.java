package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Optional<Contract> findById(Long id);
    Optional<Contract> findByContractTitle(String contractTitle);
    Optional<Contract> findByContractNumber(Integer contractNumber);
}

