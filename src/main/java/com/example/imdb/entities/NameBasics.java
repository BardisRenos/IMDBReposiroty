package com.example.imdb.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "name_basics")
public class NameBasics {

    /**
     * The entities of the name_basics database table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private String nconst;
    @Column(name = "primaryname")
    private String primaryName;
    @Column(name = "birthyear")
    private Integer birthYear;
    @Column(name = "deathyear")
    private Integer deathYear;
    @Column(name = "primaryprofession")
    private String primaryProfession;
    @Column(name = "knownfortitles")
    private String knownForTitles;

    @OneToMany
    @JoinTable(name = "title_principals",
            joinColumns = @JoinColumn(name = "nconst"),
            inverseJoinColumns = @JoinColumn(name = "tconst"))
    private List<TitleBasics> movies;

}
