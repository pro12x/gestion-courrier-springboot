package com.webgram.service.implementations;

import com.webgram.entity.Statut;
import com.webgram.repository.StatutRepository;
import com.webgram.service.interfaces.IStatut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatutService implements IStatut
{
    private final StatutRepository statutRepository;

    @Override
    public Statut addStatut(Statut statut)
    {
        return statutRepository.save(statut);
    }

    @Override
    public Statut updateStatut(Long id, Statut statut)
    {
        Statut isExisted = getOneStatut(id);

        isExisted.setLibelle(statut.getLibelle());

        return statutRepository.save(isExisted);
    }

    @Override
    public void deleteStatut(Long id)
    {
        Statut isExisted = getOneStatut(id);

        statutRepository.delete(isExisted);
    }

    @Override
    public List<Statut> getAllStatut()
    {
        return statutRepository.findAll();
    }

    @Override
    public Statut getOneStatut(Long id)
    {
        return statutRepository.findById(id).orElseThrow(() -> new RuntimeException("Statut doesn't exist !"));
    }
}