package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import br.com.main.project.contalogic.model.enums.ExtensionType;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "file")
@Table(name = "file")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String fileSize;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private ExtensionType extensionType;
    @NotEmpty
    private String fileName;
    @ManyToOne
    private LibraryDocument libraryDocument;

    public File(){

    }

    public File(String fileSize, ExtensionType extensionType, String fileName) {
        this.fileSize = fileSize;
        this.extensionType = extensionType;
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public ExtensionType getExtensionType() {
        return extensionType;
    }

    public void setExtensionType(ExtensionType extensionType) {
        this.extensionType = extensionType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
