package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "address")
@Table(name = "address")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String zipCode;
    @NotEmpty
    private String street;
    @NotEmpty
    private String complement;
    @NotEmpty
    private String locality;
    @NotEmpty
    private String neighborhood;
    @NotEmpty
    private String federativeUnit;
    @NotEmpty
    private String state;
    @NotEmpty
    private String region;

    public Address(){

    }

    public Address(String zipCode, String street, String locality, String complement, String neighborhood, String federativeUnit, String state, String region) {
        this.zipCode = zipCode;
        this.street = street;
        this.locality = locality;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.federativeUnit = federativeUnit;
        this.state = state;
        this.region = region;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getFederativeUnit() {
        return federativeUnit;
    }

    public void setFederativeUnit(String federativeUnit) {
        this.federativeUnit = federativeUnit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
