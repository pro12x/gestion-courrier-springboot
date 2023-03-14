package com.webgram.service.implementations;

import com.webgram.entity.Contact;
import com.webgram.repository.ContactRepository;
import com.webgram.service.interfaces.IContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService implements IContact
{
    private final ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact)
    {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact contact)
    {
        Contact isExisted = getOneContact(id);

        isExisted.setPrenom(contact.getPrenom());
        isExisted.setNom(contact.getNom());
        isExisted.setType(contact.getType());
        isExisted.setCivilite(contact.getCivilite());
        isExisted.setFonction(contact.getFonction());
        isExisted.setPostal(contact.getPostal());
        isExisted.setVille(contact.getVille());
        isExisted.setAdresse(contact.getAdresse());
        isExisted.setEmail(contact.getEmail());
        isExisted.setTelephone(contact.getTelephone());
        isExisted.setService(contact.getService());

        return contactRepository.save(isExisted);
    }

    @Override
    public void deleteContact(Long id)
    {
        Contact isExisted = getOneContact(id);

        contactRepository.delete(isExisted);
    }

    @Override
    public List<Contact> getAllContact()
    {
        return contactRepository.findAll();
    }

    @Override
    public Contact getOneContact(Long id)
    {
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact doesn't exist !"));
    }
}
