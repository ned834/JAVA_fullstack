package com.bmsce.movie_datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmsce.movie_datajpa.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    
}
