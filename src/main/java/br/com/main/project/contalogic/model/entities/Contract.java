package br.com.main.project.contalogic.model.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "contract")
@Table(name = "contract")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String contractTitle;
    @NotEmpty
    private Integer contractNumber;
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "contract_management_id", referencedColumnName = "id", unique = true)
    private ContractManagement contractManagement;
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id", unique = true)
    private File file;

    public Contract(){

    }

    public Contract(String contractTitle, Integer contractNumber, File file, ContractManagement contractManagement) {
        this.contractTitle = contractTitle;
        this.contractNumber = contractNumber;
        this.file = file;
        this.contractManagement = contractManagement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public ContractManagement getContractManagement() {
        return contractManagement;
    }

    public void setContractManagement(ContractManagement contractManagement) {
        this.contractManagement = contractManagement;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
