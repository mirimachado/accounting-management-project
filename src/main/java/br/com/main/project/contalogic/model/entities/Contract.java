package br.com.main.project.contalogic.model.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "contract")
@Table(name = "contract")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "contract_management_id", referencedColumnName = "id", unique = true)
    private ContractManagement contractManagement;
    @NotEmpty
    @OneToMany
    @JoinColumn(name = "file_id", referencedColumnName = "id", unique = true)
    private File file;

    public Contract(String contractTitle, Integer contractNumber, File file, ContractManagement contractManagement) {
        this.contractTitle = contractTitle;
        this.contractNumber = contractNumber;
        this.file = file;
        this.contractManagement = contractManagement;
    }
}
