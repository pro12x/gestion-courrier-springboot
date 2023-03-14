package com.webgram.service.interfaces;

import com.webgram.entity.Contact;

import java.util.List;

public interface IContact
{
    Contact addContact(Contact contact);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);
    List<Contact> getAllContact();
    Contact getOneContact(Long id);
}
