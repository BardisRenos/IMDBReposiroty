package com.example.imdb.controller;


import com.example.imdb.dto.MoviesEntitiesDTO;
import com.example.imdb.dto.RatingDTO;
import com.example.imdb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The Controller layer
 */
@RestController()
@RequiredArgsConstructor
public class MoviesController {

    private final MovieService movieService;

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
     * @param limit Is how many records you want to receive.
     * @return A list of RatingDTOs class.
     */
    @GetMapping("/genre/{genre}/movies")
    public List<RatingDTO> getMovieByGenreOrderByRatingLimit(@PathVariable(value= "genre") String genre, @RequestParam(value = "limit", defaultValue = "5") int limit) {
        return movieService.getCategoryOfMoviesByRatings(genre, limit);
    }

    /**
     * Retrieve a list of RatingDTOs by a given category and also the year.
     * @param category The movie category.
     * @param year The year of the movie.
     * @return A list of RatingDTO class.
     */
    @GetMapping("/genre/{category}/movies/{year}")
    public List<RatingDTO> getRatingsByGenreAndByYear(@PathVariable(value="category") String category, @PathVariable(value="year") int year) {
        return movieService.getMoviesByGenreAndByYear(category, year);
    }

}
