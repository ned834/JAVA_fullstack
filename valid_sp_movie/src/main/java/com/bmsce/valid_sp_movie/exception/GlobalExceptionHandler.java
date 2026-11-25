package com.bmsce.valid_sp_movie.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bmsce.valid_sp_movie.exception.MovieNotFoundException;
import com.bmsce.valid_sp_movie.exception.DuplicateMovieException;
import com.bmsce.valid_sp_movie.exception.InvalidMovieException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Handle MovieNotFoundException
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMovieNotFound(
            MovieNotFoundException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("error", "Movie Not Found");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(
            error, HttpStatus.NOT_FOUND);
    }

    // 2. Handle DuplicateMovieException
    @ExceptionHandler(DuplicateMovieException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateMovie(
            DuplicateMovieException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("error", "Duplicate Movie");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(
            error, HttpStatus.CONFLICT);
    }

    // 3. Handle InvalidMovieException
    @ExceptionHandler(InvalidMovieException.class)
    public ResponseEntity<Map<String, String>> handleInvalidMovie(
            InvalidMovieException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("error", "Invalid Movie Details");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(
            error, HttpStatus.BAD_REQUEST);
    }

    // 4. Handle JSON validation errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {

            errors.put(
                fieldError.getField(),
                fieldError.getDefaultMessage()
            );
        });

        return new ResponseEntity<>(
            errors, HttpStatus.BAD_REQUEST);
    }

    // 5. Handle invalid JSON and incorrect JSON data types
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidJSON(
            HttpMessageNotReadableException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("error", "Invalid JSON");
        error.put("message",
            "Check JSON syntax and data types");

        return new ResponseEntity<>(
            error, HttpStatus.BAD_REQUEST);
    }

    // 6. Handle incorrect URL parameter types
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("error", "Invalid Parameter");
        error.put("message",
            "Invalid value for parameter: " + ex.getName());

        return new ResponseEntity<>(
            error, HttpStatus.BAD_REQUEST);
    }

    // 7. Handle IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(
            IllegalArgumentException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("error", "Invalid Argument");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(
            error, HttpStatus.BAD_REQUEST);
    }

    // 8. Handle unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllExceptions(
            Exception ex) {

        Map<String, String> error = new HashMap<>();

        error.put("error", "Internal Server Error");
        error.put("message",
            "Something went wrong. Please try again later.");

        return new ResponseEntity<>(
            error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
