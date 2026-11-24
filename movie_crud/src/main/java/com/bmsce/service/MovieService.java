package com.bmsce.service;

import java.util.ArrayList;

import com.bmsce.entity.Movie;
import com.bmsce.exception.*;

public class MovieService {

    private ArrayList<Movie> movieList =
            new ArrayList<Movie>();

    private MovieValidationService validationService =
            new MovieValidationService();

    public void addMovie(Movie movie)
            throws InvalidMovieException, DuplicateMovieException {

        validationService.validateMovie(movie);

        for (Movie existingMovie : movieList) {

            if (existingMovie.getMovieId()
                    == movie.getMovieId()) {

                throw new DuplicateMovieException(
                        "Movie ID already exists: "
                                + movie.getMovieId()
                );
            }
        }

        movieList.add(movie);

        System.out.println("Movie added successfully");
    }

    // READ - Get Movie By ID

    public Movie getMovieById(int movieId)
            throws MovieNotFoundException {

        for (Movie movie : movieList) {

            if (movie.getMovieId() == movieId) {

                return movie;
            }
        }

        throw new MovieNotFoundException(
                "Movie not found with ID: " + movieId
        );
    }

    // READ - Get All Movies

    public ArrayList<Movie> getAllMovies() {

        return movieList;
    }

    // UPDATE

    public void updateMovie(int movieId,
                            String movieName,
                            String director,
                            String genre,
                            double rating,
                            int releaseYear)
            throws MovieNotFoundException, InvalidMovieException {

        Movie existingMovie = getMovieById(movieId);

        Movie updatedMovie = new Movie(
                movieId,
                movieName,
                director,
                genre,
                rating,
                releaseYear
        );

        validationService.validateMovie(updatedMovie);

        existingMovie.setMovieName(movieName);
        existingMovie.setDirector(director);
        existingMovie.setGenre(genre);
        existingMovie.setRating(rating);
        existingMovie.setReleaseYear(releaseYear);

        System.out.println("Movie updated successfully");
    }

    // DELETE

    public void deleteMovie(int movieId)
            throws MovieNotFoundException {

        Movie movie = getMovieById(movieId);

        movieList.remove(movie);

        System.out.println("Movie deleted successfully");
    }
}