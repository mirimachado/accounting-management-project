package br.com.main.project.contalogic.model.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "client")
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String fantasyName;
    @NotEmpty
    private String corporateReason;
    @NotEmpty
    private String telephone;
    @NotEmpty
    private String address;
    @NotEmpty
    private String email;
    @NotNull
    private LocalDate entryDate;

    public Client(String fantasyName, String corporateReason, String telephone, String address, String email, LocalDate entryDate) {
        this.fantasyName = fantasyName;
        this.corporateReason = corporateReason;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.entryDate = entryDate;
    }
}
