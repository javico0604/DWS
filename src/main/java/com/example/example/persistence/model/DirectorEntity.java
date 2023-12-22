package com.example.example.persistence.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "directors")
@Data
public class DirectorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "birthyear")
    private int birthYear;
    @Column(name = "deathyear")
    private Integer deathYear;
}