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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate generationEndDate;
    @NotNull
    private Boolean pendingFlag;
    @NotNull
    private Boolean previousFlag;
    @NotNull
    private LocalDate taskCreationDate;

    public Task(){

    }

    public Task(User user, String taskName, RecurringType recurringType, String additionalInformation, LocalDate expirationDate, Boolean generatesFine, Integer taskNumber, String taskStatus, Boolean automaticallyGenerating, LocalDate generationEndDate, Boolean pendingFlag, Boolean previousFlag, LocalDate taskCreationDate) {
        this.user = user;
        this.taskName = taskName;
        this.recurringType = recurringType;
        this.additionalInformation = additionalInformation;
        this.expirationDate = expirationDate;
        this.generatesFine = generatesFine;
        this.taskNumber = taskNumber;
        this.taskStatus = taskStatus;
        this.automaticallyGenerating = automaticallyGenerating;
        this.generationEndDate = generationEndDate;
        this.pendingFlag = pendingFlag;
        this.previousFlag = previousFlag;
        this.taskCreationDate = taskCreationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getGeneratesFine() {
        return generatesFine;
    }

    public void setGeneratesFine(Boolean generatesFine) {
        this.generatesFine = generatesFine;
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

    public LocalDate getGenerationEndDate() {
        return generationEndDate;
    }

    public void setGenerationEndDate(LocalDate generationEndDate) {
        this.generationEndDate = generationEndDate;
    }

    public Boolean getPendingFlag() {
        return pendingFlag;
    }

    public void setPendingFlag(Boolean pendingFlag) {
        this.pendingFlag = pendingFlag;
    }

    public Boolean getPreviousFlag() {
        return previousFlag;
    }

    public void setPreviousFlag(Boolean previousFlag) {
        this.previousFlag = previousFlag;
    }

    public LocalDate getTaskCreationDate() {
        return taskCreationDate;
    }

    public void setTaskCreationDate(LocalDate taskCreationDate) {
        this.taskCreationDate = taskCreationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
