import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing-module';
import { ReactiveFormsModule } from '@angular/forms';
import { App } from './app';
import { Movielist } from './components/movielist/movielist';
import { Showmovie } from './components/showmovie/showmovie';
import { FormsModule } from '@angular/forms';
import { MovieCreate } from './components/createmovie/createmovie';
import { MovieUpdate } from './components/updatemovie/updatemovie';

@NgModule({
  declarations: [App, Movielist, Showmovie, MovieCreate, MovieUpdate],
  imports: [BrowserModule, AppRoutingModule, ReactiveFormsModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App],
})
export class AppModule {}
