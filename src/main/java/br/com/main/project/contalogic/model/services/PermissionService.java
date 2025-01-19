package br.com.main.project.contalogic.model.services;


import br.com.main.project.contalogic.model.dtos.requests.PermissionRequestDTO;
import br.com.main.project.contalogic.model.entities.Permission;
import br.com.main.project.contalogic.model.repositories.PermissionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository repository;

    public ResponseEntity<List<Permission>> getPermissions(){
        List<Permission> permissions = repository.findAll();
        return ResponseEntity.ok(permissions);

    }

    @Transactional
    public ResponseEntity<String> createPermission(PermissionRequestDTO data){
        Optional<Permission> permissionName = repository.findByPermissionName(data.permissionName());
        Optional<Permission> description = repository.findByDescription(data.description());
        if (permissionName.isPresent()){
            return ResponseEntity.badRequest().body("Já existe uma permissão com esse nome, tente novamente! ");
        }
        else if (description.isPresent()){
            return ResponseEntity.badRequest().body("Já existe uma permissão com essa descrição, tente novamente! ");
        }
        else{
            Permission permission = new Permission();
            permission.setPermissionName(data.permissionName());
            permission.setUser(data.user());
            permission.setCreationDate(LocalDate.now());
            permission.setType(data.type());
            permission.setDescription(data.description());
            repository.save(permission);
        }
        return ResponseEntity.ok("Permissão criada com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updatePermission(PermissionRequestDTO data){
        Optional<Permission> permissionOptional = repository.findById(data.id());
        if (permissionOptional.isPresent()){
            Permission permission = new Permission();
            permission.setPermissionName(data.permissionName());
            permission.setUser(data.user());
            permission.setCreationDate(data.creationDate());
            permission.setType(data.type());
            permission.setDescription(data.description());
            repository.save(permission);
            return ResponseEntity.ok("Permissão atualizada com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deletePermission(@PathVariable Long id){
        Optional<Permission> permission = repository.findById(id);
        if (permission.isPresent()){
            repository.deleteById(permission.get().getId());
            return ResponseEntity.ok("Permissão excluída com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
