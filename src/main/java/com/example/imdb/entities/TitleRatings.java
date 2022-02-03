package com.example.imdb.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
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
