package com.webgram.service.interfaces;

import com.webgram.entity.Services;

import java.util.List;

public interface IService
{
    Services addService(Services service);
    Services updateService(Long id, Services service);
    void deleteService(Long id);
    List<Services> getAllService();
    Services getOneService(Long id);
}
