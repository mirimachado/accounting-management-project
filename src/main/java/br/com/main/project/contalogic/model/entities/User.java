package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import br.com.main.project.contalogic.model.enums.UserRole;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private Boolean active = true;
//    @NotEmpty
    @Column(unique = true)
    private String token;

    public User(String token,
                Boolean active,
                String password,
                String email,
                UserRole role,
                String name) {

        this.token = token;
        this.active = active;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
    }
}
