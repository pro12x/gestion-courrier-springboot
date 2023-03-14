package com.webgram.service.interfaces;

import com.webgram.entity.CourrierEntrant;

import java.util.List;

public interface ICourrierEntrant
{
    CourrierEntrant addCourrierEntrant(CourrierEntrant courrierEntrant);
    CourrierEntrant updateCourrierEntrant(Long id, CourrierEntrant courrierEntrant);
    void deleteCourrierEntrant(Long id);
    List<CourrierEntrant> getAllCourrierEntrant();
    CourrierEntrant getOneCourrierEntrant(Long id);
}
