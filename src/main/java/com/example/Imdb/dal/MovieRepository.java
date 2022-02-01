package com.example.Imdb.dal;

import com.example.Imdb.entities.TitleBasics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class MovieRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    /**
     * @param title The movie title.
     * @return A list of TitleBasics object.
     */
//    public List<TitleBasics> findByTitle(String title) {
//        List<TitleBasics> q1 = entityManager.createQuery("select p from TitleBasics p join fetch p.people " +
//                "where p.originalTitle = :title", TitleBasics.class)
//                .setParameter("title", title).getResultList();
//
//        List<TitleBasics> q2 = entityManager.createQuery("select p from TitleBasics p join fetch p.people " +
//                "where p.primaryTitle = :title", TitleBasics.class)
//                .setParameter("title", title).getResultList();
//
//
//        Set<TitleBasics> deduplication = new HashSet<>();
//        deduplication.addAll(q1);
//        deduplication.addAll(q2);
//
//        return new ArrayList<>(deduplication);
//    }

    public List<TitleBasics> findByTitle(String title) {
        TypedQuery<TitleBasics> q1 = entityManager.createQuery("select b from TitleBasics b where b.primaryTitle like :input and b.titleType = :movie ", TitleBasics.class);
        q1.setParameter("input", title + "%");
        q1.setParameter("movie", "movie");

//        Set<TitleBasics> deduplication = new HashSet<>();
//        deduplication.addAll(resultsForSearchByPrimaryTitle);

//        return new ArrayList<>(deduplication);
        return q1.getResultList();
    }

    /**
     * @param genre The genre of a movie.
     * @param limit Is the number of the results (records).
     * @return A list of TitleBasic object.
     */
    public List<TitleBasics> findByGenreOrderByRatingLimit(String genre, int limit) {
        return entityManager.createQuery("select p from TitleBasics p join fetch p.rating r " +
                "where p.genres = :genre order by r.numVotes/r.averageRating desc", TitleBasics.class).setMaxResults(limit).setParameter("genre", genre).getResultList();
    }

//    public List<TitleBasics> findByGenreOrderByRatingLimit(String genre, int limit) {
//        TypedQuery<String> q1 = entityManager.createQuery("select r.tconst from TitleRatings r where r.tconst in (select b.tconst from TitleBasics b where b.genres like :input) order by r.averageRating desc", String.class);
//        q1.setParameter("input", "%" + genre + "%");
//
//        List<String> tconsts = q1.setMaxResults(limit).getResultList();
//
//        TypedQuery<TitleBasics> q2 = entityManager.createQuery("select b from TitleBasics b where b.tconst in :tconsts", TitleBasics.class);
//        q2.setParameter("tconsts", tconsts);
//
//        return q2.getResultList();
//    }
}
