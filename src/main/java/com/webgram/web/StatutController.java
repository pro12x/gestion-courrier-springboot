package com.webgram.web;

import com.webgram.entity.Statut;
import com.webgram.service.implementations.StatutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class StatutController
{
    private final StatutService statutService;

    @PostMapping("/statut/add")
    public ResponseEntity<Statut> add(@RequestBody Statut statut)
    {
        Statut statut1 = statutService.addStatut(statut);

        return ResponseEntity.status(HttpStatus.CREATED).body(statut1);
    }

    @PutMapping("/statut/update/{id}")
    public ResponseEntity<Statut> update(@RequestBody Statut statut, @PathVariable Long id)
    {
        Statut statut1 = statutService.updateStatut(id, statut);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(statut1);
    }

    @DeleteMapping("/statut/delete/{id}")
    public ResponseEntity<Statut> delete(@PathVariable Long id)
    {
        statutService.deleteStatut(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/statut/list")
    public ResponseEntity<List<Statut>> list()
    {
        return ResponseEntity.ok(statutService.getAllStatut());
    }

    @GetMapping("/statut/infos/{id}")
    public ResponseEntity<Statut> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(statutService.getOneStatut(id));
    }
}
