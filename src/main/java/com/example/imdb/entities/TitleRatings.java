package com.example.imdb.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "title_ratings")
@NoArgsConstructor
public class TitleRatings {

    /**
     * The entities of the title_ratings database table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private String tconst;
    @Column(name = "averagerating")
    private float averageRating;
    @Column(name = "numvotes")
    private Integer numVotes;

}
