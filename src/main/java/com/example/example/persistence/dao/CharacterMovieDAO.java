package com.example.example.persistence.dao;

import com.example.example.db.DBUtil;
import com.example.example.domain.entity.CharacterMovie;
import com.example.example.mapper.ActorMapper;
import com.example.example.mapper.CharacterMovieMapper;
import com.example.example.persistence.model.ActorEntity;
import com.example.example.persistence.model.CharacterMovieEntity;
import com.example.example.persistence.model.MovieEntity;
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
@Repository
public interface CharacterMovieDAO extends JpaRepository<CharacterMovieEntity, Integer> {

    @Query(value = "select * from actors_movies where movie_id = :movieId", nativeQuery = true)
    List<CharacterMovieEntity> findByMovieId(@Param("movieId") int movieId);
}
