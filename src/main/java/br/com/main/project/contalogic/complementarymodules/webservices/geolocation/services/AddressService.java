package br.com.main.project.contalogic.complementarymodules.webservices.geolocation.services;

import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos.AddressDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.repositories.ExternalGeolocationRepository;
import br.com.main.project.contalogic.model.entities.Address;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {


    @Autowired
    private ExternalGeolocationRepository repository;

    public ResponseEntity<List<Address>> getAddress(){
        List<Address> addresses = repository.findAll();
        return ResponseEntity.ok(addresses);

    }

    @Transactional
    public ResponseEntity createAddress(AddressDTO data){
            Address address = new Address();
            address.setZipCode(data.zipCode());
            address.setStreet(data.street());
            address.setState(data.state());
            address.setRegion(data.region());
            address.setNeighborhood(data.neighborhood());
            address.setNeighborhood(data.locality());
            address.setFederativeUnit(data.federativeUnit());
            address.setComplement(data.complement());
            repository.save(address);

        return ResponseEntity.ok("Dado do endereço criado com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateAddress(AddressDTO data){
        Optional<Address> addressOptional = repository.findById(data.id());
        if (addressOptional.isPresent()){
            Address address = new Address();
            address.setZipCode(data.zipCode());
            address.setStreet(data.street());
            address.setState(data.state());
            address.setRegion(data.region());
            address.setNeighborhood(data.neighborhood());
            address.setNeighborhood(data.locality());
            address.setFederativeUnit(data.federativeUnit());
            address.setComplement(data.complement());
            repository.save(address);
            return ResponseEntity.ok("Dado do endereço atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
        Optional<Address> address = repository.findById(id);
        if (address.isPresent()){
            repository.deleteById(address .get().getId());
            return ResponseEntity.ok("Dado do endereço excluído com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
