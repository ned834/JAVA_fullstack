package com.bmsce;

import java.util.logging.Logger;
import java.util.logging.Level;

import com.bmsce.entity.Movie;
import com.bmsce.service.MovieService;
import com.bmsce.exception.*;

public class MovieLoggingRunner {

    private static final Logger logger =
            Logger.getLogger(MovieLoggingRunner.class.getName());

    public static void main(String[] args) {

        MovieService service = new MovieService();

        logger.info("Movie application started");

        try {

            logger.info("Adding movie");

            service.addMovie(new Movie(
                    101, "Interstellar",
                    "Christopher Nolan", "Sci-Fi",
                    8.7, 2014
            ));

            logger.info("Movie added successfully");

            logger.info("Searching movie");

            Movie movie = service.getMovieById(101);

            logger.info("Movie retrieved: " + movie);

            logger.info("Searching invalid movie");

            service.getMovieById(999);

        } catch (InvalidMovieException |
                 DuplicateMovieException |
                 MovieNotFoundException e) {

            logger.log(
                    Level.SEVERE,
                    "Movie operation failed",
                    e
            );
        }

        finally {

            logger.info("Movie application execution completed");
        }
    }
}

