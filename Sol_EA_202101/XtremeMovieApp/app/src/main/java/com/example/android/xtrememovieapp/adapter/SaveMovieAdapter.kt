package com.example.android.xtrememovieapp.adapter

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.android.xtrememovieapp.R
import com.example.android.xtrememovieapp.controllers.activities.MainActivity
import com.example.android.xtrememovieapp.database.MovieDB
import com.example.android.xtrememovieapp.models.Movie
import kotlinx.android.synthetic.main.prototype_movie.view.tvFavoriteOverview
import kotlinx.android.synthetic.main.prototype_movie.view.tvFavoriteTitle
import kotlinx.android.synthetic.main.prototype_save_movie.view.*

class SaveMovieAdapter(private val movies: List<Movie>, private val context: Context): RecyclerView.Adapter<SaveMovieAdapter.ViewHolder>(){
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvTitle=view.tvFavoriteTitle
        val tvOverview=view.tvFavoriteOverview
        val faDelete=view.faDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context)
            .inflate(R.layout.prototype_save_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie=movies[position]
        holder.tvTitle.text=movie.title
        holder.tvOverview.text=movie.overview
        holder.faDelete.setOnClickListener{
            deleteMovie(movie)
        }
    }

    private fun deleteMovie(movie: Movie) {
        MovieDB.getInstance(this.context).getMovieDAO().deleteMovie(movie)
        Toast.makeText(this.context, "Movie deleted, go to popular section to refresh.", Toast.LENGTH_SHORT).show();
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}