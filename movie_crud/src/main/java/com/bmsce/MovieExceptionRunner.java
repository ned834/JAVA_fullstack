package com.bmsce;

import com.bmsce.entity.Movie;
import com.bmsce.service.MovieService;
import com.bmsce.exception.*;

public class MovieExceptionRunner {

    public static void main(String[] args) {

        MovieService service = new MovieService();

        try {

            // Valid movie

            service.addMovie(new Movie(
                    101, "Interstellar",
                    "Christopher Nolan", "Sci-Fi",
                    8.7, 2014
            ));

            // 1. DuplicateMovieException

            service.addMovie(new Movie(
                    101, "Inception",
                    "Christopher Nolan", "Thriller",
                    8.8, 2010
            ));

        } catch (DuplicateMovieException e) {

            System.out.println(
                    "Duplicate Error: " + e.getMessage()
            );

        } catch (InvalidMovieException e) {

            System.out.println(
                    "Invalid Movie: " + e.getMessage()
            );
        }

        try {

            // 2. InvalidMovieException

            service.addMovie(new Movie(
                    102, "Avatar",
                    "James Cameron", "Sci-Fi",
                    15.0, 2009
            ));

        } catch (InvalidMovieException |
                 DuplicateMovieException e) {

            System.out.println(
                    "Validation Error: " + e.getMessage()
            );
        }

        try {

            // 3. MovieNotFoundException

            service.getMovieById(999);

        } catch (MovieNotFoundException e) {

            System.out.println(
                    "Search Error: " + e.getMessage()
            );
        }

        System.out.println("Exception demonstration completed");
    }
}

