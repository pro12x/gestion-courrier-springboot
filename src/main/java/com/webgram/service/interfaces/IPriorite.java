package com.webgram.service.interfaces;

import com.webgram.entity.Priorite;

import java.util.List;

public interface IPriorite
{
    Priorite addPriorite(Priorite priorite);
    Priorite updatePriorite(Long id, Priorite priorite);
    void deleteNature(Long id);
    List<Priorite> getAllPriorite();
    Priorite getOnePriorite(Long id);
}
