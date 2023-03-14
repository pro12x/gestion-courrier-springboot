package com.webgram.service.implementations;

import com.webgram.entity.Services;
import com.webgram.repository.ServiceRepository;
import com.webgram.service.interfaces.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesImpl implements IService
{
    private final ServiceRepository serviceRepository;

    @Override
    public Services addService(Services service)
    {
        return serviceRepository.save(service);
    }

    @Override
    public Services updateService(Long id, Services service)
    {
        Services isExisted = getOneService(id);

        isExisted.setCode(service.getCode());
        isExisted.setLibelle(service.getLibelle());
        isExisted.setDepartement(service.getDepartement());

        return serviceRepository.save(isExisted);
    }

    @Override
    public void deleteService(Long id)
    {
        Services isExisted = getOneService(id);

        serviceRepository.delete(isExisted);
    }

    @Override
    public List<Services> getAllService()
    {
        //return serviceRepository.getAllService();
        return serviceRepository.findAll();
    }

    @Override
    public Services getOneService(Long id)
    {
        return serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service doesn't exist !"));
    }
}
