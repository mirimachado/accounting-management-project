package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "client_information")
@Table(name = "client_information")
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

    public ClientInformation(){

    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFgtsDate() {
        return fgtsDate;
    }

    public void setFgtsDate(LocalDate fgtsDate) {
        this.fgtsDate = fgtsDate;
    }

    public LocalDate getEcacDate() {
        return ecacDate;
    }

    public void setEcacDate(LocalDate ecacDate) {
        this.ecacDate = ecacDate;
    }

    public String getSimpleAccessCode() {
        return simpleAccessCode;
    }

    public void setSimpleAccessCode(String simpleAccessCode) {
        this.simpleAccessCode = simpleAccessCode;
    }

    public String getNfseAccess() {
        return nfseAccess;
    }

    public void setNfseAccess(String nfseAccess) {
        this.nfseAccess = nfseAccess;
    }

    public String getCompanyActivity() {
        return companyActivity;
    }

    public void setCompanyActivity(String companyActivity) {
        this.companyActivity = companyActivity;
    }

    public String getMunicipalStateRegistration() {
        return municipalStateRegistration;
    }

    public void setMunicipalStateRegistration(String municipalStateRegistration) {
        this.municipalStateRegistration = municipalStateRegistration;
    }

    public Partner getResponsiblePartner() {
        return responsiblePartner;
    }

    public void setResponsiblePartner(Partner responsiblePartner) {
        this.responsiblePartner = responsiblePartner;
    }

    public String getTaxRegime() {
        return taxRegime;
    }

    public void setTaxRegime(String taxRegime) {
        this.taxRegime = taxRegime;
    }

    public String getCityHallNotes() {
        return cityHallNotes;
    }

    public void setCityHallNotes(String cityHallNotes) {
        this.cityHallNotes = cityHallNotes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
