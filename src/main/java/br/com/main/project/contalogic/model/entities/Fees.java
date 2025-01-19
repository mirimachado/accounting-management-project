package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import br.com.main.project.contalogic.model.enums.PaymentMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "fees")
@Table(name = "fees")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Fees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private Double valueFees;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", unique = true)
    private Client client;
    @NotEmpty
    private String service;
    @NotEmpty
    private String situation;
    @NotEmpty
    private String additionalInformation;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @NotNull
    private LocalDate competence;

    public Fees(){

    }

    public Fees(Double valueFees, Client client, String service, String situation, String additionalInformation, PaymentMethod paymentMethod, LocalDate competence) {
        this.valueFees = valueFees;
        this.client = client;
        this.service = service;
        this.situation = situation;
        this.additionalInformation = additionalInformation;
        this.paymentMethod = paymentMethod;
        this.competence = competence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValueFees() {
        return valueFees;
    }

    public void setValueFees(Double valueFees) {
        this.valueFees = valueFees;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getCompetence() {
        return competence;
    }

    public void setCompetence(LocalDate competence) {
        this.competence = competence;
    }
}
