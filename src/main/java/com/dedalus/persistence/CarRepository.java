package com.dedalus.persistence;

import com.dedalus.entity.CarEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CarRepository {
    @Inject
    EntityManager entityManager;

    public CarEntity save(CarEntity car) {
        entityManager.persist(car);
        return car;
    }

    public List<CarEntity> getAll() {
        return entityManager
                .createQuery("select car from CAR car", CarEntity.class)
                .getResultList();
    }
}
