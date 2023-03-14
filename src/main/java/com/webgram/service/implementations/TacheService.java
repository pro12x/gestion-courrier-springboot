package com.webgram.service.implementations;

import com.webgram.entity.Tache;
import com.webgram.repository.TacheRepository;
import com.webgram.service.interfaces.ITache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TacheService implements ITache
{
    private final TacheRepository tacheRepository;

    @Override
    public Tache addTache(Tache tache)
    {
        return tacheRepository.save(tache);
    }

    @Override
    public Tache updateTache(Long id, Tache tache)
    {
        Tache isExisted = getOneTache(id);

        isExisted.setLibelle(tache.getLibelle());

        return tacheRepository.save(isExisted);
    }

    @Override
    public void deleteTache(Long id)
    {
        Tache isExisted = getOneTache(id);

        /*if(!isExisted.isArchived())
        {
            tacheRepository.delete(isExisted);
        }
        else
        {
            isExisted.setArchived(true);
            tacheRepository.save(isExisted);
        }*/
    }

    @Override
    public List<Tache> getAllTache()
    {
        return tacheRepository.getAllTache();
    }

    @Override
    public List<Tache> getAllTacheArchived()
    {
        return tacheRepository.getAllTacheArchived();
    }

    @Override
    public Tache getOneTache(Long id)
    {
        return tacheRepository.findById(id).orElseThrow(() -> new RuntimeException("Task doesn't exist !"));
    }
}
