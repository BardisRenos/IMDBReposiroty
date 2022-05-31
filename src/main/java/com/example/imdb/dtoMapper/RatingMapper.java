package com.example.imdb.dtoMapper;

import com.example.imdb.dto.RatingDTO;
import com.example.imdb.entities.TitleBasics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingMapper {

    /**
     * This method convert a list of titleBasics to a list of RatingDTO
     * @param titleBasics A list of TitleBasics objects.
     * @return A list of RatingDTOs.
     */
    public static List<RatingDTO> convertEntitiesToDTOs(List<TitleBasics>  titleBasics){
        List<RatingDTO> list = new ArrayList<>();

        for(TitleBasics index:titleBasics){
            RatingDTO ratingDTO = new RatingDTO();
            ratingDTO.setRating((int) (index.getRating().getNumVotes()/index.getRating().getAverageRating()));
            ratingDTO.setNameMovie(index.getPrimaryTitle());
            ratingDTO.setCategory(index.getGenres());

            list.add(ratingDTO);
        }

        return list;
    }
}
