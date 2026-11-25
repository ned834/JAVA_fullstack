package com.bmsce.valid_sp_movie.entity;

import java.util.Objects;

import jakarta.validation.constraints.*;

public class Movie {

    @Positive(message = "Movie ID must be greater than zero")
    private int movieId;

    @NotBlank(message = "Movie name cannot be empty")
    @Size(min = 2, max = 100, message = "Movie name must contain 2 to 100 characters")
    private String movieName;

    @NotBlank(message = "Director name cannot be empty")
    @Size(min = 2, max = 100, message = "Director name must contain 2 to 100 characters")
    private String director;

    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @DecimalMin(value = "0.0",
            message = "Rating must be at least 0")
    @DecimalMax(value = "10.0",
            message = "Rating cannot exceed 10")
    private double rating;

    @Min(value = 1888, message = "Release year must be 1888 or later")
    @Max(value = 2100, message = "Release year cannot exceed 2100")
    private int releaseYear;

    public Movie() {
    }

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

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Movie movie = (Movie) obj;

        return movieId == movie.movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }

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
