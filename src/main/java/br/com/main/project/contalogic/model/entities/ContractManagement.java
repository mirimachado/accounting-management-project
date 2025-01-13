package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "contract_management")
@Table(name = "contract_management")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class ContractManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Client client;
    @NotEmpty
    private String service;
    @NotEmpty
    private String additionalInformation;
    @NotNull
    private LocalDate validity;

    public ContractManagement(Client client, String service, String additionalInformation, LocalDate validity) {
        this.client = client;
        this.service = service;
        this.additionalInformation = additionalInformation;
        this.validity = validity;
    }
}
