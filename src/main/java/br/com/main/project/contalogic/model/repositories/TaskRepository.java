package br.com.main.project.contalogic.model.repositories;
import br.com.main.project.contalogic.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
    Optional<Task> findByTaskName(String taskName);

    @Query("SELECT t FROM task t WHERE (t.taskStatus = 'PENDENTE' OR t.taskStatus = 'CONCLUIDA') " +
            "AND t.automaticallyGenerating = true " +
            "AND t.generationEndDate > CURRENT_DATE")

    List<Task> findTasksWithPendingOrCompletedStatusAndActiveGeneration();

}
