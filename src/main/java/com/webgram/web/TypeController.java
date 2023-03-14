package com.webgram.web;

import com.webgram.entity.Type;
import com.webgram.service.implementations.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class TypeController
{
    private final TypeService typeService;

    @PostMapping("/type/add")
    public ResponseEntity<Type> add(@RequestBody Type type)
    {
        Type typ = typeService.addType(type);

        return ResponseEntity.status(HttpStatus.CREATED).body(typ);
    }

    @PutMapping("/type/update/{id}")
    public ResponseEntity<Type> update(@RequestBody Type type, @PathVariable Long id)
    {
        Type typ = typeService.updateType(id, type);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(typ);
    }

    @DeleteMapping("/type/delete/{id}")
    public ResponseEntity<Type> delete(@PathVariable Long id)
    {
        typeService.deleteType(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type/list")
    public ResponseEntity<List<Type>> list()
    {
        return ResponseEntity.ok(typeService.getAllType());
    }

    @GetMapping("/type/infos/{id}")
    public ResponseEntity<Type> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(typeService.getOneType(id));
    }
}
