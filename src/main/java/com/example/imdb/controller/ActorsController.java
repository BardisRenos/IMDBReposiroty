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

    @GetMapping("/actor1/{actor1}/actor2/{actor2}/movies")
    public TitleBasicDTO getMoviesAndTvShowsByActors(@PathVariable(value="actor1") String actor1, @PathVariable(value="actor2") String actor2) {
        return actorService.getMoviesByActors(actor1, actor2);
    }

}
