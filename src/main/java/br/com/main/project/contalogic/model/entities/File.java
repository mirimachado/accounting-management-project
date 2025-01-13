package br.com.main.project.contalogic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import br.com.main.project.contalogic.model.enums.ExtensionType;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "file")
@Table(name = "file")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    public File(String fileSize, ExtensionType extensionType, String fileName) {
        this.fileSize = fileSize;
        this.extensionType = extensionType;
        this.fileName = fileName;
    }
}
