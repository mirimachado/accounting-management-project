package br.com.main.project.contalogic.model.entities;

import br.com.main.project.contalogic.model.enums.RecurringType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "task")
@Table(name = "task")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;
    @NotEmpty
    private String taskName;
    @NotEmpty
    private String additionalInformation;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RecurringType recurringType;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    @NotNull
    private Boolean generatesFine;
    @NotNull
    private Integer taskNumber;
    @NotEmpty
    private String taskStatus;
    @NotNull
    private Boolean automaticallyGenerating;

    public Task(){

    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public RecurringType getRecurringType() {
        return recurringType;
    }

    public void setRecurringType(RecurringType recurringType) {
        this.recurringType = recurringType;
    }

    public Boolean getGeneratesFine() {
        return generatesFine;
    }

    public void setGeneratesFine(Boolean generatesFine) {
        this.generatesFine = generatesFine;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Boolean getAutomaticallyGenerating() {
        return automaticallyGenerating;
    }

    public void setAutomaticallyGenerating(Boolean automaticallyGenerating) {
        this.automaticallyGenerating = automaticallyGenerating;
    }
}
