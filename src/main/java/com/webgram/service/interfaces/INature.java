package com.webgram.service.interfaces;

import com.webgram.entity.Nature;

import java.util.List;

public interface INature
{
    Nature addNature(Nature nature);
    Nature updateNature(Long id, Nature nature);
    void deleteNature(Long id);
    List<Nature> getAllNature();
    Nature getOneNature(Long id);
}