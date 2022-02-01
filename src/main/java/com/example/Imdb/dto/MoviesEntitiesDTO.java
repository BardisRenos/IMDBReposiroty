package com.example.Imdb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesEntitiesDTO {

    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runTimeMinutes;
    private String genres;

    private List<TitlePrincipalDTO> cast;

}
