package br.com.main.project.contalogic.model.entities;

import br.com.main.project.contalogic.model.enums.RecurringType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "task")
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;
    @NotEmpty
    private String taskName;
    @NotEmpty
    private String additionalInformation;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private RecurringType recurringType;
    @NotNull
    private LocalDate expirationDate;
    @NotEmpty
    private Boolean generatesFine;
    @NotEmpty
    private Integer taskNumber;
    @NotEmpty
    private String taskStatus;
    @NotEmpty
    private Boolean automaticallyGenerating;

    public Task(String taskName,
                User user, String additionalInformation,
                RecurringType recurringType,
                LocalDate expirationDate,
                Integer taskNumber,
                Boolean generatesFine,
                String taskStatus,
                Boolean automaticallyGenerating) {
        this.taskName = taskName;
        this.user = user;
        this.additionalInformation = additionalInformation;
        this.recurringType = recurringType;
        this.expirationDate = expirationDate;
        this.taskNumber = taskNumber;
        this.generatesFine = generatesFine;
        this.taskStatus = taskStatus;
        this.automaticallyGenerating = automaticallyGenerating;
    }
}
