package com.example.imdb.service;

import com.example.imdb.dao.NameRepository;
import com.example.imdb.dto.NameDTO;
import com.example.imdb.dtoMapper.NameMapper;
import com.example.imdb.entities.NameBasics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NameService {

    Logger logger = LoggerFactory.getLogger(NameService.class);

    @Autowired
    private NameRepository nameRepository;

    String sourceActor;
    String targetActor = "Kevin Bacon";
    List<List<String>> listOfActorsList = new ArrayList<>();


    public NameDTO getMoviesByActor(String actorName) {
        sourceActor = actorName;

        NameBasics res = nameRepository.findListOfMoviesByPrimaryName(actorName);
        NameDTO nameDTO = NameMapper.convertDataToDTOs(res);


        HashMap<String, List<NameBasics>> listOfMovies = nameDTO.getMoviesWithActors();
        int sumOfIndex = listOfMovies.size();
        int startIndex = 0;
//        for (Map.Entry me : hmap.entrySet())

//        for (int movies = 0; movies<listOfMovies.size(); movies++) {
//            for (int actors = 0; actors < listOfMovies.get(movies).getPeople().size(); actors++) {
//                    if (listOfMovies.get(movies).getPeople().get(actors).getPrimaryName().equals(targetActor)) {
//                        logger.info("Find the actor: "+ sourceActor+" at the movie : "+ listOfMovies.get(movies).getPrimaryTitle()+" with : "+ targetActor);
//                }
//            }
//        }
//
//        for (TitleBasics movies:listOfMovies) {
//            for (NameBasics coActors: movies.getPeople()) {
//                if (coActors.getPrimaryName().equals(targetActor)) {
//                    logger.info("Find the actor: "+ sourceActor + " from the movie "+ movies.getPrimaryTitle() + " and the type is : "+ movies.getTitleType()+ " to "+targetActor);
//                }
//            }
//        }

//        getMoviesByActor(listOfMovies.get(startIndex).getPeople().get(startIndex).getPrimaryName());

//        if (startIndex<=sumOfIndex){
//            getMoviesByActor(listOfMovies.get(startIndex).getPeople().get(startIndex).getPrimaryName());
//            startIndex++;
//        }
//        listOfActorsList.add(actors);

//        if (checkTheActor(actors, targetActor)){
//            return nameDTO;
//        } else {
//            getMoviesByActor(listOfActorsList.get(0).get(0));
//        }

        return nameDTO;
    }

//    private List<String> retrieveActors(String actorName) {
//        NameBasics res = nameRepository.findListOfMoviesByPrimaryName(actorName);
//        NameDTO nameDTO = NameMapper.convertDataToDTOs(res);
//        return nameDTO.getCoActors();
//    }

    private boolean checkTheActor(List<String> setOfActorNames, String targetActor) {

        if (setOfActorNames.contains(targetActor)) {
            logger.info("Found the actor from "+ sourceActor + "to the actor: "+ targetActor );
        }
        return setOfActorNames.contains(targetActor);
    }

}
