package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.ClientRequestDTO;
import br.com.main.project.contalogic.model.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping
    public ResponseEntity getClients(){
        return clientService.getClients();
    }

    @PostMapping("/create")
    public ResponseEntity createFClient(@RequestBody @Valid ClientRequestDTO data){
        return clientService.createClient(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody @Valid ClientRequestDTO data){
        return clientService.updateClient(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);

    }


}
