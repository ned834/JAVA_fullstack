import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import { MovieService } from '../../services/movie';
import { MovieModel } from '../../movie';

@Component({
  selector: 'app-movie-create',
  standalone: false,
  templateUrl: './createmovie.html',
  styleUrl: './createmovie.css',
})
export class MovieCreate {

  movieForm: FormGroup;

  successMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private movieService: MovieService
  ) {

    this.movieForm = this.fb.group({

      movieName: [
        '',
        [Validators.required, Validators.minLength(2)]
      ],

      director: [
        '',
        Validators.required
      ],

      genre: [
        '',
        Validators.required
      ],

      rating: [
        '',
        [
          Validators.required,
          Validators.min(0),
          Validators.max(10)
        ]
      ],

      releaseYear: [
        '',
        [
          Validators.required,
          Validators.min(1888),
          Validators.max(2100)
        ]
      ]

    });

  }

  createMovie(): void {

    // Check whether the form is valid
    if (this.movieForm.invalid) {

      this.movieForm.markAllAsTouched();

      return;
    }

    // Get form values
    const movieDetails = this.movieForm.value;

    // Call MovieService
    const newMovie: MovieModel = this.movieService.addMovie({

      movieName: movieDetails.movieName,
      director: movieDetails.director,
      genre: movieDetails.genre,
      rating: Number(movieDetails.rating),
      releaseYear: Number(movieDetails.releaseYear)

    });

    this.successMessage =
      'Movie created successfully! Movie ID: ' + newMovie.movieId;

    // Reset the form
    this.movieForm.reset();

  }

}
