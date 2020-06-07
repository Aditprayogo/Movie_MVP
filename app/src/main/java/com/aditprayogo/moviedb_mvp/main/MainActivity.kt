package com.aditprayogo.moviedb_mvp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.aditprayogo.moviedb_mvp.R
import com.aditprayogo.moviedb_mvp.detail.DetailActivity
import com.aditprayogo.moviedb_mvp.model.Movie
import com.aditprayogo.moviedb_mvp.network.ApiRepository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private var listMovie : MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc_movie.layoutManager = GridLayoutManager(this, 2)

        adapter = MainAdapter(listMovie){
            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_MOVIE, it)
            startActivity(intent)
        }

        rc_movie.adapter = adapter


        presenter = MainPresenter(this, ApiRepository(), Gson())
        presenter.getMovieList()

    }

    override fun showMovieList(data: List<Movie>) {
        listMovie.clear()
        listMovie.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
