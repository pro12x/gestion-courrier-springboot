package com.webgram.repository;

import com.webgram.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long>
{
    //@Query("select dept from Departement dept where dept.isDeleted = false")
    //List<Departement> getAllDepartement();
}