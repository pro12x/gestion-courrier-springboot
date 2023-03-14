package com.webgram.repository;

import com.webgram.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Services, Long>
{
    //@Query("select serv from Service serv where serv.isDeleted = false")
    //List<Service> getAllService();
}