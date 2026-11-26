import { Service } from '@angular/core';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { MovieModel } from '../movie';

@Service()
export class Movie {}

@Injectable({
    providedIn: 'root'
})
export class MovieService {

  // Initial dummy collection
private movies: MovieModel[]=
[
    {
        movieId: 101,
        movieName: 'Interstellar',
        director: 'Christopher Nolan',
        genre: 'Science Fiction',
        rating: 8.7,
        releaseYear: 2014
    },
    {
        movieId: 102,
        movieName: 'Inception',
        director: 'Christopher Nolan',
        genre: 'Thriller',
        rating: 8.8,
        releaseYear: 2010
    },
    {
        movieId: 103,
        movieName: 'Titanic',
        director: 'James Cameron',
        genre: 'Romance',
        rating: 7.9,
        releaseYear: 1997
    },
    {
        movieId: 104,
        movieName: 'Avatar',
        director: 'James Cameron',
        genre: 'Science Fiction',
        rating: 7.9,
        releaseYear: 2009
    }
];

  // Shared observable collection
private movieSubject = new BehaviorSubject<MovieModel[]>(this.movies);

  // Components subscribe to this observable
movies$: Observable<MovieModel[]> = this.movieSubject.asObservable();

  // Get all movies
getAllMovies(): Observable<MovieModel[]> {
    return this.movies$;
}

  // Get movie by ID
getMovieById(movieId: number): MovieModel | undefined {

    return this.movies.find(
        movie => movie.movieId === movieId
    );
}

  // Delete movie by ID
deleteMovie(movieId: number): void {

    this.movies = this.movies.filter(
        movie => movie.movieId !== movieId
    );

    // Notify all subscribers about the updated collection
    this.movieSubject.next(this.movies);
}


  // Create movie
addMovie(movieDetails: Omit<MovieModel, 'movieId'>): MovieModel {

    const newId = this.movies.length === 0
        ? 101
        : Math.max(...this.movies.map(movie => movie.movieId)) + 1;

    const newMovie: MovieModel = {
        movieId: newId,
        ...movieDetails
    };

    this.movies = [...this.movies, newMovie];

    // Notify all components about the updated collection
    this.movieSubject.next(this.movies);

    return newMovie;
}

}