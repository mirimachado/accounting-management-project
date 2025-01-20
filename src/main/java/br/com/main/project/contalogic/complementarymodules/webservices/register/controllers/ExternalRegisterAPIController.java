package br.com.main.project.contalogic.complementarymodules.webservices.register.controllers;

import br.com.main.project.contalogic.complementarymodules.webservices.register.services.ExternalRegisterAPIService;
import br.com.main.project.contalogic.complementarymodules.webservices.register.dtos.ExternalRegisterRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class ExternalRegisterAPIController {

    @Autowired
    private ExternalRegisterAPIService apiService;

    @PostMapping("/cnpj")
    public ResponseEntity<Object> sendAddress(@RequestBody @Valid ExternalRegisterRequestDTO address) {
        return apiService.sendAddress(address);
    }

}
