import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';

import { MovieCreate }
from './components/createmovie/createmovie';

import { Movielist }
from './components/movielist/movielist';

import { Showmovie }
from './components/showmovie/showmovie';

import { MovieUpdate }
from './components/updatemovie/updatemovie';


const routes: Routes = [

  {
    path: '',
    redirectTo: 'movies',
    pathMatch: 'full'
  },

  {
    path: 'movies',
    component: Movielist
  },

  {
    path: 'movie-create',
    component: MovieCreate
  },

  {
    path: 'movie-by-id',
    component: Showmovie
  },

  {
    path: 'movie-update/:movieId',
    component: MovieUpdate
  },

  {
    path: '**',
    redirectTo: 'movies'
  }

];


@NgModule({

  imports: [
    RouterModule.forRoot(routes)
  ],

  exports: [
    RouterModule
  ]

})

export class AppRoutingModule {}

