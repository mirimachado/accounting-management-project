package br.com.main.project.contalogic.model.services;

import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.repositories.ExternalGeolocationRepository;
import br.com.main.project.contalogic.model.dtos.requests.ClientRequestDTO;
import br.com.main.project.contalogic.model.entities.Client;
import br.com.main.project.contalogic.model.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ExternalGeolocationRepository geolocationRepository;

    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = repository.findAll();
        return ResponseEntity.ok(clients);

    }

    @Transactional
    public ResponseEntity<String> createClient(ClientRequestDTO data){
        Optional<Client> fantasyName = repository.findByFantasyName(data.fantasyName());
        Optional<Client> email = repository.findByEmail(data.email());
        Optional<Client> telephone = repository.findByTelephone(data.telephone());

        if (fantasyName.isPresent()){
            return ResponseEntity.badRequest().body("Já existe um cliente com esse nome, tente novamente! ");
        } else if (email.isPresent() || telephone.isPresent()) {
            return ResponseEntity.badRequest().body("Já existe um cliente com esse e-mail ou telefone, tente novamente! ");

        } else{
            Client client = new Client();
            client.setAddress(data.address());
            client.setEmail(data.email());
            client.setTelephone(data.telephone());
            client.setEntryDate(data.entryDate());
            client.setCorporateReason(data.corporateReason());
            client.setFantasyName(data.fantasyName());
            geolocationRepository.save(data.address());
            repository.save(client);
        }
        return ResponseEntity.ok("Cliente criado com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateClient(ClientRequestDTO data){
        Optional<Client> clientOptional = repository.findById(data.id());
        if (clientOptional.isPresent()){
            Client client = new Client();
            client.setAddress(data.address());
            client.setEmail(data.email());
            client.setTelephone(data.telephone());
            client.setEntryDate(data.entryDate());
            client.setCorporateReason(data.corporateReason());
            client.setFantasyName(data.fantasyName());
            repository.save(client);
            return ResponseEntity.ok("Cliente atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()){
            repository.deleteById(client.get().getId());
            return ResponseEntity.ok("Cliente excluído com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
