import { Component } from '@angular/core';
import { MovieModel } from '../../movie';
import { MovieService } from '../../services/movie';


/*
@Component({
  selector: 'app-showmovie',
  standalone: false,
  styleUrl: './showmovie.css',
  templateUrl: './showmovie.html',
})
export class Showmovie {}
*/


@Component({
  selector: 'app-movie',
  standalone: false,
  templateUrl: './showmovie.html',
  styleUrl: './showmovie.css',
})
export class Showmovie {

  movieId: number = 0;

  selectedMovie: MovieModel | undefined;

  message: string = '';

  constructor(private movieService: MovieService) {}

  getMovieById(): void {

    this.selectedMovie =
      this.movieService.getMovieById(Number(this.movieId));

    if (this.selectedMovie) {

      this.message = '';

    } else {

      this.message = 'Movie Not Found';

    }
  }
}

