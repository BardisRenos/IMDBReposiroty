package com.example.imdb.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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
