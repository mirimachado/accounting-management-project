package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.Client;
import br.com.main.project.contalogic.model.entities.ClientInformation;
import br.com.main.project.contalogic.model.entities.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientInformationRepository extends JpaRepository<ClientInformation, Long> {
    Optional<ClientInformation> findById(Long id);
    Optional<ClientInformation> findByClient(Client client);
    Optional<ClientInformation> findByResponsiblePartner(Partner partner);

}
