package br.com.main.project.contalogic.complementarymodules.webservices.geolocation.controllers;

import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos.AddressDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @GetMapping
    public ResponseEntity getAddresses(){
        return addressService.getAddress();
    }

    @PostMapping("/create")
    public ResponseEntity createAddress(@RequestBody @Valid AddressDTO data){
        return addressService.createAddress(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO data){
        return addressService.updateAddress(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);

    }

}
