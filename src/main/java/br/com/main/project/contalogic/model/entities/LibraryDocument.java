package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity(name = "library_document")
@Table(name = "library_document")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @OneToMany
    @JoinColumn(name = "file_id", referencedColumnName = "id", unique = true)
    private File file;

    public LibraryDocument(File file, String folderName, LocalDate creationDate, String documentType) {
        this.file = file;
        this.folderName = folderName;
        this.creationDate = creationDate;
        this.documentType = documentType;
    }
}
