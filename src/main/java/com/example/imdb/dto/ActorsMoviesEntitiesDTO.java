package com.example.imdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorsMoviesEntitiesDTO {

    private String primaryTitle;
    private Integer startYear;
    private String titleType;
}
