package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.ContractManagementRequestDTO;
import br.com.main.project.contalogic.model.services.ContractManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract_management")
public class ContractManagementController {

    @Autowired
    private ContractManagementService contractManagementService;

    @GetMapping
    public ResponseEntity getContractManagement(){
        return contractManagementService.getContractManagement();
    }

    @PostMapping("/create")
    public ResponseEntity createContractManagement(@RequestBody @Valid ContractManagementRequestDTO data){
        return contractManagementService.createContractManagement(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateContractManagement(@RequestBody @Valid ContractManagementRequestDTO data){
        return contractManagementService.updateContractManagement(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContractManagement(@PathVariable Long id){
        return contractManagementService.deleteContractManagement(id);

    }

}
