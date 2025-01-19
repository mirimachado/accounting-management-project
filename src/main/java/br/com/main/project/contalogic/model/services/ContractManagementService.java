package br.com.main.project.contalogic.model.services;

import br.com.main.project.contalogic.model.dtos.requests.ContractManagementRequestDTO;
import br.com.main.project.contalogic.model.entities.ContractManagement;
import br.com.main.project.contalogic.model.repositories.ContractManagementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ContractManagementService {

    @Autowired
    private ContractManagementRepository repository;


    public ResponseEntity<List<ContractManagement>> getContractManagement(){
        List<ContractManagement> contractManagements = repository.findAll();
        return ResponseEntity.ok(contractManagements);

    }

    @Transactional
    public ResponseEntity<String> createContractManagement(ContractManagementRequestDTO data){
            ContractManagement contractManagement = new ContractManagement();
            contractManagement.setService(data.service());
            contractManagement.setClient(data.client());
            contractManagement.setValidity(data.validity());
            contractManagement.setAdditionalInformation(data.additionalInformation());
            repository.save(contractManagement);

        return ResponseEntity.ok("Gerenciamento de contrato criado com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateContractManagement(ContractManagementRequestDTO data){
        Optional<ContractManagement> contractManagementOptional = repository.findById(data.id());
        if (contractManagementOptional.isPresent()){
            ContractManagement contractManagement = new ContractManagement();
            contractManagement.setService(data.service());
            contractManagement.setClient(data.client());
            contractManagement.setValidity(data.validity());
            contractManagement.setAdditionalInformation(data.additionalInformation());
            repository.save(contractManagement);
            return ResponseEntity.ok("Gerenciamento de contrato atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteContractManagement(@PathVariable Long id){
        Optional<ContractManagement> contractManagement = repository.findById(id);
        if (contractManagement.isPresent()){
            repository.deleteById(contractManagement.get().getId());
            return ResponseEntity.ok("Gerenciamento de contrato excluído com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
