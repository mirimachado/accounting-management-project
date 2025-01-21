package br.com.main.project.contalogic.complementarymodules.services;

import br.com.main.project.contalogic.model.entities.Task;
import br.com.main.project.contalogic.model.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;


@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Autowired
    private TaskRepository repository;

    private final Logger logger = LoggerFactory.getLogger(SchedulingConfig.class);

    @Scheduled(cron = "@monthly")
    public void activateAutomaticTasks() {
        try {
           List<Task> tasksEntities = repository.findTasksWithPendingOrCompletedStatusAndActiveGeneration();
           for (Task entitie : tasksEntities){
                   Task newTask = new Task();
                   newTask.setTaskName(entitie.getTaskName());
                   newTask.setTaskNumber(entitie.getTaskNumber());
                   newTask.setTaskStatus("PENDENTE");
                   newTask.setUser(entitie.getUser());
                   newTask.setAdditionalInformation(entitie.getAdditionalInformation());
                   newTask.setAutomaticallyGenerating(false);
                   newTask.setExpirationDate(entitie.getExpirationDate().plusMonths(1));
                   newTask.setGeneratesFine(entitie.getGeneratesFine());
                   newTask.setRecurringType(entitie.getRecurringType());
                   newTask.setGenerationEndDate(null);
                   newTask.setPendingFlag(entitie.getPendingFlag());
                   newTask.setPreviousFlag(entitie.getPreviousFlag());
                   newTask.setTaskCreationDate(LocalDate.now());
                   repository.save(newTask);
           }
           tasksEntities.clear();
        }catch (Exception e){
            System.out.println("Ocorreu algum emprevisto na consulta.");
        }
        logger.info("Executando tarefa agendada para gerar tasks mensais");
    }
}
