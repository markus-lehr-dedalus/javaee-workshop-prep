package com.dedalus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class GreetingEntity extends PanacheEntity {
    private String phrase;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String field) {
        this.phrase = field;
    }
}
