package com.example.android.xtrememovieapp.controllers.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.xtrememovieapp.R
import com.example.android.xtrememovieapp.adapter.MovieAdapter
import com.example.android.xtrememovieapp.adapter.SaveMovieAdapter
import com.example.android.xtrememovieapp.database.MovieDB
import com.example.android.xtrememovieapp.models.Movie
import kotlinx.android.synthetic.main.fragment_favorites.view.*

class FavoritesFragment : Fragment() {
    var movies:List<Movie> = ArrayList()
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movies= MovieDB.getInstance(view.context).getMovieDAO().getAllMovies()
        recyclerView=view.rvMovieSave
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter= SaveMovieAdapter(movies, view.context)
    }
}