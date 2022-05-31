package com.example.imdb.controller;

import com.example.imdb.dto.NameDTO;
import com.example.imdb.service.NameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
public class NameController {

    private NameService nameService;

    /**
     * Retrieve a NameDTO by given the actor name.
     * @param actorName The given actor name
     * @return A NameDTO class.
     */
    @GetMapping("/movies/byActor")
    public NameDTO getMovieByActor(@RequestParam(value="actorName") String actorName) {
        return nameService.getMoviesByActor(actorName);
    }

}
