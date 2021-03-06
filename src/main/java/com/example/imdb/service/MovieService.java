package com.example.imdb.service;

import com.example.imdb.dao.MovieRepository;
import com.example.imdb.dto.MoviesEntitiesDTO;
import com.example.imdb.dto.RatingDTO;
import com.example.imdb.dtoMapper.MovieEntitiesMapper;
import com.example.imdb.dtoMapper.RatingMapper;
import com.example.imdb.entities.TitleBasics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Movie service layer.
 */
@Service
@RequiredArgsConstructor
public class MovieService {


    private final MovieRepository movieRepository;

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
     * This method returns a list of movies with rating and category.
     * @param category The category of the movie.
     * @param year The year of the movie.
     * @return A list of RatingDTO objects.
     */
    public List<RatingDTO> getMoviesByGenreAndByYear(String category, int year) {
        List<TitleBasics> res = movieRepository.findMoviesByGenreAndByYear(category, year);

        return RatingMapper.convertEntitiesToDTOs(res);
    }

}
