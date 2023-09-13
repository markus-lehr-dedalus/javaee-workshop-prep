package com.dedalus.persistence;

import com.dedalus.entity.CarEntity;
import com.dedalus.entity.ManufacturerEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ManufacturerRepository {
    @Inject
    EntityManager entityManager;

    public ManufacturerEntity save(ManufacturerEntity car) {
        entityManager.persist(car);
        return car;
    }

    public List<ManufacturerEntity> getAll() {
        return entityManager
                .createQuery("select manufacturer from MANUFACTURER manufacturer", ManufacturerEntity.class)
                .getResultList();
    }

    public Optional<ManufacturerEntity> findByName(String name) {
        return entityManager.createQuery("select manufacturer from MANUFACTURER manufacturer", ManufacturerEntity.class)
                .getResultList()
                .stream()
                .findAny();
    }
}
