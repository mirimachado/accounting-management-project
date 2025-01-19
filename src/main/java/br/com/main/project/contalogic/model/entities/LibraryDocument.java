package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "library_document")
@Table(name = "library_document")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class LibraryDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String documentType;
    @NotNull
    private LocalDate creationDate;
    @NotEmpty
    private String folderName;
    @NotEmpty
    @OneToMany(mappedBy = "libraryDocument")
   // @JoinColumn(name = "file_id", referencedColumnName = "id", unique = true)
    private List<File> file;

    public LibraryDocument(){

    }

    public LibraryDocument(List<File> file, String folderName, LocalDate creationDate, String documentType) {
        this.file = file;
        this.folderName = folderName;
        this.creationDate = creationDate;
        this.documentType = documentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
