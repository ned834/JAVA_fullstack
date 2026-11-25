package com.bmsce.movie_datajpa.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String message) {

        super(message);
    }
}