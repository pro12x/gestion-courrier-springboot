package com.webgram.web;

import com.webgram.entity.CourrierSortant;
import com.webgram.service.implementations.CourrierSortantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class CourrierSortantController
{
    private final CourrierSortantService sortantService;

    @PostMapping("/sortant/add")
    public ResponseEntity<CourrierSortant> add(@RequestBody CourrierSortant courrierSortant)
    {
        CourrierSortant sortant = sortantService.addCourrierSortant(courrierSortant);

        return ResponseEntity.status(HttpStatus.CREATED).body(sortant);
    }

    @PutMapping("/sortant/update/{id}")
    public ResponseEntity<CourrierSortant> update(@RequestBody CourrierSortant courrierSortant, @PathVariable Long id)
    {
        CourrierSortant sortant = sortantService.updateCourrierSortantt(id, courrierSortant);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sortant);
    }

    @DeleteMapping("/sortant/delete/{id}")
    public ResponseEntity<CourrierSortant> delete(@PathVariable Long id)
    {
        sortantService.deleteCourrierSortant(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sortant/list")
    public ResponseEntity<List<CourrierSortant>> list()
    {
        return ResponseEntity.ok(sortantService.getAllCourrierSortant());
    }

    @GetMapping("/sortant/infos/{id}")
    public ResponseEntity<CourrierSortant> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(sortantService.getOneCourrierSortant(id));
    }
}
