package br.com.main.project.contalogic.model.controllers;

import br.com.main.project.contalogic.model.dtos.requests.LibraryDocumentRequestDTO;
import br.com.main.project.contalogic.model.services.LibraryDocumentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library_documents")
public class LibraryDocumentController {

    @Autowired
    private LibraryDocumentService libraryDocumentService;

    @GetMapping
    public ResponseEntity getLibraryDocuments(){
        return libraryDocumentService.getLibraryDocuments();
    }

    @PostMapping("/create")
    public ResponseEntity createLibraryDocument(@RequestBody @Valid LibraryDocumentRequestDTO data){
        return libraryDocumentService.createLibraryDocument(data);

    }

    @PutMapping("/update")
    public ResponseEntity updateLibraryDocument(@RequestBody @Valid LibraryDocumentRequestDTO data){
        return libraryDocumentService.updateLibraryDocument(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLibraryDocument(@PathVariable Long id){
        return libraryDocumentService.deleteLibraryDocument(id);

    }
}
