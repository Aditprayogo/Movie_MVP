package com.aditprayogo.moviedb_mvp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditprayogo.moviedb_mvp.BuildConfig.URL_POSTER
import com.aditprayogo.moviedb_mvp.R
import com.aditprayogo.moviedb_mvp.model.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movie = intent?.getParcelableExtra(EXTRA_MOVIE)
        movie_title.text = movie?.title ?: "Null"

        Glide.with(this)
            .load(URL_POSTER + movie?.photo)
            .into(movie_poster)

    }
}
