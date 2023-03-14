package com.webgram.service.implementations;

import com.webgram.entity.Nature;
import com.webgram.repository.NatureRepository;
import com.webgram.service.interfaces.INature;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NatureService implements INature
{
    private final NatureRepository natureRepository;

    @Override
    public Nature addNature(Nature nature)
    {
        return natureRepository.save(nature);
    }

    @Override
    public Nature updateNature(Long id, Nature nature)
    {
        Nature isExisted = getOneNature(id);

        isExisted.setLibelle(nature.getLibelle());

        return natureRepository.save(isExisted);
    }

    @Override
    public void deleteNature(Long id)
    {
        Nature isExisted = getOneNature(id);

        natureRepository.delete(isExisted);
    }

    @Override
    public List<Nature> getAllNature()
    {
        return natureRepository.findAll();
    }

    @Override
    public Nature getOneNature(Long id)
    {
        return natureRepository.findById(id).orElseThrow(() -> new RuntimeException("Nature doesn't exist !"));
    }
}
