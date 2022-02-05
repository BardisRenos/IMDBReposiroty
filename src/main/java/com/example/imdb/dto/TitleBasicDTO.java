package com.example.imdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitleBasicDTO {

    private String primaryName1;
    private String primaryName2;

    private List<ActorsMoviesEntitiesDTO> movies;
}
