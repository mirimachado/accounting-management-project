package br.com.main.project.contalogic.complementarymodules.webservices.geolocation.controllers;

import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos.ExternalGeolocationRequestDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.services.ExternalGeolocationAPIService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/query")
public class ExternalGeolocationAPIController {

    @Autowired
    private ExternalGeolocationAPIService apiService;

    @PostMapping("/address")
    public ResponseEntity<Object> sendAddress(@RequestBody @Valid ExternalGeolocationRequestDTO address) {
        return apiService.sendAddress(address);
    }
}
