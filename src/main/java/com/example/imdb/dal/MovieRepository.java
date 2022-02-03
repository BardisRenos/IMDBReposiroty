package com.example.imdb.dal;

import com.example.imdb.entities.TitleBasics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    /**
     * @param title The movie title.
     * @return A list of TitleBasics object.
     */
    public List<TitleBasics> findByTitle(String title) {
        TypedQuery<TitleBasics> q1 = entityManager.createQuery("select b from TitleBasics b where b.primaryTitle like :input and b.titleType = :movie ", TitleBasics.class);
        q1.setParameter("input", title + "%");
        q1.setParameter("movie", "movie");

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

    /**
     * Retrieve a list of movies by a category and a year
     * @param genre
     * @param year
     * @return
     */
    public List<TitleBasics> findMoviesByGenreAndByYear(String genre, int year) {
        return entityManager.createQuery("select p from TitleBasics p join fetch p.rating r " +
                "where p.genres = :genre and p.startYear = :year order by r.numVotes/r.averageRating desc", TitleBasics.class)
                .setParameter("genre", genre).setParameter("year", year).getResultList();
    }

    /**
     * Retrieve only one title by category and from a specific year
     * @param genre
     * @param year
     * @return
     */
    public TitleBasics findTopRatedMovieByGenreAndYear(String genre, int year) {
        return entityManager.createQuery("select p from TitleBasics p join fetch p.rating r " +
                "where p.genres = :genre and p.startYear = :year order by r.numVotes/r.averageRating desc", TitleBasics.class)
                .setParameter("genre", genre).setParameter("year", year).setMaxResults(1)
                .getSingleResult();
    }

}
