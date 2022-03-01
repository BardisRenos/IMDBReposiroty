package com.example.imdb.dtoMapper;

import com.example.imdb.dto.NameDTO;
import com.example.imdb.entities.NameBasics;
import org.springframework.stereotype.Service;


@Service
public class NameMapper {

    public static NameDTO convertDataToDTOs(NameBasics nameBasics) {

        NameDTO nameDTO = new NameDTO();

        nameDTO.setActorName(nameBasics.getPrimaryName());
        nameDTO.setMovies(nameBasics.getMovies());

        return nameDTO;
    }
}
