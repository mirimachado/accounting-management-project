package br.com.main.project.contalogic.model.services;

import br.com.main.project.contalogic.model.dtos.requests.ContractRequestDTO;
import br.com.main.project.contalogic.model.entities.Contract;
import br.com.main.project.contalogic.model.repositories.ContractRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repository;


    public ResponseEntity<List<Contract>> getContracts(){
        List<Contract> contracts = repository.findAll();
        return ResponseEntity.ok(contracts);

    }

    @Transactional
    public ResponseEntity<String> createContract(ContractRequestDTO data){
        Optional<Contract> contractNumber = repository.findByContractNumber(data.contractNumber());
        Optional<Contract> contractTitle = repository.findByContractTitle(data.contractTitle());

        if (contractTitle.isPresent()){
            return ResponseEntity.badRequest().body("Já existe um contrato com esse título, tente novamente! ");
        } else if (contractNumber.isPresent()) {
            return ResponseEntity.badRequest().body("Já existe um contrato com esse número, tente novamente! ");
        } else{
           Contract contract = new Contract();
           contract.setContractManagement(data.contractManagement());
           contract.setContractTitle(data.contractTitle());
           contract.setContractNumber(data.contractNumber());
           contract.setFile(data.file());
           repository.save(contract);
        }
        return ResponseEntity.ok("Contrato criado com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateContract(ContractRequestDTO data){
        Optional<Contract> contractOptional = repository.findById(data.id());
        if (contractOptional.isPresent()){
            Contract contract = new Contract();
            contract.setContractManagement(data.contractManagement());
            contract.setContractTitle(data.contractTitle());
            contract.setContractNumber(data.contractNumber());
            contract.setFile(data.file());
            repository.save(contract);
            return ResponseEntity.ok("Contrato atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteContract(@PathVariable Long id){
        Optional<Contract> contract = repository.findById(id);
        if (contract.isPresent()){
            repository.deleteById(contract.get().getId());
            return ResponseEntity.ok("Contrato excluído com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
