package com.example.Imdb.service;

import com.example.Imdb.dal.MovieRepository;
import com.example.Imdb.dto.MoviesEntitiesDTO;
import com.example.Imdb.dto.RatingDTO;
import com.example.Imdb.dtoMapper.MovieEntitiesMapper;
import com.example.Imdb.dtoMapper.RatingMapper;
import com.example.Imdb.entities.TitleBasics;
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
    public List<MoviesEntitiesDTO> getMovieByOriTitleOrPrimTitle(String title){
        List<TitleBasics> res = movieRepository.findByTitle(title);

        return MovieEntitiesMapper.convertTitlePrincipalEntitiesToDTO(res);
    }

    /**
     * This methode returns a list of movies by genre and with the rating that has.
     * @param category The category of the movie
     * @param limit The limit number indicates the size of the return rows.
     * @return A list of RatingDTO objects.
     */
    public List<RatingDTO> getCategoryOfMoviesByRatings(String category, int limit){
        List<TitleBasics> res = movieRepository.findByGenreOrderByRatingLimit(category, limit);

        return RatingMapper.convertEntitiesToDTO(res);
    }
}
