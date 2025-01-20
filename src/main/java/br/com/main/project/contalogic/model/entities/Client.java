package br.com.main.project.contalogic.model.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "client")
@Table(name = "client")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "cnpj_id", referencedColumnName = "id", unique = true)
    private Cnpj cnpj;
    @NotEmpty
    private String fantasyName;
    @NotEmpty
    private String corporateReason;
    @NotEmpty
    private String telephone;
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private Address address;
    @NotEmpty
    private String email;
    @NotNull
    private LocalDate entryDate;


    public Client(){

    }

    public Client(Cnpj cnpj, String fantasyName, String corporateReason, String telephone, Address address, String email, LocalDate entryDate) {
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
        this.corporateReason = corporateReason;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.entryDate = entryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cnpj getCnpj() {
        return cnpj;
    }

    public void setCnpj(Cnpj cnpj) {
        this.cnpj = cnpj;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCorporateReason() {
        return corporateReason;
    }

    public void setCorporateReason(String corporateReason) {
        this.corporateReason = corporateReason;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
}
