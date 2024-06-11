package com.dedalus.animal.persistence;

import com.dedalus.animal.model.AnimalEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AnimalRepository {

    @Inject
    EntityManager em;

    public List<AnimalEntity> findAll() {
        return em.createQuery("SELECT a FROM AnimalEntity a", AnimalEntity.class).getResultList();
    }

    public AnimalEntity merge(AnimalEntity entity) {
        return em.merge(entity);
    }
}
