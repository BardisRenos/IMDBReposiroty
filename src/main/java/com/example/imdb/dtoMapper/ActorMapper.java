package com.example.imdb.dtoMapper;

import com.example.imdb.dto.ActorsMoviesEntitiesDTO;
import com.example.imdb.dto.TitleBasicDTO;
import com.example.imdb.entities.NameBasics;
import com.example.imdb.entities.TitleBasics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorMapper {

    public static TitleBasicDTO convertTitleBasicsToDTOs(List<NameBasics> nameBasics) {

        TitleBasicDTO titleBasicDTO = new TitleBasicDTO();

        titleBasicDTO.setPrimaryName1(nameBasics.get(0).getPrimaryName());
        titleBasicDTO.setPrimaryName2(nameBasics.get(1).getPrimaryName());

        List<ActorsMoviesEntitiesDTO> moviesEntitiesDTOList = new ArrayList<>();

        List<TitleBasics> actor1List = nameBasics.get(0).getMovies();
        List<TitleBasics> actor2List = nameBasics.get(1).getMovies();

        actor1List.retainAll(actor2List);

        for (TitleBasics movies : actor1List) {
            ActorsMoviesEntitiesDTO moviesEntitiesDTO = new ActorsMoviesEntitiesDTO();
            moviesEntitiesDTO.setPrimaryTitle(movies.getPrimaryTitle());
            moviesEntitiesDTO.setStartYear(movies.getStartYear());
            moviesEntitiesDTO.setTitleType(movies.getTitleType());
            moviesEntitiesDTOList.add(moviesEntitiesDTO);

            titleBasicDTO.setMovies(moviesEntitiesDTOList);
        }

        return titleBasicDTO;
    }
}
