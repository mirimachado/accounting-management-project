package br.com.main.project.contalogic.model.services;

import br.com.main.project.contalogic.model.dtos.requests.ClientInformationRequestDTO;
import br.com.main.project.contalogic.model.entities.ClientInformation;
import br.com.main.project.contalogic.model.repositories.ClientInformationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClientInformationService {

    @Autowired
    private ClientInformationRepository repository;


    public ResponseEntity<List<ClientInformation>> getClientInformations(){
        List<ClientInformation> clientInformations = repository.findAll();
        return ResponseEntity.ok(clientInformations);

    }

    @Transactional
    public ResponseEntity<String> createClientInformation(ClientInformationRequestDTO data){
        Optional<ClientInformation> client = repository.findByClient(data.client());
        Optional<ClientInformation> partner = repository.findByResponsiblePartner(data.responsiblePartner());

        if (client.isPresent()){
            return ResponseEntity.badRequest().body("Já existe uma tabela de informaçõe com esse cliente, tente novamente! ");
        } else if (partner.isPresent()) {
            return ResponseEntity.badRequest().body("Já existe uma tabela de informações com esse sócio, tente novamente! ");

        } else{
            ClientInformation clientInformation = new ClientInformation();
            clientInformation.setClient(data.client());
            clientInformation.setCompanyActivity(data.companyActivity());
            clientInformation.setEcacDate(data.ecacDate());
            clientInformation.setEcacDate(data.fgtsDate());
            clientInformation.setCityHallNotes(data.cityHallNotes());
            clientInformation.setMunicipalStateRegistration(data.municipalStateRegistration());
            clientInformation.setNfseAccess(data.nfseAccess());
            clientInformation.setResponsiblePartner(data.responsiblePartner());
            clientInformation.setSimpleAccessCode(data.simpleAccessCode());
            clientInformation.setTaxRegime(data.taxRegime());
            repository.save(clientInformation);
        }
        return ResponseEntity.ok("Tabela de informações do cliente criada com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateClientInformation(ClientInformationRequestDTO data){
        Optional<ClientInformation> clientInformationOptional = repository.findById(data.id());

        if (clientInformationOptional.isPresent()){
            ClientInformation clientInformation = new ClientInformation();
            clientInformation.setClient(data.client());
            clientInformation.setCompanyActivity(data.companyActivity());
            clientInformation.setEcacDate(data.ecacDate());
            clientInformation.setEcacDate(data.fgtsDate());
            clientInformation.setCityHallNotes(data.cityHallNotes());
            clientInformation.setMunicipalStateRegistration(data.municipalStateRegistration());
            clientInformation.setNfseAccess(data.nfseAccess());
            clientInformation.setResponsiblePartner(data.responsiblePartner());
            clientInformation.setSimpleAccessCode(data.simpleAccessCode());
            clientInformation.setTaxRegime(data.taxRegime());
            repository.save(clientInformation);
            return ResponseEntity.ok("Tabela de informações do cliente atualizada com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteClientInformation(@PathVariable Long id){
        Optional<ClientInformation> clientInformation = repository.findById(id);
        if (clientInformation.isPresent()){
            repository.deleteById(clientInformation.get().getId());
            return ResponseEntity.ok("Tabela de informações do cliente excluída com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
