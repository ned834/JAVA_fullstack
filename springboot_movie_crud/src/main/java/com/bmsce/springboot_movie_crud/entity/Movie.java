package com.bmsce.springboot_movie_crud.entity;

import java.util.Objects;

public class Movie {

    private int movieId;
    private String movieName;
    private String director;
    private String genre;
    private double rating;
    private int releaseYear;

    // Default Constructor
    public Movie() {
    }

    // Parameterized Constructor
    public Movie(int movieId, String movieName, String director, String genre, double rating, int releaseYear) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.director = director;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    // Getters and Setters

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    // equals() based on movieId

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Movie movie = (Movie) obj;

        return movieId == movie.movieId;
    }

    // hashCode() based on movieId

    @Override
    public int hashCode() {

        return Objects.hash(movieId);
    }

    // toString()

    @Override
    public String toString() {

        return "Movie [movieId=" + movieId
                + ", movieName=" + movieName
                + ", director=" + director
                + ", genre=" + genre
                + ", rating=" + rating
                + ", releaseYear=" + releaseYear + "]";
    }
}
