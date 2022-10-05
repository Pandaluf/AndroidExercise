package com.example.android.xtrememovieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.xtrememovieapp.R
import com.example.android.xtrememovieapp.database.MovieDB
import com.example.android.xtrememovieapp.models.Movie
import kotlinx.android.synthetic.main.prototype_movie.view.*

class MovieAdapter(private val movies: List<Movie>, private val context: Context): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvTitle=view.tvFavoriteTitle
        val tvOverview=view.tvFavoriteOverview
        val tvPopularity=view.tvPopularity
        val faFavorite=view.faFavorite
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context)
            .inflate(R.layout.prototype_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie=movies[position]
        holder.tvTitle.text=movie.title
        holder.tvOverview.text=movie.overview
        holder.tvPopularity.text=movie.popularity.toString()
        holder.faFavorite.setOnClickListener{
            saveMovie(movie)
        }
    }

    private fun saveMovie(movie: Movie) {
        MovieDB.getInstance(this.context).getMovieDAO().insertMovie(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}