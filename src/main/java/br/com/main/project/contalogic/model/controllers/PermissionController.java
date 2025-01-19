package br.com.main.project.contalogic.model.controllers;


import br.com.main.project.contalogic.model.dtos.requests.PermissionRequestDTO;
import br.com.main.project.contalogic.model.services.PermissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @GetMapping
    public ResponseEntity getPermissions(){
        return permissionService.getPermissions();
    }

    @PostMapping("/create")
    public ResponseEntity createPermission(@RequestBody @Valid PermissionRequestDTO data){
        return permissionService.createPermission(data);

    }

    @PutMapping("/update")
    public ResponseEntity updatePermission(@RequestBody @Valid PermissionRequestDTO data){
        return permissionService.updatePermission(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePermission(@PathVariable Long id){
        return permissionService.deletePermission(id);

    }
}
