package br.com.main.project.contalogic.model.controllers;


import br.com.main.project.contalogic.model.dtos.requests.UserRequestDTO;
import br.com.main.project.contalogic.model.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/create")
    public ResponseEntity createUsers(@RequestBody @Valid UserRequestDTO data){
        return userService.createUser(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateUsers(@RequestBody @Valid UserRequestDTO data){
        return userService.updateUser(data);

    }

    @DeleteMapping("/delete")
    public ResponseEntity InactivateUsers(@RequestBody @Valid UserRequestDTO data){
        return userService.InactivateUser(data);

    }


}
