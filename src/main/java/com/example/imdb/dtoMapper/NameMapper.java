package com.example.imdb.dtoMapper;

import com.example.imdb.dto.NameDTO;
import com.example.imdb.entities.NameBasics;
import com.example.imdb.entities.TitleBasics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class NameMapper {

    public static NameDTO convertDataToDTOs(NameBasics nameBasics) {

        NameDTO nameDTO = new NameDTO();
//        List<TitleBasics> listActors = new ArrayList<>();
        HashMap<String, List<NameBasics>> listActors = new HashMap<>();

        nameDTO.setActorName(nameBasics.getPrimaryName());

        for (int i = 0; i<nameBasics.getMovies().size(); i++) {
            if (!nameBasics.getMovies().get(i).getPeople().get(i).equals(nameBasics.getPrimaryName())) {
                listActors.put(nameBasics.getMovies().get(i).getPrimaryTitle(), nameBasics.getMovies().get(i).getPeople());
            }
//            listActors.add(nameBasics.getMovies().get(i));
        }
        nameDTO.setMoviesWithActors(listActors);


        return nameDTO;
    }
}
