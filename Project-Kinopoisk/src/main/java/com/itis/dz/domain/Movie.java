package com.itis.dz.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Marsel on 21.09.2016.
 */

@Entity
@Table
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String genre;

    @Column
    private int year;

    @Column
    private int rating;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_actors",
            joinColumns = @JoinColumn(name = "MOVIE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID"))
    private List<Actor> actors;



    public Movie(String name, String genre, int year) {

    }

    public Movie() {

    }
}
