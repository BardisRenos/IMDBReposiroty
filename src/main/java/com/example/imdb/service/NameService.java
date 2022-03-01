package com.example.imdb.service;


import com.example.imdb.dao.NameRepository;
import com.example.imdb.dto.NameDTO;
import com.example.imdb.dtoMapper.NameMapper;
import com.example.imdb.entities.NameBasics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NameService {

    Logger logger = LoggerFactory.getLogger(NameService.class);

    @Autowired
    private NameRepository nameRepository;


    public NameDTO getMoviesByActor(String actorName) {
        String targetActor = "Kevin Bacon";
        NameBasics res = nameRepository.findListOfMoviesByPrimaryName(actorName);

        NameDTO nameDTO = NameMapper.convertDataToDTOs(res);

        for (int i=0; i<nameDTO.getMovies().size(); i++) {
            for (int j=0; j<nameDTO.getMovies().get(i).getPeople().size(); j++) {
                if (nameDTO.getMovies().get(i).getPeople().get(j).getPrimaryName().equals(targetActor)) {
                    logger.info(new StringBuilder().append("We found the movie that ").append(nameDTO.getActorName()).append(" and ").append(targetActor).append(" played at the movie ").append(nameDTO.getMovies().get(i).getPrimaryTitle()).toString());
                }
            }
        }

        return NameMapper.convertDataToDTOs(res);
    }

}
