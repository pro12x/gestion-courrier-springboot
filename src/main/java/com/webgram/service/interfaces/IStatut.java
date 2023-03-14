package com.webgram.service.interfaces;

import com.webgram.entity.Statut;

import java.util.List;

public interface IStatut
{
    Statut addStatut(Statut statut);
    Statut updateStatut(Long id, Statut statut);
    void deleteStatut(Long id);
    List<Statut> getAllStatut();
    Statut getOneStatut(Long id);
}
