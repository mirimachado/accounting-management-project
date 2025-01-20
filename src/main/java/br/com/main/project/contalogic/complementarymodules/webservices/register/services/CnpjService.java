package br.com.main.project.contalogic.complementarymodules.webservices.register.services;

import br.com.main.project.contalogic.complementarymodules.webservices.register.dtos.CnpjDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.register.repositories.ExternalRegisterRepository;
import br.com.main.project.contalogic.model.entities.Cnpj;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CnpjService {

    @Autowired
    private ExternalRegisterRepository repository;

    public ResponseEntity<List<Cnpj>> getCnpjs(){
        List<Cnpj> cnpjs = repository.findAll();
        return ResponseEntity.ok(cnpjs);

    }

    @Transactional
    public ResponseEntity createCnpj(CnpjDTO data){
        Optional<Cnpj> cnpjOptional = repository.findByCnpj(data.cnpj());
        if (cnpjOptional.isPresent()){
            return ResponseEntity.badRequest().body("Esse CNPJ já está registrado no sistema, tente novamente! ");
        }
        else{
            Cnpj cnpj = new Cnpj();
            cnpj.setCnpj(data.cnpj());
            cnpj.setCnaeTaxDescription(data.cnaeTaxDescription());
            cnpj.setDateInitialActivity(data.dateInitialActivity());
            cnpj.setDescriptionCadastralStatus(data.descriptionCadastralStatus());
            cnpj.setRegistrationStatusDate(data.registrationStatusDate());
            repository.save(cnpj);
        }
        return ResponseEntity.ok("Dados do CNPJ criado com sucesso. ");

    }

    @Transactional
    public ResponseEntity<String> updateCnpj(CnpjDTO data){
        Optional<Cnpj> cnpjOptional = repository.findById(data.id());
        if (cnpjOptional.isPresent()){
            Cnpj cnpj = new Cnpj();
            cnpj.setCnpj(data.cnpj());
            cnpj.setCnaeTaxDescription(data.cnaeTaxDescription());
            cnpj.setDateInitialActivity(data.dateInitialActivity());
            cnpj.setDescriptionCadastralStatus(data.descriptionCadastralStatus());
            cnpj.setRegistrationStatusDate(data.registrationStatusDate());
            repository.save(cnpj);
            return ResponseEntity.ok("Dados do CNPJ atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteCnpj(@PathVariable Long id){
        Optional<Cnpj> cnpj = repository.findById(id);
        if (cnpj.isPresent()){
            repository.deleteById(cnpj.get().getId());
            return ResponseEntity.ok("Dados do CNPJ excluído com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }
}
