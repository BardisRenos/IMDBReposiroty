package com.example.imdb.dal;

import com.example.imdb.entities.NameBasics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ActorsRepository {


    @PersistenceContext
    private final EntityManager entityManager;


    public List<NameBasics> findMoviesByActor(String actor1, String actor2) {
        TypedQuery<NameBasics> q1 = entityManager.createQuery("select p from NameBasics p join fetch p.movies r " +
                "where p.primaryName = :actor1 and (r.titleType = :movie or r.titleType like :tv) order by r.startYear", NameBasics.class);

        TypedQuery<NameBasics> q2 = entityManager.createQuery("select p from NameBasics p join fetch p.movies r " +
                "where p.primaryName = :actor2 and (r.titleType = :movie or r.titleType like :tv) order by r.startYear", NameBasics.class);

        q1.setParameter("actor1", actor1);
        q1.setParameter("movie", "movie");
        q1.setParameter("tv", "tv");
        q2.setParameter("actor2", actor2);
        q2.setParameter("movie", "movie");
        q2.setParameter("tv", "tv");

        List<NameBasics> allMovies = new ArrayList<>();
        allMovies.add(q1.getSingleResult());
        allMovies.add(q2.getSingleResult());

        return allMovies;

    }
}
