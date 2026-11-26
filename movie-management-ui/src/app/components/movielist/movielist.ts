import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { MovieModel } from '../../movie';
import { MovieService } from '../../services/movie';

@Component({
  selector: 'app-movielist',
  standalone: false,
  templateUrl: './movielist.html',
  styleUrl: './movielist.css',
})
export class Movielist {

  movies$: Observable<MovieModel[]>;

  constructor(private movieService: MovieService) {

    this.movies$ = this.movieService.getAllMovies();

  }

  deleteMovie(movieId: number): void {

    this.movieService.deleteMovie(movieId);

  }
}