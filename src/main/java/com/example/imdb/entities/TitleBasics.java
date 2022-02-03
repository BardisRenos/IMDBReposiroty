package com.example.imdb.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "title_basics")
public class TitleBasics {

    /**
     * The entities of the title_basics database table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private String tconst;
    @Column(name = "titletype")
    private String titleType;
    @Column(name = "primarytitle")
    private String primaryTitle;
    @Column(name = "originaltitle")
    private String originalTitle;
    @Column(name = "isadult")
    private Boolean isAdult;
    @Column(name = "startyear")
    private Integer startYear;
    @Column(name = "endyear")
    private Integer endYear;
    @Column(name = "runtimeminutes")
    private Integer runtimeMinutes;
    @Column(name = "genres")
    private String genres;

    @ManyToMany
    @JoinTable(name = "title_principals",
            joinColumns = @JoinColumn(name = "tconst"),
            inverseJoinColumns = @JoinColumn(name = "nconst"))
    private List<NameBasics> people;


    @OneToOne
    @JoinColumn(name = "tconst")
    private TitleRatings rating;


}
