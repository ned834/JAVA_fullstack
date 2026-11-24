package com.bmsce.springboot_movie_crud.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bmsce.springboot_movie_crud.entity.Movie;
import com.bmsce.springboot_movie_crud.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // 1. GET MOVIE BY ID
    // Without ResponseEntity
    // Using @RequestMapping

    @RequestMapping(
        value = "/{movieId}",
        method = RequestMethod.GET
    )
    public Movie getMovieById(
            @PathVariable int movieId) {

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
            @RequestBody Movie movie) {

        boolean result =
                movieService.addMovie(movie);

        if (result) {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(movie);
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
            @RequestBody Movie movie) {

        // Prevent updating the primary ID

        if (movie.getMovieId() != movieId) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Movie ID in URL and request body must match");
        }

        boolean result =
                movieService.updateMovie(movieId, movie);

        if (result) {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(movieService.getMovieById(movieId));
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Movie not found with ID: " + movieId);
    }

    // 5. DELETE MOVIE
    // Using @DeleteMapping and ResponseEntity

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(
            @PathVariable int movieId) {

        boolean result =
                movieService.deleteMovie(movieId);

        if (result) {

            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Movie not found with ID: " + movieId);
    }
}