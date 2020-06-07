package com.aditprayogo.moviedb_mvp.main

import com.aditprayogo.moviedb_mvp.model.MovieResponse
import com.aditprayogo.moviedb_mvp.network.ApiRepository
import com.aditprayogo.moviedb_mvp.network.TMDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Request ke api
 */
class MainPresenter(private val view: MainView, private val apiRepository: ApiRepository, private val gson: Gson){
    fun getMovieList() {
        doAsync {

            val data = gson.fromJson(apiRepository.doRequest(TMDBApi.getMovie()),
                MovieResponse::class.java)

            //Taruh ke UI thread
            uiThread {
                view.showMovieList(data.results)
            }
        }

    }
}