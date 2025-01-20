package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "cnpj")
@Table(name = "cnpj")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Cnpj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(max = 14)
    private String cnpj;
    @NotEmpty
    private String descriptionCadastralStatus;
    @NotEmpty
    private LocalDate registrationStatusDate;
    @NotNull
    private LocalDate dateInitialActivity;
    @NotEmpty
    private String cnaeTaxDescription;

    public Cnpj(){

    }

    public Cnpj(String cnpj, String descriptionCadastralStatus, LocalDate registrationStatusDate, LocalDate dateInitialActivity, String cnaeTaxDescription) {
        this.cnpj = cnpj;
        this.descriptionCadastralStatus = descriptionCadastralStatus;
        this.registrationStatusDate = registrationStatusDate;
        this.dateInitialActivity = dateInitialActivity;
        this.cnaeTaxDescription = cnaeTaxDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionCadastralStatus() {
        return descriptionCadastralStatus;
    }

    public void setDescriptionCadastralStatus(String descriptionCadastralStatus) {
        this.descriptionCadastralStatus = descriptionCadastralStatus;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getRegistrationStatusDate() {
        return registrationStatusDate;
    }

    public void setRegistrationStatusDate(LocalDate registrationStatusDate) {
        this.registrationStatusDate = registrationStatusDate;
    }

    public LocalDate getDateInitialActivity() {
        return dateInitialActivity;
    }

    public void setDateInitialActivity(LocalDate dateInitialActivity) {
        this.dateInitialActivity = dateInitialActivity;
    }

    public String getCnaeTaxDescription() {
        return cnaeTaxDescription;
    }

    public void setCnaeTaxDescription(String cnaeTaxDescription) {
        this.cnaeTaxDescription = cnaeTaxDescription;
    }
}
