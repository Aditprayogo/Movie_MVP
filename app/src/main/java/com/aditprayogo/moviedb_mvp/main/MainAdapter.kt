package com.aditprayogo.moviedb_mvp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aditprayogo.moviedb_mvp.BuildConfig.URL_POSTER
import com.aditprayogo.moviedb_mvp.R
import com.aditprayogo.moviedb_mvp.model.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_row.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAdapter(private val movie: List<Movie>,
                  private val listener: (Movie) -> Unit)
    : RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(movie[position], listener)
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(movie: Movie, listener: (Movie) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context).load(URL_POSTER + movie.photo).into(photo)

                title.text = movie.title

                itemView.setOnClickListener{
                    listener(movie)
                }


            }
        }
    }

}

