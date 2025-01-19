package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.ClientInformationRequestDTO;
import br.com.main.project.contalogic.model.services.ClientInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client_informations")
public class ClientInformationController {

    @Autowired
    private ClientInformationService clientInformationService;

    @GetMapping
    public ResponseEntity getClientInformations(){
        return clientInformationService.getClientInformations();
    }

    @PostMapping("/create")
    public ResponseEntity createClientInformation(@RequestBody @Valid ClientInformationRequestDTO data){
        return clientInformationService.createClientInformation(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateClientInformation(@RequestBody @Valid ClientInformationRequestDTO data){
        return clientInformationService.updateClientInformation(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClientInformation(@PathVariable Long id){
        return clientInformationService.deleteClientInformation(id);

    }


}
