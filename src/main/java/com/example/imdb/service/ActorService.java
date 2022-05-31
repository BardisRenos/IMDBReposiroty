package com.example.imdb.service;

import com.example.imdb.dao.ActorsRepository;
import com.example.imdb.dto.TitleBasicDTO;
import com.example.imdb.dtoMapper.ActorMapper;
import com.example.imdb.entities.NameBasics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorsRepository actorsRepository;

    public TitleBasicDTO getMoviesByActors(String actor1, String actor2) {
        List<NameBasics> res = actorsRepository.findMoviesByActor(actor1, actor2);

        return ActorMapper.convertTitleBasicsToDTOs(res);
    }

  }