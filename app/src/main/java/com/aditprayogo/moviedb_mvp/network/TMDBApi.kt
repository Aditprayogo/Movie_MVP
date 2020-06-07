package com.aditprayogo.moviedb_mvp.network

import com.aditprayogo.moviedb_mvp.BuildConfig.API_KEY
import com.aditprayogo.moviedb_mvp.BuildConfig.BASE_URL

object TMDBApi {
    fun getMovie() : String {
        return BASE_URL + API_KEY
    }
}