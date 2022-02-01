package com.example.Imdb.controller;


import com.example.Imdb.dal.MovieRepository;
import com.example.Imdb.dto.MoviesEntitiesDTO;
import com.example.Imdb.dto.RatingDTO;
import com.example.Imdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The Controller layer
 */
@RestController()
public class MoviesController {

    private final MovieService movieService;
    private final MovieRepository movieRepository;

    /**
     * Movie Controller Constructor
     * @param movieService MovieService
     * @param movieRepository MovieRepository
     */
    @Autowired
    public MoviesController(MovieService movieService, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }

    /**
     * Retrieves a MoviesEntitiesDTO by a given movie title.
     * @param title The given movie title.
     * @return A MoviesEntitiesDTO class.
     */
    @GetMapping("/movies")
    public List<MoviesEntitiesDTO> getMovieByTitle(@RequestParam(value="title") String title) {
        return movieService.getMovieByOriTitleOrPrimTitle(title);
    }

    /**
     * Retrieves a list of RatingDTOs by a given genre and also by a limit number.
     * @param genre Is the genre of the movie that some search.
     * @param limit Is the how many records you want to receive.
     * @return A list of RatingDTOs class.
     */
    @GetMapping("/genre/{genre}/movies")
    public List<RatingDTO> getMovieByGenreOrderByRatingLimit(@PathVariable(value= "genre") String genre, @RequestParam(value = "limit", defaultValue = "5") int limit) {
        return movieService.getCategoryOfMoviesByRatings(genre, limit);
    }

    @GetMapping("/genre/{genre}/movie")
    public List<RatingDTO> getRatingsByGenreAndByYear(@PathVariable(value="genre") String genre, @RequestParam(value="year") int year) {
        return movieService.getMoviesByGenreAndByYear(genre, year);
    }

}
