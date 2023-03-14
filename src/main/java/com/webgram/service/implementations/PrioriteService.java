package com.webgram.service.implementations;

import com.webgram.entity.Priorite;
import com.webgram.repository.PrioriteRepository;
import com.webgram.service.interfaces.IPriorite;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrioriteService implements IPriorite
{
    private final PrioriteRepository prioriteRepository;

    @Override
    public Priorite addPriorite(Priorite priorite)
    {
        return prioriteRepository.save(priorite);
    }

    @Override
    public Priorite updatePriorite(Long id, Priorite priorite)
    {
        Priorite isExisted = getOnePriorite(id);

        isExisted.setLibelle(priorite.getLibelle());
        isExisted.setDuree(priorite.getDuree());

        return prioriteRepository.save(isExisted);
    }

    @Override
    public void deleteNature(Long id)
    {
        Priorite isExisted = getOnePriorite(id);

        prioriteRepository.delete(isExisted);
    }

    @Override
    public List<Priorite> getAllPriorite()
    {
        return prioriteRepository.findAll();
    }

    @Override
    public Priorite getOnePriorite(Long id)
    {
        return prioriteRepository.findById(id).orElseThrow(() -> new RuntimeException("Priority doesn't exist !"));
    }
}
