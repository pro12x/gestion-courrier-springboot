package com.webgram.service.implementations;

import com.webgram.entity.CourrierEntrant;
import com.webgram.repository.CourrierEntrantRepository;
import com.webgram.service.interfaces.ICourrierEntrant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourrierEntrantService implements ICourrierEntrant
{
    private final CourrierEntrantRepository entrantRepository;

    @Override
    public CourrierEntrant addCourrierEntrant(CourrierEntrant courrierEntrant)
    {
        return entrantRepository.save(courrierEntrant);
    }

    @Override
    public CourrierEntrant updateCourrierEntrant(Long id, CourrierEntrant courrierEntrant)
    {
        CourrierEntrant isExisted = getOneCourrierEntrant(id);

        isExisted.setCode(courrierEntrant.getCode());
        isExisted.setReference(courrierEntrant.getReference());
        isExisted.setObjet(courrierEntrant.getObjet());
        isExisted.setReponse(courrierEntrant.getReponse());
        isExisted.setType(courrierEntrant.getType());
        isExisted.setNature(courrierEntrant.getNature());
        isExisted.setStatut(courrierEntrant.getStatut());
        isExisted.setPriorite(courrierEntrant.getPriorite());
        isExisted.setResume(courrierEntrant.getResume());
        isExisted.setComment(courrierEntrant.getComment());
        isExisted.setExpediteur(courrierEntrant.getExpediteur());
        isExisted.setDestinataire(courrierEntrant.getDestinataire());
        isExisted.setDocuments(courrierEntrant.getDocuments());
        isExisted.setDateRedaction(courrierEntrant.getDateRedaction());
        isExisted.setDateReception(courrierEntrant.getDateReception());
        isExisted.setDateEcheante(courrierEntrant.getDateEcheante());

        return entrantRepository.save(isExisted);
    }

    @Override
    public void deleteCourrierEntrant(Long id)
    {
        CourrierEntrant isExisted = getOneCourrierEntrant(id);

        entrantRepository.delete(isExisted);
    }

    @Override
    public List<CourrierEntrant> getAllCourrierEntrant()
    {
        return entrantRepository.findAll();
    }

    @Override
    public CourrierEntrant getOneCourrierEntrant(Long id)
    {
        return entrantRepository.findById(id).orElseThrow(() -> new RuntimeException("Incoming mail doesn't exist !"));
    }
}
