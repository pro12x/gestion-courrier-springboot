package com.webgram.web;

import com.webgram.entity.Tache;
import com.webgram.repository.TacheRepository;
import com.webgram.service.implementations.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class TacheController
{
    private final TacheService tacheService;
    private final TacheRepository tacheRepository;

    @PostMapping("/tache/add")
    public ResponseEntity<Tache> add(@RequestBody Tache tache)
    {
        Tache task = tacheService.addTache(tache);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping("/tache/update/{id}")
    public ResponseEntity<Tache> update(@RequestBody Tache tache, @PathVariable Long id)
    {
        Tache task = tacheService.updateTache(id, tache);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(task);
    }

    //Toutefois, ce bloc est à revoir en cas d'erreur
    @DeleteMapping("/tache/delete/{id}")
    public ResponseEntity<Tache> delete(@PathVariable Long id)
    {
        //Méthode 1 : Supprimer entièrement de la base de données
        /*tacheService.deleteTache(id);
        return ResponseEntity.noContent().build();*/

        //Méthode 2 : Ne pas supprimer mais, archiver pour en garder une copie
        Optional<Tache> isExisted = tacheRepository.findById(id);

        if (!isExisted.isPresent())
        {
            return ResponseEntity.noContent().build();
        }

        Tache tache = isExisted.get();

        tache.setArchived(true);
        tacheRepository.save(tache);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/tache/list")
    public ResponseEntity<List<Tache>> list()
    {
        return ResponseEntity.ok(tacheService.getAllTache());
    }

    @GetMapping("/tache/list-archive")
    public ResponseEntity<List<Tache>> listArchive()
    {
        return ResponseEntity.ok(tacheService.getAllTacheArchived());
    }

    @GetMapping("/tache/infos/{id}")
    public ResponseEntity<Tache> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(tacheService.getOneTache(id));
    }
}
