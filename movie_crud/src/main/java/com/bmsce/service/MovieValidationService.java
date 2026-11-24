package com.bmsce.service;

import com.bmsce.entity.Movie;
import com.bmsce.exception.InvalidMovieException;

public class MovieValidationService {

    public void validateMovie(Movie movie)
            throws InvalidMovieException {

        if (movie == null) {

            throw new InvalidMovieException(
                    "Movie object cannot be null"
            );
        }

        if (movie.getMovieId() <= 0) {

            throw new InvalidMovieException(
                    "Movie ID must be greater than zero"
            );
        }

        if (movie.getMovieName() == null ||
                movie.getMovieName().trim().isEmpty()) {

            throw new InvalidMovieException(
                    "Movie name cannot be empty"
            );
        }

        if (movie.getRating() < 0 ||
                movie.getRating() > 10) {

            throw new InvalidMovieException(
                    "Rating must be between 0 and 10"
            );
        }

        if (movie.getReleaseYear() <= 0) {

            throw new InvalidMovieException(
                    "Invalid release year"
            );
        }
    }
}


