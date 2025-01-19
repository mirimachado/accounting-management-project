package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.TaskRequestDTO;
import br.com.main.project.contalogic.model.dtos.requests.UserRequestDTO;
import br.com.main.project.contalogic.model.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping
    public ResponseEntity getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("/create")
    public ResponseEntity createTask(@RequestBody @Valid TaskRequestDTO data){
        return taskService.createTask(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateTask(@RequestBody @Valid TaskRequestDTO data){
        return taskService.updateTask(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);

    }


}
