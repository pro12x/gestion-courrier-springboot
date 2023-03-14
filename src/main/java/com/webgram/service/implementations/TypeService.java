package com.webgram.service.implementations;

import com.webgram.entity.Type;
import com.webgram.repository.TypeRepository;
import com.webgram.service.interfaces.IType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService implements IType
{
    private final TypeRepository typeRepository;

    @Override
    public Type addType(Type type)
    {
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Long id, Type type)
    {
        Type isExisted = getOneType(id);

        isExisted.setLibelle(type.getLibelle());

        return typeRepository.save(isExisted);
    }

    @Override
    public void deleteType(Long id)
    {
        Type isExisted = getOneType(id);

        typeRepository.delete(isExisted);
    }

    @Override
    public List<Type> getAllType()
    {
        return typeRepository.findAll();
    }

    @Override
    public Type getOneType(Long id)
    {
        return typeRepository.findById(id).orElseThrow(() -> new RuntimeException("Type doesn't exist !"));
    }
}
