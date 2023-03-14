package com.webgram.service.interfaces;

import com.webgram.entity.Type;

import java.util.List;

public interface IType
{
    Type addType(Type type);
    Type updateType(Long id, Type type);
    void deleteType(Long id);
    List<Type> getAllType();
    Type getOneType(Long id);
}
