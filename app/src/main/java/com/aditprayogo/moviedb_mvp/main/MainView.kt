package com.aditprayogo.moviedb_mvp.main

import com.aditprayogo.moviedb_mvp.model.Movie

interface MainView {
    fun showMovieList(data: List<Movie>)
}