package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.PartnerRequestDTO;
import br.com.main.project.contalogic.model.services.PartnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping
    public ResponseEntity getPartners(){
        return partnerService.getPartners();
    }

    @PostMapping("/create")
    public ResponseEntity createPartner(@RequestBody @Valid PartnerRequestDTO data){
        return partnerService.createPartner(data);

    }

    @PutMapping("/update")
    public ResponseEntity updatePartner(@RequestBody @Valid PartnerRequestDTO data){
        return partnerService.updatePartner(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePartner(@PathVariable Long id){
        return partnerService.deletePartner(id);

    }
}
