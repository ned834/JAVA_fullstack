import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup,Validators} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../../services/movie';
import { MovieModel } from '../../movie';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-updatemovie',
  standalone: false,
  styleUrl: './updatemovie.css',
  templateUrl: './updatemovie.html',
})

export class MovieUpdate implements OnInit{

  movieForm: FormGroup;

  movieId: number = 0;

  movies$!: Observable<MovieModel[]>;

  hasMovieId: boolean = false;

  movieNotFound: boolean = false;


  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
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


  ngOnInit(): void {

    // Read movieId from URL

    this.movieId = Number(
      this.route.snapshot.paramMap.get('movieId')
    );

    // Get existing movie from service

    const movie: MovieModel | undefined =
      this.movieService.getMovieById(this.movieId);


    if (!movie) {

      this.movieNotFound = true;

      return;

    }


    // Populate form with existing movie details

    this.movieForm.patchValue({

      movieName: movie.movieName,

      director: movie.director,

      genre: movie.genre,

      rating: movie.rating,

      releaseYear: movie.releaseYear

    });

  }


  updateMovie(): void {

    if (this.movieForm.invalid) {

      this.movieForm.markAllAsTouched();

      return;

    }


    const updatedDetails = this.movieForm.value;


    const status = this.movieService.updateMovie(

      this.movieId,

      {

        movieName: updatedDetails.movieName,

        director: updatedDetails.director,

        genre: updatedDetails.genre,

        rating: Number(updatedDetails.rating),

        releaseYear: Number(updatedDetails.releaseYear)

      }

    );


    if (status) {

      this.router.navigate(['/movies']);

    } else {

      this.movieNotFound = true;

    }

  }


  cancel(): void {

    this.router.navigate(['/movies']);

  }

}

