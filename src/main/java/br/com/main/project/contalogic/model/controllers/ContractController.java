package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.ContractRequestDTO;
import br.com.main.project.contalogic.model.services.ContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;


    @GetMapping
    public ResponseEntity getContracts(){
        return contractService.getContracts();
    }

    @PostMapping("/create")
    public ResponseEntity createContract(@RequestBody @Valid ContractRequestDTO data){
        return contractService.createContract(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateContract(@RequestBody @Valid ContractRequestDTO data){
        return contractService.updateContract(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContract(@PathVariable Long id){
        return contractService.deleteContract(id);

    }
}
