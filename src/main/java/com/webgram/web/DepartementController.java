package com.webgram.web;

import com.webgram.entity.Departement;
import com.webgram.service.implementations.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class DepartementController
{
    private final DepartementService departementService;

    @PostMapping("/departement/add")
    public ResponseEntity<Departement> add(@RequestBody Departement departement)
    {
        Departement dept = departementService.addDepartement(departement);

        return ResponseEntity.status(HttpStatus.CREATED).body(dept);
    }

    @PutMapping("/departement/update/{id}")
    public ResponseEntity<Departement> update(@RequestBody Departement departement, @PathVariable Long id)
    {
        Departement dept = departementService.updateDepartement(id, departement);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dept);
    }

    @DeleteMapping("/departement/delete/{id}")
    public ResponseEntity<Departement> delete(@PathVariable Long id)
    {
        departementService.deleteDepartement(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/departement/list")
    public ResponseEntity<List<Departement>> list()
    {
        return ResponseEntity.ok(departementService.getAllDepartement());
    }

    @GetMapping("/departement/infos/{id}")
    public ResponseEntity<Departement> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(departementService.getOneDepartement(id));
    }
}
