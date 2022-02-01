package com.example.Imdb.dtoMapper;

import com.example.Imdb.dto.RatingDTO;
import com.example.Imdb.entities.TitleBasics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingMapper {

    /**
     * This method
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

    public static RatingDTO convertEntitiesToDTO(TitleBasics titleBasics){
        RatingDTO ratingDTO = new RatingDTO();

        ratingDTO.setRating((int) (titleBasics.getRating().getNumVotes()/titleBasics.getRating().getAverageRating()));
        ratingDTO.setNameMovie(titleBasics.getPrimaryTitle());
        ratingDTO.setCategory(titleBasics.getGenres());

        return ratingDTO;
    }
}
