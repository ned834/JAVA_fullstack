package com.bmsce;

import com.bmsce.entity.Movie;

public class MovieRunner {

    public static void main(String[] args) {

        Movie movie1 = new Movie(
                101,
                "Interstellar",
                "Christopher Nolan",
                "Sci-Fi",
                8.7,
                2014
        );

        System.out.println(movie1);

    
        Movie movie2 = new Movie();

        movie2.setMovieId(102);
        movie2.setMovieName("Inception");
        movie2.setDirector("Christopher Nolan");
        movie2.setGenre("Thriller");
        movie2.setRating(8.8);
        movie2.setReleaseYear(2010);

        System.out.println(movie2);

        // Accessing individual properties

        System.out.println("Movie Name: "
                + movie1.getMovieName());

        System.out.println("Movie Rating: "
                + movie1.getRating());
    }
}
