package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {
    Optional<File> findById(Long id);
    Optional<File> findByFileName(String fileName);
}
