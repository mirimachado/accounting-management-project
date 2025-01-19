package br.com.main.project.contalogic.model.services;


import br.com.main.project.contalogic.model.dtos.requests.FeesRequestDTO;
import br.com.main.project.contalogic.model.entities.Fees;
import br.com.main.project.contalogic.model.repositories.FeesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class FeesService {

    @Autowired
    private FeesRepository repository;

    public ResponseEntity<List<Fees>> getFees(){
        List<Fees> fees = repository.findAll();
        return ResponseEntity.ok(fees);

    }

    @Transactional
    public ResponseEntity<String> createFees(FeesRequestDTO data){

            Fees fees = new Fees();
            fees.setService(data.service());
            fees.setValueFees(data.valueFees());
            fees.setClient(data.client());
            fees.setCompetence(data.competence());
            fees.setAdditionalInformation(data.additionalInformation());
            fees.setPaymentMethod(data.paymentMethod());
            fees.setSituation(data.situation());
            repository.save(fees);
        return ResponseEntity.ok("Honorário criado com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateFees(FeesRequestDTO data){
        Optional<Fees> feesOptional = repository.findById(data.id());
        if (feesOptional.isPresent()){
            Fees fees = new Fees();
            fees.setService(data.service());
            fees.setValueFees(data.valueFees());
            fees.setClient(data.client());
            fees.setCompetence(data.competence());
            fees.setAdditionalInformation(data.additionalInformation());
            fees.setPaymentMethod(data.paymentMethod());
            fees.setSituation(data.situation());
            repository.save(fees);
            return ResponseEntity.ok("Honorário atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteFees(@PathVariable Long id){
        Optional<Fees> fees = repository.findById(id);
        if (fees.isPresent()){
            repository.deleteById(fees.get().getId());
            return ResponseEntity.ok("Honorário excluído com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }



}
