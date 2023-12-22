package com.example.example.persistence.model;

import com.example.example.persistence.dao.ActorDAO;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Connection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "actors_movies")
@Data
public class CharacterMovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    ActorEntity actorEntity;
    @Column(name = "characters")
    String characterActor;

}


