package br.com.main.project.contalogic.complementarymodules.webservices.register.controllers;

import br.com.main.project.contalogic.complementarymodules.webservices.register.dtos.CnpjDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.register.services.CnpjService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cnpjs")
public class CnpjController {

    @Autowired
    private CnpjService cnpjService;

    @GetMapping
    public ResponseEntity getCnpjs(){
        return cnpjService.getCnpjs();
    }

    @PostMapping("/create")
    public ResponseEntity createCnpj(@RequestBody @Valid CnpjDTO data){
        return cnpjService.createCnpj(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateCnpj(@RequestBody @Valid CnpjDTO data){
        return cnpjService.updateCnpj(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCnpj(@PathVariable Long id){
        return cnpjService.deleteCnpj(id);

    }
}
