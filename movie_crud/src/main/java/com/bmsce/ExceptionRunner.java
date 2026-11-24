package com.bmsce;

import com.bmsce.service.MovieValidationService;
import com.bmsce.entity.Movie;
import com.bmsce.exception.InvalidMovieException;

public class ExceptionRunner {

    public static void main(String[] args) {

        MovieValidationService service =
                new MovieValidationService();

        Movie movie1 = new Movie(
                101,
                "Interstellar",
                "Christopher Nolan",
                "Sci-Fi",
                8.7,
                2014
        );

        Movie movie2 = new Movie(
                102,
                "Inception",
                "Christopher Nolan",
                "Thriller",
                15.0,
                2010
        );

        try {

            service.validateMovie(movie1);

            System.out.println(
                    "Movie 1 validation successful"
            );

            service.validateMovie(movie2);

            System.out.println(
                    "Movie 2 validation successful"
            );

        } catch (InvalidMovieException e) {

            System.out.println(
                    "Validation Error: " + e.getMessage()
            );
        }

        System.out.println("Program completed");
    }
}
