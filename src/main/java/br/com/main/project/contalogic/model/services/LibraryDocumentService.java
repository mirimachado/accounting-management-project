package br.com.main.project.contalogic.model.services;

import br.com.main.project.contalogic.model.dtos.requests.LibraryDocumentRequestDTO;
import br.com.main.project.contalogic.model.entities.LibraryDocument;
import br.com.main.project.contalogic.model.repositories.LibraryDocumentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryDocumentService {

    @Autowired
    private LibraryDocumentRepository repository;


    public ResponseEntity<List<LibraryDocument>> getLibraryDocuments(){
        List<LibraryDocument> libraryDocuments = repository.findAll();
        return ResponseEntity.ok(libraryDocuments);

    }

    @Transactional
    public ResponseEntity<String> createLibraryDocument(LibraryDocumentRequestDTO data){
        Optional<LibraryDocument> folderName = repository.findByFolderName(data.folderName());
        if (folderName.isPresent()){
            return ResponseEntity.badRequest().body("Já existe uma biblioteca de documentos com esse nome, tente novamente! ");
        }
        else{
            LibraryDocument libraryDocument = new LibraryDocument();
            libraryDocument.setDocumentType(data.documentType());
            libraryDocument.setCreationDate(LocalDate.now());
            libraryDocument.setFile(data.file());
            libraryDocument.setFolderName(data.folderName());
            repository.save(libraryDocument);
        }
        return ResponseEntity.ok("Biblioteca de documentos criada com sucesso. ");
    }

    @Transactional
    public ResponseEntity<String> updateLibraryDocument(LibraryDocumentRequestDTO data){
        Optional<LibraryDocument> libraryDocumentOptional = repository.findById(data.id());
        if (libraryDocumentOptional.isPresent()){
            LibraryDocument libraryDocument = new LibraryDocument();
            libraryDocument.setDocumentType(data.documentType());
            libraryDocument.setCreationDate(LocalDate.now());
            libraryDocument.setFile(data.file());
            libraryDocument.setFolderName(data.folderName());
            repository.save(libraryDocument);
            return ResponseEntity.ok("Biblioteca de documentos atualizada com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<String> deleteLibraryDocument(@PathVariable Long id){
        Optional<LibraryDocument> libraryDocument = repository.findById(id);
        if (libraryDocument.isPresent()){
            repository.deleteById(libraryDocument.get().getId());
            return ResponseEntity.ok("Biblioteca de documentos excluída com sucesso. ");
        }
        return ResponseEntity.notFound().build();

    }

}
