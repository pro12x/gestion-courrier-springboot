package com.webgram.repository;

import com.webgram.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>
{
    //
}
