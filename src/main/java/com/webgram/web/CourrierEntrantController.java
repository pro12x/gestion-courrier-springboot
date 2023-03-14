package com.webgram.web;

import com.webgram.entity.CourrierEntrant;
import com.webgram.service.implementations.CourrierEntrantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class CourrierEntrantController
{
    private final CourrierEntrantService entrantService;

    @PostMapping("/entrant/add")
    public ResponseEntity<CourrierEntrant> add(@RequestBody CourrierEntrant courrierEntrant)
    {
        CourrierEntrant sortant = entrantService.addCourrierEntrant(courrierEntrant);

        return ResponseEntity.status(HttpStatus.CREATED).body(sortant);
    }

    @PutMapping("/entrant/update/{id}")
    public ResponseEntity<CourrierEntrant> update(@RequestBody CourrierEntrant courrierEntrant, @PathVariable Long id)
    {
        CourrierEntrant sortant = entrantService.updateCourrierEntrant(id, courrierEntrant);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sortant);
    }

    @DeleteMapping("/entrant/delete/{id}")
    public ResponseEntity<CourrierEntrant> delete(@PathVariable Long id)
    {
        entrantService.deleteCourrierEntrant(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/entrant/list")
    public ResponseEntity<List<CourrierEntrant>> list()
    {
        return ResponseEntity.ok(entrantService.getAllCourrierEntrant());
    }

    @GetMapping("/entrant/infos/{id}")
    public ResponseEntity<CourrierEntrant> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(entrantService.getOneCourrierEntrant(id));
    }
}
