package com.example.Imdb.dtoMapper;

import com.example.Imdb.dto.MoviesEntitiesDTO;
import com.example.Imdb.dto.TitlePrincipalDTO;
import com.example.Imdb.entities.NameBasics;
import com.example.Imdb.entities.TitleBasics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieEntitiesMapper {

    /**
     * This method converts the titleBasic entities to MoviesEntitiesDTO.
     * @param titleBasics Is a TitleBasics object as parameter in order to be converted.
     * @return A MoviesEntitiesDTO object.
     */


//    public static MoviesEntitiesDTO convertTitlePrincipalEntitiesToDTO(TitleBasics titleBasics){
//
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(titleBasics, MoviesEntitiesDTO.class);
//
//    }

    public static List<MoviesEntitiesDTO> convertTitlePrincipalEntitiesToDTOs(List<TitleBasics> titleBasics){

        List<MoviesEntitiesDTO> moviesEntitiesDTOList = new ArrayList<>();
//        List<TitlePrincipalDTO> titlePrincipalDTOList = new ArrayList<>();

        for (TitleBasics title : titleBasics) {
            MoviesEntitiesDTO moviesEntitiesDTO = new MoviesEntitiesDTO();
            moviesEntitiesDTO.setTitleType(title.getTitleType());
            moviesEntitiesDTO.setPrimaryTitle(title.getPrimaryTitle());
            moviesEntitiesDTO.setOriginalTitle(title.getOriginalTitle());
            moviesEntitiesDTO.setIsAdult(title.getIsAdult());

            moviesEntitiesDTO.setStartYear(title.getStartYear());
            moviesEntitiesDTO.setEndYear(title.getEndYear());
            moviesEntitiesDTO.setRunTimeMinutes(title.getRuntimeMinutes());
            moviesEntitiesDTO.setGenres(title.getGenres());

            List<TitlePrincipalDTO> titlePrincipalDTOList = new ArrayList<>();
            for (NameBasics peer : title.getPeople()) {
                TitlePrincipalDTO principalDTO = new TitlePrincipalDTO();
                principalDTO.setPrimaryName(peer.getPrimaryName());
                titlePrincipalDTOList.add(principalDTO);

                moviesEntitiesDTO.setCast(titlePrincipalDTOList);
            }
            moviesEntitiesDTOList.add(moviesEntitiesDTO);
        }
        return moviesEntitiesDTOList;
    }
}
