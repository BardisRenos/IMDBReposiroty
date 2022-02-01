package com.example.Imdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO {

    private String nameMovie;
    private int rating;
    private String category;

}
