package com.example.imdb.dtoMapper;

import com.example.imdb.dto.NameDTO;
import com.example.imdb.entities.NameBasics;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class NameMapper {

    /**
     * This method converts a NameBasics object into NameDTO one.
     * @param nameBasics The nameBasics class.
     * @return A NameDTO object.
     */
    public static NameDTO convertDataToDTOs(NameBasics nameBasics) {
        NameDTO nameDTO = new NameDTO();
        HashMap<String, List<NameBasics>> listActors = new HashMap<>();
        nameDTO.setActorName(nameBasics.getPrimaryName());

        for (int i = 0; i<nameBasics.getMovies().size(); i++) {
            if (!nameBasics.getMovies().get(i).getPeople().get(i).equals(nameBasics.getPrimaryName())) {
                listActors.put(nameBasics.getMovies().get(i).getPrimaryTitle(), nameBasics.getMovies().get(i).getPeople());
            }
        }
        nameDTO.setMoviesWithActors(listActors);

        return nameDTO;
    }
}
