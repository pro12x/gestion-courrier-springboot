package com.webgram.web;

import com.webgram.entity.Document;
import com.webgram.service.implementations.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class DocumentController
{
    private final DocumentService documentService;

    @PostMapping("/document/add")
    public ResponseEntity<Document> add(@RequestBody Document document)
    {
        Document doc = documentService.addDocument(document);

        return ResponseEntity.status(HttpStatus.CREATED).body(doc);
    }

    @PutMapping("/document/update/{id}")
    public ResponseEntity<Document> update(@RequestBody Document document, @PathVariable Long id)
    {
        Document doc = documentService.updateDocument(id, document);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(doc);
    }

    @DeleteMapping("/document/delete/{id}")
    public ResponseEntity<Document> delete(@PathVariable Long id)
    {
        documentService.deleteDocument(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/document/list")
    public ResponseEntity<List<Document>> list()
    {
        return ResponseEntity.ok(documentService.getAllDocument());
    }

    @GetMapping("/document/infos/{id}")
    public ResponseEntity<Document> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(documentService.getOneDocument(id));
    }
}
