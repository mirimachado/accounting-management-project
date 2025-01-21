package br.com.main.project.contalogic.model.services;

import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.repositories.ExternalGeolocationRepository;
import br.com.main.project.contalogic.model.dtos.requests.PartnerRequestDTO;
import br.com.main.project.contalogic.model.entities.Partner;
import br.com.main.project.contalogic.model.repositories.PartnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository repository;

    @Autowired
    private ExternalGeolocationRepository geolocationRepository;


    public ResponseEntity<List<Partner>> getPartners(){
        List<Partner> partners = repository.findAll();
        return ResponseEntity.ok(partners);

    }

    @Transactional
    public ResponseEntity createPartner(PartnerRequestDTO data){
        Optional<Partner> partnerName = repository.findByName(data.name());
        Optional<Partner> partnerTelephone = repository.findByTelephone(data.telephone());
        Optional<Partner> partnerEmail = repository.findByEmail(data.email());
        Optional<Partner> partnerCpf = repository.findByCpf(data.cpf());

        if (partnerName.isPresent() || partnerEmail.isPresent()){
            return ResponseEntity.badRequest().body("Já existe um sócio com esse nome ou e-mail, tente novamente! ");
        }
        else if (partnerTelephone.isPresent() || partnerCpf.isPresent()){
            return ResponseEntity.badRequest().body("Já existe um sócio com esse telefone ou cpf, tente novamente! ");
        }
        else{
            Partner partner = new Partner();
            partner.setName(data.name());
            partner.setCpf(data.cpf());
            partner.setEmail(data.email());
            partner.setAddress(data.address());
            partner.setVacancy(data.vacancy());
            partner.setClient(data.client());
            partner.setTelephone(data.telephone());
            geolocationRepository.save(data.address());
            repository.save(partner);
        }
        return ResponseEntity.ok("Sócio criado com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updatePartner(PartnerRequestDTO data){
        Optional<Partner> partnerOptional = repository.findById(data.id());
        if (partnerOptional.isPresent()){
            Partner partner = new Partner();
            partner.setName(data.name());
            partner.setCpf(data.cpf());
            partner.setEmail(data.email());
            partner.setAddress(data.address());
            partner.setVacancy(data.vacancy());
            partner.setClient(data.client());
            partner.setTelephone(data.telephone());
            geolocationRepository.save(data.address());
            repository.save(partner);
            return ResponseEntity.ok("Sócio atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deletePartner(@PathVariable Long id){
        Optional<Partner> partner = repository.findById(id);
        if (partner.isPresent()){
            repository.deleteById(partner.get().getId());
            return ResponseEntity.ok("Sócio excluído com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }
}
