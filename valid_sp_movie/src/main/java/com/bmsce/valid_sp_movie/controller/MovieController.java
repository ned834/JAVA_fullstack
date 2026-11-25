package com.bmsce.valid_sp_movie.controller;

import java.util.Set;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bmsce.valid_sp_movie.entity.Movie;
import com.bmsce.valid_sp_movie.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // 1. GET MOVIE BY ID
    // Without ResponseEntity
    // Using @RequestMapping

    @RequestMapping(
        value = "/{movieId}",
        method = RequestMethod.GET
    )
    public Movie getMovieById(
            @PathVariable int movieId) throws Exception {

        Movie movie =
                movieService.getMovieById(movieId);

        if (movie == null) {

            throw new org.springframework.web.server
                    .ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Movie not found with ID: " + movieId
            );
        }

        return movie;
    }

    // 2. GET ALL MOVIES
    // Without ResponseEntity
    // Using @RequestMapping

    @RequestMapping(method = RequestMethod.GET)
    public Set<Movie> getAllMovies() {

        return movieService.getAllMovies();
    }

    // 3. CREATE MOVIE
    // Using @PostMapping and ResponseEntity

    @PostMapping
    public ResponseEntity<?> addMovie(
            @Valid @RequestBody Movie movie) throws Exception {

        Movie result =
                movieService.addMovie(movie);

        if (result != null) {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(result);
        }

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Movie ID already exists");
    }

    // 4. UPDATE MOVIE
    // Using @PutMapping and ResponseEntity

    @PutMapping("/{movieId}")
    public ResponseEntity<?> updateMovie(
            @PathVariable int movieId,
            @Valid @RequestBody Movie movie) throws Exception {

        // Prevent updating the primary ID

        if (movie.getMovieId() != movieId) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Movie ID in URL and request body must match");
        }

        Movie result =
                movieService.updateMovie(movieId, movie);

        if (result != null) {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Movie not found with ID: " + movieId);
    }

    // 5. DELETE MOVIE
    // Using @DeleteMapping and ResponseEntity

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(
            @PathVariable int movieId) throws Exception {

        movieService.deleteMovie(movieId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}