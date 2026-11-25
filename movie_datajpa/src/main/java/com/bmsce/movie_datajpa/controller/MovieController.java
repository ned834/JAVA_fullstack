package com.bmsce.movie_datajpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.bmsce.movie_datajpa.entity.Movie;
import com.bmsce.movie_datajpa.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    // Constructor Injection
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/{movieId}",
                    method = RequestMethod.GET)
    public Movie getMovieById(
            @PathVariable Integer movieId) {

        return movieService.getMovieById(movieId);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getAllMovies() {

        return movieService.getAllMovies();
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(
            @RequestBody Movie movie) {

        Movie savedMovie = movieService.addMovie(movie);

        return new ResponseEntity<>(
                savedMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> updateMovie(
            @PathVariable Integer movieId,
            @RequestBody Movie movie) {

        if (!movieId.equals(movie.getMovieId())) {

            return ResponseEntity.badRequest().build();
        }

        Movie updatedMovie =
                movieService.updateMovie(movieId, movie);

        return new ResponseEntity<>(
                updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(
            @PathVariable Integer movieId) {

        movieService.deleteMovie(movieId);

        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT);
    }
}