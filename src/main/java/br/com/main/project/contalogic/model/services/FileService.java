package br.com.main.project.contalogic.model.services;


import br.com.main.project.contalogic.model.dtos.requests.FileRequestDTO;
import br.com.main.project.contalogic.model.entities.File;
import br.com.main.project.contalogic.model.repositories.FileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository repository;


    public ResponseEntity<List<File>> getFiles(){
        List<File> files = repository.findAll();
        return ResponseEntity.ok(files);

    }

    @Transactional
    public ResponseEntity<String> createFile(FileRequestDTO data){
        Optional<File> fileName = repository.findByFileName(data.fileName());

        if (fileName.isPresent()){
            return ResponseEntity.badRequest().body("Já existe um arquivo com esse nome, tente novamente! ");
        }
        else{
            File file = new File();
            file.setFileSize(data.fileSize());
            file.setFileName(data.fileName());
            file.setExtensionType(data.extensionType());
            repository.save(file);
        }
        return ResponseEntity.ok("Arquivo criado com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateFile(FileRequestDTO data){
        Optional<File> fileOptional = repository.findById(data.id());
        if (fileOptional.isPresent()){
            File file = new File();
            file.setFileSize(data.fileSize());
            file.setFileName(data.fileName());
            file.setExtensionType(data.extensionType());
            repository.save(file);
            return ResponseEntity.ok("Arquivo atualizado com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteFile(@PathVariable Long id){
        Optional<File> file = repository.findById(id);
        if (file.isPresent()){
            repository.deleteById(file.get().getId());
            return ResponseEntity.ok("Arquivo excluído com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
