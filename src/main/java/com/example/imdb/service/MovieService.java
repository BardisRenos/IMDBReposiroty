package com.example.imdb.service;

import com.example.imdb.dao.MovieRepository;
import com.example.imdb.dto.MoviesEntitiesDTO;
import com.example.imdb.dto.RatingDTO;
import com.example.imdb.dtoMapper.MovieEntitiesMapper;
import com.example.imdb.dtoMapper.RatingMapper;
import com.example.imdb.entities.TitleBasics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Movie service layer.
 */
@Service
public class MovieService {


    private final MovieRepository movieRepository;

    /**
     * MovieService Constructor
     * @param movieRepository MovieRepository
     */
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * This method return a movie by a given title. Also, has the cast of each one of them.
     * @param title The title is the movie title that a user search.
     * @return A MoviesEntitiesDTO objects.
     */
    public List<MoviesEntitiesDTO> getMovieByOriTitleOrPrimTitle(String title) {
        List<TitleBasics> res = movieRepository.findByTitle(title);

        return MovieEntitiesMapper.convertTitlePrincipalEntitiesToDTOs(res);
    }

    /**
     * This methode returns a list of movies by genre and with the rating that has.
     * @param category The category of the movie
     * @param limit The limit number indicates the size of the return rows.
     * @return A list of RatingDTO objects.
     */
    public List<RatingDTO> getCategoryOfMoviesByRatings(String category, int limit) {
        List<TitleBasics> res = movieRepository.findByGenreOrderByRatingLimit(category, limit);

        return RatingMapper.convertEntitiesToDTOs(res);
    }

    /**
     *
     * @param category
     * @param year
     * @return
     */
    public List<RatingDTO> getMoviesByGenreAndByYear(String category, int year) {
        List<TitleBasics> res = movieRepository.findMoviesByGenreAndByYear(category, year);

        return RatingMapper.convertEntitiesToDTOs(res);
    }

}
