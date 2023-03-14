package com.webgram.web;

import com.webgram.entity.Nature;
import com.webgram.service.implementations.NatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class NatureController
{
    private final NatureService natureService;

    @PostMapping("/nature/add")
    public ResponseEntity<Nature> add(@RequestBody Nature nature)
    {
        Nature nat = natureService.addNature(nature);

        return ResponseEntity.status(HttpStatus.CREATED).body(nat);
    }

    @PutMapping("/nature/update/{id}")
    public ResponseEntity<Nature> update(@RequestBody Nature nature, @PathVariable Long id)
    {
        Nature nat = natureService.updateNature(id, nature);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(nat);
    }

    @DeleteMapping("/nature/delete/{id}")
    public ResponseEntity<Nature> delete(@PathVariable Long id)
    {
        natureService.deleteNature(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nature/list")
    public ResponseEntity<List<Nature>> list()
    {
        return ResponseEntity.ok(natureService.getAllNature());
    }

    @GetMapping("/nature/infos/{id}")
    public ResponseEntity<Nature> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(natureService.getOneNature(id));
    }
}
