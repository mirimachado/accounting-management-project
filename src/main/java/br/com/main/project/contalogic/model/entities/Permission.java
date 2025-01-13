package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "permission")
@Table(name = "permission")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;
    @NotEmpty
    private String permissionName;
    @NotEmpty
    private String type;
    @NotEmpty
    private String description;
    @NotNull
    private LocalDate creationDate;


    public Permission(User user, String permissionName, String type, String description, LocalDate creationDate) {
        this.user = user;
        this.permissionName = permissionName;
        this.type = type;
        this.description = description;
        this.creationDate = creationDate;
    }
}
