package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "partner")
@Table(name = "partner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private String address;
    @NotEmpty
    private Integer cpf;
    @NotEmpty
    private String vacancy;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Client client;


    public Partner(String name, String telephone, String email, String address, Integer cpf, String vacancy, Client client) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.cpf = cpf;
        this.vacancy = vacancy;
        this.client = client;
    }
}

