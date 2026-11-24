package com.bmsce.springboot_movie_crud.service;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bmsce.springboot_movie_crud.entity.Movie;

@Service
public class MovieService {

    // HashSet to store Movie objects

    private Set<Movie> movieSet = new HashSet<>();

    // CREATE

    public boolean addMovie(Movie movie) {

        return movieSet.add(movie);
    }

    // READ - Get Movie By ID

    public Movie getMovieById(int movieId) {

        for (Movie movie : movieSet) {

            if (movie.getMovieId() == movieId) {

                return movie;
            }
        }

        return null;
    }

    // READ - Get All Movies

    public Set<Movie> getAllMovies() {

        return movieSet;
    }

    // UPDATE

    public boolean updateMovie(int movieId, Movie updatedMovie) {

        Movie existingMovie = getMovieById(movieId);

        if (existingMovie == null) {

            return false;
        }

        // Update existing object properties

        existingMovie.setMovieName(
                updatedMovie.getMovieName()
        );

        existingMovie.setDirector(
                updatedMovie.getDirector()
        );

        existingMovie.setGenre(
                updatedMovie.getGenre()
        );

        existingMovie.setRating(
                updatedMovie.getRating()
        );

        existingMovie.setReleaseYear(
                updatedMovie.getReleaseYear()
        );

        return true;
    }

    // DELETE

    public boolean deleteMovie(int movieId) {

        Movie movie = getMovieById(movieId);

        if (movie == null) {

            return false;
        }

        movieSet.remove(movie);

        return true;
    }
}