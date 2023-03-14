package com.webgram.service.implementations;

import com.webgram.entity.Departement;
import com.webgram.repository.DepartementRepository;
import com.webgram.service.interfaces.IDepartement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementService implements IDepartement
{
    private final DepartementRepository departementRepository;

    @Override
    public Departement addDepartement(Departement departement)
    {
        return departementRepository.save(departement);
    }

    @Override
    public Departement updateDepartement(Long id, Departement departement)
    {
        Departement isExisted = getOneDepartement(id);

        isExisted.setCode(departement.getCode());
        isExisted.setLibelle(departement.getLibelle());

        return departementRepository.save(isExisted);
    }

    @Override
    public void deleteDepartement(Long id)
    {
        Departement isExisted = getOneDepartement(id);

        departementRepository.delete(isExisted);
    }

    @Override
    public List<Departement> getAllDepartement()
    {
        return departementRepository.findAll();
        //return departementRepository.getAllDepartement();
    }

    @Override
    public Departement getOneDepartement(Long id)
    {
        return departementRepository.findById(id).orElseThrow(() -> new RuntimeException("Department doesn't exist !"));
    }
}
