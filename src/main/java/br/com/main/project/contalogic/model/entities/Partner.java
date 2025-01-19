package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "partner")
@Table(name = "partner")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String telephone;
    @NotEmpty
    private String email;
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private Address address;
    @NotEmpty
    @Size(max = 11)
    private String cpf;
    @NotEmpty
    private String vacancy;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Client client;

    public Partner(){

    }


    public Partner(String name, String telephone, String email, Address address, String cpf, String vacancy, Client client) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.cpf = cpf;
        this.vacancy = vacancy;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

