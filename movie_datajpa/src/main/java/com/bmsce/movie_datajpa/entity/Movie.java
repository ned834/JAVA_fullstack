package com.bmsce.movie_datajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private Integer movieId;

    @Column(nullable = false)
    private String movieName;

    private String director;

    private String genre;

    private Double rating;

    private Integer releaseYear;

    // Default Constructor
    public Movie() {
    }

    // Parameterized Constructor
    public Movie(Integer movieId, String movieName, String director, String genre, Double rating, Integer releaseYear) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.director = director;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    // Getters and Setters

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}



