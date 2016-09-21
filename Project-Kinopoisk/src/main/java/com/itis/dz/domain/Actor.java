package com.itis.dz.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Marsel on 21.09.2016.
 */

@Entity
@Table
public class Actor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String secondName;

    @Column
    private int year;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "actors")
    private List<Movie> movies;

}
