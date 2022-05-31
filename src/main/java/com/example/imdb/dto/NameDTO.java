package com.example.imdb.dto;

import com.example.imdb.entities.NameBasics;
import com.example.imdb.entities.TitleBasics;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameDTO {

    private String actorName;
    private HashMap<String, List<NameBasics>> moviesWithActors;
//    private List<TitleBasics> coActors;
}
