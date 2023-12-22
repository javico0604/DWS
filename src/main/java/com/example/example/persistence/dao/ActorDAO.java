package com.example.example.persistence.dao;

import com.example.example.db.DBUtil;
import com.example.example.domain.entity.Actor;
import com.example.example.mapper.ActorMapper;
import com.example.example.persistence.model.ActorEntity;
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
import java.util.Optional;
@Repository
public interface ActorDAO extends JpaRepository<ActorEntity, Integer> {

    @Query(value = "select a.* from actors a join actors_movies am on a.id = am.actor_id where am.id = :movieId", nativeQuery = true)
    List<Actor> findByMovieId(@Param("movieId") int movieId);
}
