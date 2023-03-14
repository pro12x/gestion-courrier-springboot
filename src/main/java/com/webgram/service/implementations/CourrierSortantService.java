package com.webgram.service.implementations;

import com.webgram.entity.CourrierSortant;
import com.webgram.repository.CourrierSortantRepository;
import com.webgram.service.interfaces.ICourrierSortant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourrierSortantService implements ICourrierSortant
{
    private final CourrierSortantRepository sortantRepository;

    @Override
    public CourrierSortant addCourrierSortant(CourrierSortant courrierSortant)
    {
        return sortantRepository.save(courrierSortant);
    }

    @Override
    public CourrierSortant updateCourrierSortantt(Long id, CourrierSortant courrierSortant)
    {
        CourrierSortant isExisted = getOneCourrierSortant(id);

        isExisted.setCode(courrierSortant.getCode());
        isExisted.setReference(courrierSortant.getReference());
        isExisted.setObjet(courrierSortant.getObjet());
        isExisted.setReponse(courrierSortant.getReponse());
        isExisted.setType(courrierSortant.getType());
        isExisted.setNature(courrierSortant.getNature());
        isExisted.setStatut(courrierSortant.getStatut());
        isExisted.setResume(courrierSortant.getResume());
        isExisted.setComment(courrierSortant.getComment());
        isExisted.setExpediteur(courrierSortant.getExpediteur());
        isExisted.setDestinataire(courrierSortant.getDestinataire());
        isExisted.setDocuments(courrierSortant.getDocuments());
        isExisted.setDateRedaction(courrierSortant.getDateRedaction());
        isExisted.setDateEcheante(courrierSortant.getDateEcheante());
        isExisted.setDateReelle(courrierSortant.getDateReelle());

        return sortantRepository.save(isExisted);
    }

    @Override
    public void deleteCourrierSortant(Long id)
    {
        CourrierSortant isExisted = getOneCourrierSortant(id);

        sortantRepository.delete(isExisted);
    }

    @Override
    public List<CourrierSortant> getAllCourrierSortant()
    {
        return sortantRepository.findAll();
    }

    @Override
    public CourrierSortant getOneCourrierSortant(Long id)
    {
        return sortantRepository.findById(id).orElseThrow(() -> new RuntimeException("Outgoing mail doesn't exist !"));
    }
}
