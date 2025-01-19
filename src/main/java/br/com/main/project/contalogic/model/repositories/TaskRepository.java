package br.com.main.project.contalogic.model.repositories;
import br.com.main.project.contalogic.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
    Optional<Task> findByTaskName(String taskName);
    Optional<Task> findByTaskNumber(Integer taskNumber);
}
