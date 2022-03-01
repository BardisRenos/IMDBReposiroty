package com.example.imdb.dao;

import com.example.imdb.entities.NameBasics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class NameRepository {

    private EntityManager entityManager;

    @Autowired
    public NameRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public NameBasics findListOfMoviesByPrimaryName(String primaryName) {
        return entityManager.createQuery("select p from NameBasics p join fetch p.movies r where p.primaryName =: primaryName and r.titleType = :movie", NameBasics.class)
                .setParameter("primaryName", primaryName)
                .setParameter("movie", "movie").getSingleResult();
    }
}
