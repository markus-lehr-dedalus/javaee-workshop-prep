package com.dedalus.persistence;

import com.dedalus.entity.CountryEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class CountryRepository {
    @Inject
    EntityManager em;

    public CountryEntity save(CountryEntity country) {
        em.persist(country);
        return country;
    }

    public List<CountryEntity> getAll() {
        TypedQuery<CountryEntity> query = em.createQuery("SELECT c FROM CountryEntity c", CountryEntity.class);
        return query.getResultList();
    }

    public CountryEntity findById(Long countryId) {
        return em.find(CountryEntity.class, countryId);
    }
}
