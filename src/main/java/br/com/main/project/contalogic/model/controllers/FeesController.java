package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.FeesRequestDTO;
import br.com.main.project.contalogic.model.services.FeesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fees")
public class FeesController {

    @Autowired
    private FeesService feesService;

    @GetMapping
    public ResponseEntity getFees(){
        return feesService.getFees();
    }

    @PostMapping("/create")
    public ResponseEntity createFees(@RequestBody @Valid FeesRequestDTO data){
        return feesService.createFees(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateFees(@RequestBody @Valid FeesRequestDTO data){
        return feesService.updateFees(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFees(@PathVariable Long id){
        return feesService.deleteFees(id);

    }


}
