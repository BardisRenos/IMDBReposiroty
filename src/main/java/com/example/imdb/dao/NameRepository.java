package com.example.imdb.dao;

import com.example.imdb.entities.NameBasics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class NameRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public NameBasics findListOfMoviesByPrimaryName(String primaryName) {
        return entityManager.createQuery("select p from NameBasics p join fetch p.movies r where p.primaryName =: primaryName and r.titleType = :movie", NameBasics.class)
                .setParameter("primaryName", primaryName)
                .setParameter("movie", "movie").getSingleResult();
    }
}
