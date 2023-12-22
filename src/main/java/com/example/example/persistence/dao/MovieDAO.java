package com.example.example.persistence.dao;

import com.example.example.db.DBUtil;
import com.example.example.mapper.MovieMapper;
import com.example.example.persistence.model.CharacterMovieEntity;
import com.example.example.persistence.model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public interface MovieDAO extends JpaRepository<MovieEntity, Integer> {
    @Modifying
    @Query(value = "INSERT INTO actors_movies (movie_id, actor_id, characters) VALUES (:movieId, :actorId, :characters)", nativeQuery = true)
    void addCharactersToMovie(@Param("movieId") int movieId, @Param("actorId") int actorId, @Param("characters") String characters);

    List<MovieEntity> findByDirectorEntityId(int directorId);

}
