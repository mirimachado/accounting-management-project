package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import br.com.main.project.contalogic.model.enums.UserRole;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "users")
@Table(name = "users")
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

    private Boolean active = true;
//    @NotEmpty
    @Column(unique = true)
    private String token;

    public User(){

    }

    public User(String token,
                String password,
                String email,
                UserRole role,
                String name) {

        this.token = token;
        this.active = true;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
