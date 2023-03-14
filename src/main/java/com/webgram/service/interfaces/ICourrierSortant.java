package com.webgram.service.interfaces;

import com.webgram.entity.CourrierSortant;

import java.util.List;

public interface ICourrierSortant
{
    CourrierSortant addCourrierSortant(CourrierSortant courrierSortant);
    CourrierSortant updateCourrierSortantt(Long id, CourrierSortant courrierSortant);
    void deleteCourrierSortant(Long id);
    List<CourrierSortant> getAllCourrierSortant();
    CourrierSortant getOneCourrierSortant(Long id);
}
