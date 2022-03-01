package com.example.imdb.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "title_principals")
@NoArgsConstructor
public class TitlePrincipals {

    /**
     * The entities of the title_principals database table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private String tconst;
    @Column(name = "ordering")
    private Integer ordering;
    @Column(name = "nconst")
    private String nconst;
    @Column(name = "category")
    private String category;
    @Column(name = "job")
    private String job;
    @Column(name = "characters")
    private String characters;

}
