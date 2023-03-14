package com.webgram.web;

import com.webgram.entity.Services;
import com.webgram.service.implementations.ServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class ServicesController
{
    private final ServicesImpl servicesImpl;

    @PostMapping("/service/add")
    public ResponseEntity<Services> add(@RequestBody Services services)
    {
        Services serv =  servicesImpl.addService(services);

        return ResponseEntity.status(HttpStatus.CREATED).body(serv);
    }

    @PutMapping("/service/update/{id}")
    public ResponseEntity<Services> update(@RequestBody Services service, @PathVariable Long id)
    {
        Services serv = servicesImpl.updateService(id, service);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serv);
    }

    @DeleteMapping("/service/delete/{id}")
    public ResponseEntity<Services> delete(@PathVariable Long id)
    {
        servicesImpl.deleteService(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/service/list")
    public ResponseEntity<List<Services>> list()
    {
        return ResponseEntity.ok(servicesImpl.getAllService());
    }

    @GetMapping("/service/infos/{id}")
    public ResponseEntity<Services> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(servicesImpl.getOneService(id));
    }
}
