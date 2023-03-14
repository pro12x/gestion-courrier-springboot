package com.webgram.service.interfaces;

import com.webgram.entity.Departement;

import java.util.List;

public interface IDepartement
{
    Departement addDepartement(Departement departement);
    Departement updateDepartement(Long id, Departement departement);
    void deleteDepartement(Long id);
    List<Departement> getAllDepartement();
    Departement getOneDepartement(Long id);
}
