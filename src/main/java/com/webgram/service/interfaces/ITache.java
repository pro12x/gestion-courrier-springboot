package com.webgram.service.interfaces;

import com.webgram.entity.Tache;

import java.util.List;

public interface ITache
{
    Tache addTache(Tache tache);
    Tache updateTache(Long id, Tache tache);
    void deleteTache(Long id);
    List<Tache> getAllTache();
    List<Tache> getAllTacheArchived();
    Tache getOneTache(Long id);
}
