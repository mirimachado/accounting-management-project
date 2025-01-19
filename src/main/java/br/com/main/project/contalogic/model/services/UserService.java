package br.com.main.project.contalogic.model.services;

import br.com.main.project.contalogic.model.dtos.requests.UserRequestDTO;
import br.com.main.project.contalogic.model.entities.User;
import br.com.main.project.contalogic.model.enums.UserRole;
import br.com.main.project.contalogic.model.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public ResponseEntity getUsers(){
        List<User> users = repository.findAll();
        return ResponseEntity.ok(users);

    }

    @Transactional
    public ResponseEntity createUser(UserRequestDTO data){
        Optional<User> userName = repository.findByName(data.name());
        Optional<User> userEmail = repository.findByEmail(data.email());
        if (userName.isPresent()){
            return ResponseEntity.badRequest().body("Não foi possível criar o usuário pois esse nome já existe! ");
        }
        else if (userEmail.isPresent()){
            return ResponseEntity.badRequest().body("Não foi possível criar o usuário pois esse e-mail já existe! ");
        }
        else{
            User user = new User();
            user.setActive(true);
            user.setRole(UserRole.USER);
            user.setName(data.name());
            user.setEmail(data.email());
            user.setPassword(data.password());
            user.setToken(data.token());
            repository.save(user);
            return ResponseEntity.ok("Usuário criado com sucesso. ");
        }
    }

    @Transactional
    public ResponseEntity updateUser(UserRequestDTO data){
        Optional<User> user = repository.findById(data.id());
        if (user.isPresent()){
            User updateUser = user.get();
            updateUser.setActive(true);
            updateUser.setRole(UserRole.USER);
            updateUser.setName(data.name());
            updateUser.setEmail(data.email());
            updateUser.setPassword(data.password());
            updateUser.setToken(data.token());
            repository.save(updateUser);
            return ResponseEntity.ok("Usuário atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity InactivateUser(UserRequestDTO data){
        Optional<User> user = repository.findById(data.id());
        if (user.isPresent()){
            User userId = user.get();
            userId.setActive(false);
            repository.save(userId);
            return ResponseEntity.ok("Usuário inativado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }



}
