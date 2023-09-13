package com.dedalus.service;

import com.dedalus.entity.ManufacturerEntity;
import com.dedalus.persistence.ManufacturerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ManufacturerService {
    @Inject
    ManufacturerRepository manufacturerRepository;

    public ManufacturerEntity getOrCreateByName(String name) {
        if (name == null) {
            return null;
        }
        return manufacturerRepository
                .findByName(name)
                .orElseGet(
                        () -> manufacturerRepository.save(new ManufacturerEntity().setName(name))
                );
    }
}
