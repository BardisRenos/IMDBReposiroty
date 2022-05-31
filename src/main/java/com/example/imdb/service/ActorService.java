package com.example.imdb.service;

import com.example.imdb.dao.ActorsRepository;
import com.example.imdb.dao.NameRepository;
import com.example.imdb.dto.TitleBasicDTO;
import com.example.imdb.dtoMapper.ActorMapper;
import com.example.imdb.entities.NameBasics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActorService {

    private ActorsRepository actorsRepository;

    private NameRepository nameRepository;

    @Autowired
    public ActorService(ActorsRepository actorsRepository, NameRepository nameRepository) {
        this.actorsRepository = actorsRepository;
        this.nameRepository = nameRepository;
    }


    public TitleBasicDTO getMoviesByActors(String actor1, String actor2) {
        List<NameBasics> res = actorsRepository.findMoviesByActor(actor1, actor2);

        return ActorMapper.convertTitleBasicsToDTOs(res);
    }

  }