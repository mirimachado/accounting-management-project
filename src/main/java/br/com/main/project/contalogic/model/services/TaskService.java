package br.com.main.project.contalogic.model.services;

import br.com.main.project.contalogic.model.dtos.requests.TaskRequestDTO;
import br.com.main.project.contalogic.model.entities.Task;
import br.com.main.project.contalogic.model.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public ResponseEntity<List<Task>> getTasks(){
        List<Task> tasks = repository.findAll();
        return ResponseEntity.ok(tasks);

    }

    @Transactional
    public ResponseEntity<String> createTask(TaskRequestDTO data){
        Optional<Task> taskName = repository.findByTaskName(data.taskName());
        Optional<Task> taskNumber = repository.findByTaskNumber(data.taskNumber());
        if (taskName.isPresent()){
            return ResponseEntity.badRequest().body("Já existe uma tarefa com esse nome, tente novamente! ");
        }
        else if (taskNumber.isPresent()){
            return ResponseEntity.badRequest().body("Já existe uma tarefa com esse número, tente novamente! ");
        }
        else{
           Task task = new Task();

           task.setTaskName(data.taskName());
           task.setTaskNumber(data.taskNumber());
           task.setTaskStatus(data.taskStatus());
           task.setUser(data.user());
           task.setAdditionalInformation(data.additionalInformation());
           task.setAutomaticallyGenerating(data.automaticallyGenerating());
           task.setExpirationDate(data.expirationDate());
           task.setGeneratesFine(data.generatesFine());
           task.setRecurringType(data.recurringType());
           repository.save(task);

        }
        return ResponseEntity.ok("Tarefa criada com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateTask(TaskRequestDTO data){
        Optional<Task> taskOptional = repository.findById(data.id());
        if (taskOptional.isPresent()){
            Task task = new Task();
            task.setTaskName(data.taskName());
            task.setTaskNumber(data.taskNumber());
            task.setTaskStatus(data.taskStatus());
            task.setUser(data.user());
            task.setAdditionalInformation(data.additionalInformation());
            task.setAutomaticallyGenerating(data.automaticallyGenerating());
            task.setExpirationDate(data.expirationDate());
            task.setGeneratesFine(data.generatesFine());
            task.setRecurringType(data.recurringType());
            repository.save(task);
            return ResponseEntity.ok("Tarefa atualizada com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()){
            repository.deleteById(task.get().getId());
            return ResponseEntity.ok("Tarefa excluída com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
