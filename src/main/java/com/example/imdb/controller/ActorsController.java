package com.example.imdb.controller;

import com.example.imdb.dto.TitleBasicDTO;
import com.example.imdb.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
public class ActorsController {

    private final ActorService actorService;

    /**
     * This method returns a TitleBasicDTO object of two actors and the list of movies that both are played.
     * @param actor1 The first actor.
     * @param actor2 The second actor.
     * @return A TitleBasicDTO object.
     */
    @GetMapping("/actor1/{actor1}/actor2/{actor2}/movies")
    public TitleBasicDTO getMoviesAndTvShowsByActors(@PathVariable(value="actor1") String actor1, @PathVariable(value="actor2") String actor2) {
        return actorService.getMoviesByActors(actor1, actor2);
    }

}
