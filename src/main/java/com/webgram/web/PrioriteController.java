package com.webgram.web;

import com.webgram.entity.Priorite;
import com.webgram.service.implementations.PrioriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class PrioriteController
{
    private final PrioriteService prioriteService;

    @PostMapping("/priorite/add")
    public ResponseEntity<Priorite> add(@RequestBody Priorite priorite)
    {
        Priorite prior = prioriteService.addPriorite(priorite);

        return ResponseEntity.status(HttpStatus.CREATED).body(prior);
    }

    @PutMapping("/priorite/update/{id}")
    public ResponseEntity<Priorite> update(@RequestBody Priorite priorite, @PathVariable Long id)
    {
        Priorite prior = prioriteService.updatePriorite(id, priorite);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(prior);
    }

    @DeleteMapping("/priorite/delete/{id}")
    public ResponseEntity<Priorite> delete(@PathVariable Long id)
    {
        prioriteService.deleteNature(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/priorite/list")
    public ResponseEntity<List<Priorite>> list()
    {
        return ResponseEntity.ok(prioriteService.getAllPriorite());
    }

    @GetMapping("/priorite/infos/{id}")
    public ResponseEntity<Priorite> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(prioriteService.getOnePriorite(id));
    }
}
