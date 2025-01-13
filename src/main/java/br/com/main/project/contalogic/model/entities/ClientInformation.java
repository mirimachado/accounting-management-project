package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "client_information")
@Table(name = "client_information")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class ClientInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate fgtsDate;
    @NotNull
    private LocalDate ecacDate;
    @NotEmpty
    private String simpleAccessCode;
    @NotEmpty
    private String nfseAccess;
    @NotEmpty
    private String companyActivity;
    @NotEmpty
    private String municipalStateRegistration;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "responsible_partner", referencedColumnName = "id", unique = true)
    private Partner responsiblePartner;
    @NotEmpty
    private String taxRegime;
    @NotEmpty
    private String cityHallNotes;
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Client client;

    public ClientInformation(LocalDate fgtsDate, LocalDate ecacDate, String simpleAccessCode, String nfseAccess, String companyActivity, String municipalStateRegistration, Partner responsiblePartner, String taxRegime, String cityHallNotes, Client client) {
        this.fgtsDate = fgtsDate;
        this.ecacDate = ecacDate;
        this.simpleAccessCode = simpleAccessCode;
        this.nfseAccess = nfseAccess;
        this.companyActivity = companyActivity;
        this.municipalStateRegistration = municipalStateRegistration;
        this.responsiblePartner = responsiblePartner;
        this.taxRegime = taxRegime;
        this.cityHallNotes = cityHallNotes;
        this.client = client;
    }
}
