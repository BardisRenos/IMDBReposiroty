package com.example.imdb.controller;

import com.example.imdb.dto.NameDTO;
import com.example.imdb.entities.NameBasics;
import com.example.imdb.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class NameController {

    @Autowired
    private NameService nameService;

    @GetMapping("/movies/byActor")
    public NameDTO getMovieByActor(@RequestParam(value="actorName") String actorName) {
        return nameService.getMoviesByActor(actorName);
    }

}
