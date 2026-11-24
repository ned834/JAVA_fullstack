package com.bmsce;

import java.util.ArrayList;

import com.bmsce.service.MovieService;
import com.bmsce.entity.Movie;
import com.bmsce.exception.*;

public class MovieCRUDRunner {

    public static void main(String[] args) {

        MovieService service = new MovieService();

        try {

            // CREATE

            service.addMovie(new Movie(
                    101, "Interstellar",
                    "Christopher Nolan", "Sci-Fi",
                    8.7, 2014
            ));

            service.addMovie(new Movie(
                    102, "Inception",
                    "Christopher Nolan", "Thriller",
                    8.8, 2010
            ));

            service.addMovie(new Movie(
                    103, "Avatar",
                    "James Cameron", "Sci-Fi",
                    7.9, 2009
            ));

            // READ - Get By ID

            System.out.println("\nGet Movie By ID:");

            Movie movie = service.getMovieById(102);

            System.out.println(movie);

            // READ - Get All

            System.out.println("\nAll Movies:");

            ArrayList<Movie> movies =
                    service.getAllMovies();

            for (Movie m : movies) {

                System.out.println(m);
            }

            // UPDATE

            System.out.println("\nUpdate Movie:");

            service.updateMovie(
                    102,
                    "Inception - Updated",
                    "Christopher Nolan",
                    "Sci-Fi Thriller",
                    9.0,
                    2010
            );

            System.out.println(
                    service.getMovieById(102)
            );

            // DELETE

            System.out.println("\nDelete Movie:");

            service.deleteMovie(103);

            // Display after deletion

            System.out.println("\nMovies After Delete:");

            for (Movie m : service.getAllMovies()) {

                System.out.println(m);
            }

        } catch (InvalidMovieException |
                 DuplicateMovieException |
                 MovieNotFoundException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        finally {

            System.out.println(
                    "\nMovie CRUD execution completed"
            );
        }
    }
}
