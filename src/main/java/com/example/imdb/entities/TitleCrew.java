package com.example.imdb.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "title_crew")
@NoArgsConstructor
public class TitleCrew {

    /**
     * The entities of the title_crew database table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private String tconst;
    @Column(name = "directors")
    private String directors;
    @Column(name = "writers")
    private String writers;

}
