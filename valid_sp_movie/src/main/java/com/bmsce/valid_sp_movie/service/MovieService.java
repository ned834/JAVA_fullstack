package com.bmsce.valid_sp_movie.service;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.bmsce.valid_sp_movie.entity.Movie;
import com.bmsce.valid_sp_movie.exception.MovieNotFoundException;
import com.bmsce.valid_sp_movie.exception.DuplicateMovieException;
import com.bmsce.valid_sp_movie.exception.InvalidMovieException;

@Service
public class MovieService {

    // HashSet to store Movie objects
    private Set<Movie> movieSet = new HashSet<>();

    // Validate business rules
    private void validateMovie(Movie movie) throws InvalidMovieException {

        if (movie == null) {
            throw new InvalidMovieException("Movie details cannot be null");
        }

        if (movie.getMovieId() <= 0) {
            throw new InvalidMovieException("Movie ID must be positive");
        }

        if (movie.getRating() < 0 || movie.getRating() > 10) {

            throw new InvalidMovieException(
                "Movie rating must be between 0 and 10");
        }

        if (movie.getReleaseYear() < 1888) {

            throw new InvalidMovieException(
                "Release year must be 1888 or later");
        }
    }

    // CREATE
    public Movie addMovie(Movie movie) throws InvalidMovieException, DuplicateMovieException {

        validateMovie(movie);

        boolean isAdded = movieSet.add(movie);

        if (!isAdded) {
            throw new DuplicateMovieException(
                "Movie already exists with ID: " + movie.getMovieId());
        }

        return movie;
    }

    // GET BY ID
    public Movie getMovieById(Integer movieId) throws MovieNotFoundException {

        for (Movie movie : movieSet) {

            if (Objects.equals(movie.getMovieId(), movieId)) {
                return movie;
            }
        }

        throw new MovieNotFoundException(
            "Movie not found with ID: " + movieId);
    }

    // GET ALL
    public Set<Movie> getAllMovies() {

        // Return a copy to protect the internal HashSet
        return new HashSet<>(movieSet);
    }

    // UPDATE
    public Movie updateMovie(Integer movieId, Movie updatedMovie)
            throws InvalidMovieException, MovieNotFoundException {

        validateMovie(updatedMovie);

        if (!Objects.equals(movieId, updatedMovie.getMovieId())) {
            throw new InvalidMovieException(
                "URL Movie ID and JSON Movie ID must be the same");
        }

        Movie existingMovie = getMovieById(movieId);

        // Do not modify movieId because it is used by HashSet
        existingMovie.setMovieName(updatedMovie.getMovieName());
        existingMovie.setDirector(updatedMovie.getDirector());
        existingMovie.setGenre(updatedMovie.getGenre());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setReleaseYear(updatedMovie.getReleaseYear());

        return existingMovie;
    }

    // DELETE
    public void deleteMovie(Integer movieId) throws MovieNotFoundException {

        Movie existingMovie = getMovieById(movieId);

        movieSet.remove(existingMovie);
    }
}


