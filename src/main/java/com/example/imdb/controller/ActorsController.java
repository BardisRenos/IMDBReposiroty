package com.example.imdb.controller;

import com.example.imdb.dal.ActorsRepository;
import com.example.imdb.dto.TitleBasicDTO;
import com.example.imdb.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ActorsController {


    private final ActorService actorService;
    private final ActorsRepository actorRepository;

    @Autowired
    public ActorsController(ActorService actorService, ActorsRepository actorRepository) {
        this.actorService = actorService;
        this.actorRepository = actorRepository;
    }

    @GetMapping("/actor1/{actor1}/actor2/{actor2}/movies")
    public TitleBasicDTO getMoviesAndTvShowsByActors(@PathVariable(value="actor1") String actor1, @PathVariable(value="actor2") String actor2) {
        return actorService.getMoviesByActors(actor1, actor2);
    }

}
