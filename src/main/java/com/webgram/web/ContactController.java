package com.webgram.web;

import com.webgram.entity.Contact;
import com.webgram.service.implementations.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/webgram/v1")
public class ContactController
{
    private final ContactService contactService;

    @PostMapping("/contact/add")
    public ResponseEntity<Contact> add(@RequestBody Contact contact)
    {
        Contact dest = contactService.addContact(contact);

        return ResponseEntity.status(HttpStatus.CREATED).body(dest);
    }

    @PutMapping("/contact/update/{id}")
    public ResponseEntity<Contact> update(@RequestBody Contact contact, @PathVariable Long id)
    {
        Contact dest = contactService.updateContact(id, contact);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dest);
    }

    @DeleteMapping("/contact/delete/{id}")
    public ResponseEntity<Contact> delete(@PathVariable Long id)
    {
        contactService.deleteContact(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/contact/list")
    public ResponseEntity<List<Contact>> list()
    {
        return ResponseEntity.ok(contactService.getAllContact());
    }

    @GetMapping("/contact/infos/{id}")
    public ResponseEntity<Contact> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(contactService.getOneContact(id));
    }
}
