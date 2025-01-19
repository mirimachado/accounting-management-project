package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.LibraryDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LibraryDocumentRepository extends JpaRepository<LibraryDocument, Long> {
    Optional<LibraryDocument> findById(Long id);
    Optional<LibraryDocument> findByFolderName(String folderName);

}
