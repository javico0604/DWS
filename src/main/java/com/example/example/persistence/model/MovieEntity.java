package com.example.example.persistence.model;

import com.example.example.persistence.dao.CharacterMovieDAO;
import com.example.example.persistence.dao.DirectorDAO;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Connection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "movies")
@Data
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int year;
    private int runtime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private DirectorEntity directorEntity;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "actors_movies")
    private List<ActorEntity> actorEntities;
    */

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    private List<CharacterMovieEntity> characterMovieEntities;

    public MovieEntity(int id, String title, int year, int runtime) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
    }

}
