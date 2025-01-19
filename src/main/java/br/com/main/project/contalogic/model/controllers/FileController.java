package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.FileRequestDTO;
import br.com.main.project.contalogic.model.services.FileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping
    public ResponseEntity getFiles(){
        return fileService.getFiles();
    }

    @PostMapping("/create")
    public ResponseEntity createFile(@RequestBody @Valid FileRequestDTO data){
        return fileService.createFile(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateFile(@RequestBody @Valid FileRequestDTO data){
        return fileService.updateFile(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFile(@PathVariable Long id){
        return fileService.deleteFile(id);

    }

}
