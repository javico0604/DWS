package com.example.example.controller;

import com.example.example.controller.model.characterMovie.CharacterMovieCreateWeb;
import com.example.example.controller.model.characterMovie.CharacterMovieListWeb;
import com.example.example.controller.model.movie.MovieCreateWeb;
import com.example.example.controller.model.movie.MovieDetailWeb;
import com.example.example.controller.model.movie.MovieListWeb;
import com.example.example.controller.model.movie.MovieUpdateWeb;
import com.example.example.domain.entity.Movie;
import com.example.example.domain.service.MovieService;
import com.example.example.http_response.Response;
import com.example.example.mapper.CharacterMovieMapper;
import com.example.example.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Value("${default.page.size}")
    private Integer LIMIT;

    @Value("${application.url}")
    private String urlBase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        pageSize = (pageSize != null)? pageSize : LIMIT;
        List<Movie> movies = (pageSize != null)? movieService.getAll(page, pageSize) : movieService.getAll();
        List<MovieListWeb> moviesWeb = movies.stream()
                .map(movie -> MovieMapper.mapper.toMovieListWeb(movie))
                .toList();
        long totalRecords = movieService.getTotalNumberOfRecords();

        Response response = new Response(moviesWeb, totalRecords);
        if(page != null){
            response.paginate(page, pageSize, urlBase);
        }
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response find(@PathVariable("id") int id) {
        MovieDetailWeb movieDetailWeb = MovieMapper.mapper.toMovieDetailWeb(movieService.find(id));
        Response movie = new Response(movieDetailWeb);
        return movie;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response create(@RequestBody MovieCreateWeb movieCreateWeb){
        int id = movieService.create(
                MovieMapper.mapper.toMovie(movieCreateWeb),
                movieCreateWeb.getDirectorId(),
                movieCreateWeb.getCharacters()
        );
        MovieListWeb movieListWeb = new MovieListWeb();
        movieListWeb.setTitle(movieCreateWeb.getTitle());
        movieListWeb.setId(id);
        return new Response(movieListWeb);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public Response update(@RequestBody MovieUpdateWeb movieUpdateWeb, @PathVariable("id") int id){
        movieUpdateWeb.setId(id);
        movieService.update(
                MovieMapper.mapper.toMovie(movieUpdateWeb),
                movieUpdateWeb.getDirectorId(),
                movieUpdateWeb.getCharacters()
        );
        MovieListWeb movieListWeb = new MovieListWeb();
        movieListWeb.setId(id);
        movieListWeb.setTitle(movieUpdateWeb.getTitle());
        return new Response(movieListWeb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        movieService.delete(id);
    }
}